package com.github.hanyaeger.tutorial;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.UpdateExposer;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.Newtonian;
import com.github.hanyaeger.api.entities.SceneBorderTouchingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;
import com.github.hanyaeger.api.userinput.KeyListener;
import com.github.hanyaeger.tutorial.collectible.HeavierPowerup;
import com.github.hanyaeger.tutorial.platforms.Platform;
import com.github.hanyaeger.tutorial.collectible.Key;
import javafx.scene.input.KeyCode;

import java.util.Set;

public class Player extends DynamicSpriteEntity implements KeyListener, SceneBorderTouchingWatcher, Newtonian, Collider, Collided, UpdateExposer {
    private LavaExit lavaExit;
    public static int gewicht = 70;

    public Player(Coordinate2D location, LavaExit lavaExit) {
        super("sprites/player.png", location, new Size(50, 150), 1, 1);
        this.lavaExit = lavaExit;
        setGravityConstant(1);
        setFrictionConstant(0.04);
    }

    @Override
    public void onCollision(Collider collider) {
        if (collider instanceof Platform) {
            setSpeed(0);
        }
        if (collider instanceof Door) {
            if(Key.getOpgepakt()) {
                lavaExit.setActiveScene(3);
                Key.setOpgepakt(false);
            }
        }
    }

    @Override
    public void explicitUpdate(long timestamp){
//        System.out.println(gewicht);
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
//                lavaExit.setActiveScene(2);
                break;
            case LEFT:
                setAnchorLocationX(1);
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
            setMotion(5, 270d);
        }
        if (pressedKeys.contains(KeyCode.RIGHT)) {
            setMotion(5, 90d);
        }
        if (pressedKeys.contains(KeyCode.UP)) {
            setMotion(20, 180d);
        }
        if (pressedKeys.contains(KeyCode.LEFT) && pressedKeys.contains(KeyCode.UP)) {
            setMotion(20, 225d);
        }
        if (pressedKeys.contains(KeyCode.RIGHT) && pressedKeys.contains(KeyCode.UP)) {
            setMotion(20, 135d);
        }
    }

    public static int setGewicht(int extraGewicht){
        return gewicht = extraGewicht;
    }
}
