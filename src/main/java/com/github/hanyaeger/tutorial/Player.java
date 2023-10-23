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
import javafx.scene.input.KeyCode;

import java.util.Set;

public class Player extends DynamicSpriteEntity implements KeyListener, SceneBorderTouchingWatcher, Newtonian, Collider, Collided, UpdateExposer{
    private Text gewichtText;
    private Text inventoryText;
    private boolean springen = false;
    private boolean hoogSpringen = false;
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
    }


    //TO DO: afronden naar bepaald decimaal getal en dan checken met elkaar
    @Override
    public void onCollision(Collider collider) {

        if (collider instanceof Platform platform) {
            //controleert of player op het platform staat
            //(moet met een marche gerekend worden, omdat de 2 waarde van beide elementen bijna nooit gelijk zijn
            if((getBoundingBox().getMaxY() - platform.getBoundingBox().getMinY() <= 15)
            && (getBoundingBox().getMaxY() - platform.getBoundingBox().getMinY() >= -5)) {
                setAnchorLocationY(platform.getBoundingBox().getMinY() - getBoundingBox().getHeight());
                springen = true;
            }

            //controleert of player tegen de linkerkant van een platform aanloopt
            if((getBoundingBox().getMaxX() - platform.getBoundingBox().getMinX() <= 15)
            && (getBoundingBox().getMaxX() - platform.getBoundingBox().getMinX() >= 5)){
                setAnchorLocationX(platform.getBoundingBox().getMinX() - getBoundingBox().getWidth() - 1);
            }

            //controleert of player tegen de rechterkant van een platform aanloopt
            if((getBoundingBox().getMinX() - platform.getBoundingBox().getMaxX() >= -10)
            && (getBoundingBox().getMinX() - platform.getBoundingBox().getMaxX() <= 5)){
                setAnchorLocationX(platform.getBoundingBox().getMaxX() + 6);
            }

            //controleert of player tegen de onderkant van een platform aankomt
            if((getBoundingBox().getMinY() - platform.getBoundingBox().getMaxY() >= -10)
            && (getBoundingBox().getMinY() - platform.getBoundingBox().getMaxY() <= 5)){
                setAnchorLocationY(platform.getBoundingBox().getMaxY() + 6);
            }

        }
        if (collider instanceof Powerup puCollider) {
            //slaat aangeraakte powerup op in een variabele
            //player mag maar 1 powerup tegelijkertijd opslaan
            //zodra player een andere powerup aanraakt overschrijft hij de vorige
            setSpeed(0);
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
        setSpeed(0);
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
