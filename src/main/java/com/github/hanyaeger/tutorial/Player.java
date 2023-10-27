package com.github.hanyaeger.tutorial;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.UpdateExposer;
import com.github.hanyaeger.api.entities.*;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;
import com.github.hanyaeger.api.userinput.KeyListener;
import com.github.hanyaeger.tutorial.collectible.powerup.HeavierPowerup;
import com.github.hanyaeger.tutorial.collectible.powerup.Powerup;
import com.github.hanyaeger.tutorial.collectible.powerup.SpringenPowerup;
import com.github.hanyaeger.tutorial.platforms.Platform;
import com.github.hanyaeger.tutorial.text.Text;
import javafx.geometry.Bounds;
import javafx.scene.input.KeyCode;

import java.util.Set;

public class Player extends DynamicSpriteEntity implements KeyListener, SceneBorderTouchingWatcher, Newtonian, Collider, Collided, UpdateExposer{
    private Text gewichtText;
    private Text inventoryText;
    private boolean springen = false;
    private boolean hoogSpringen = false;
    private Bounds oudBoundingBox;
    private Bounds nieuwBoundingBox;
    private Powerup inventoryPowerup;
    private Powerup usePowerup;
    public int gewicht = 70;

    public Player(Text gewichtText, Text inventoryText, Coordinate2D location) {
        super("sprites/player.png", location, new Size(50, 100), 1, 1);
        this.gewichtText = gewichtText;
        this.inventoryText = inventoryText;

        setGravityConstant(0.5);
        setFrictionConstant(0.04);
    }

    @Override
    public void explicitUpdate(long l) {
        gewichtText.setText("Gewicht: ",gewicht);

        //slaat neiuwe en oude locatie op
        if(getBoundingBox() != nieuwBoundingBox){
            oudBoundingBox = nieuwBoundingBox;
            nieuwBoundingBox = getBoundingBox();
        }
    }

    @Override
    public void onCollision(Collider collider) {
        if (collider instanceof Platform platform) {
            //controleert of player op het platform staat
            //wordt gecontroleer dmv van de oude locatie en de nieuwe locatie en te controleren of het platform daar tussenvalt
            //dit omdat de locatie van player bijna nooit gelijk is aan de locatie van platform
            if((platform.getBoundingBox().getMinY() <= nieuwBoundingBox.getMaxY())
            && (platform.getBoundingBox().getMinY() >= oudBoundingBox.getMaxY())){
                nullifySpeedInDirection(Direction.DOWN);
                setAnchorLocationY(platform.getBoundingBox().getMinY() - getBoundingBox().getHeight());
                springen = true;
            }

            //controleert of player tegen de rechterkant van een platform aanloopt
            if((platform.getBoundingBox().getMaxX() >= nieuwBoundingBox.getMinX())
            && (platform.getBoundingBox().getMaxX() <= oudBoundingBox.getMinX())){
                nullifySpeedInDirection(Direction.LEFT);
                setAnchorLocationX(platform.getBoundingBox().getMaxX());
            }

            //controleert of player tegen de linkerkant van een platform aanloopt
            if((platform.getBoundingBox().getMinX() <= nieuwBoundingBox.getMaxX())
            && (platform.getBoundingBox().getMinX() >= oudBoundingBox.getMaxX())){
                nullifySpeedInDirection(Direction.RIGHT);
                setAnchorLocationX(platform.getBoundingBox().getMinX() - getBoundingBox().getWidth());
            }

            //controleert of player tegen de onderkant van een platform aankomt
            if((platform.getBoundingBox().getMaxY() >= nieuwBoundingBox.getMinY())
            && (platform.getBoundingBox().getMaxY() <= oudBoundingBox.getMinY())){
                setAnchorLocationY(platform.getBoundingBox().getMaxY() + 10);
            }
        }
        if (collider instanceof Powerup puCollider) {
            //slaat aangeraakte powerup op in een variabele
            //player mag maar 1 powerup tegelijkertijd opslaan
            //zodra player een andere powerup aanraakt overschrijft hij de vorige
            setAnchorLocationY(getBoundingBox().getMinY());
            inventoryPowerup = puCollider;
            if(inventoryPowerup instanceof SpringenPowerup) {
                inventoryText.setText("Inventory: hoger springen");
            }
            if(inventoryPowerup instanceof HeavierPowerup){
                inventoryText.setText("Inventory: zwaarder");
            }
        }
    }

    @Override
    public void notifyBoundaryTouching(SceneBorder border) {
        //setSpeed(0);
        switch (border) {
            case TOP:
                setAnchorLocationY(1);
                break;
            case BOTTOM:
                setAnchorLocationY(getSceneHeight() - getHeight() - 1);
                break;
            case LEFT:
                setAnchorLocationX(5);
                break;
            case RIGHT:
                setAnchorLocationX(getSceneWidth() - getWidth() - 1);
            default:
                break;
        }
    }

    @Override
    public void onPressedKeysChange(Set<KeyCode> pressedKeys) {
        if (pressedKeys.contains(KeyCode.LEFT)) {
            setMotion(2, Direction.LEFT);
        }
        if (pressedKeys.contains(KeyCode.RIGHT)) {
            setMotion(2, Direction.RIGHT);
        }
        if(springen || hoogSpringen) {
            if (pressedKeys.contains(KeyCode.UP)) {
                setMotion(20, Direction.UP);
            }
            springen = false;
        }

        //klikt op spatie om powerup te activeren
        if (pressedKeys.contains(KeyCode.SPACE)){
            gebruikPowerup();
        }
    }

    public void gebruikPowerup(){
        if(usePowerup != null) {
            usePowerup.verwijderEffect(this);
        }
        if (inventoryPowerup != null) {
            usePowerup = inventoryPowerup;
            inventoryPowerup.pasToe(this);
        }
    }

    public int setGewicht(int aantal){
        return gewicht = aantal;
    }
    public int getGewicht(){
        return gewicht;
    }

    public boolean setHoogSpringen(boolean springen) {
        return hoogSpringen = springen;
    }

}
