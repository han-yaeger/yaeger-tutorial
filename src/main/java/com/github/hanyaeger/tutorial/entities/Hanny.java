package com.github.hanyaeger.tutorial.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.Newtonian;
import com.github.hanyaeger.api.entities.SceneBorderTouchingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;
import com.github.hanyaeger.api.userinput.KeyListener;
import com.github.hanyaeger.tutorial.Waterworld;
import com.github.hanyaeger.tutorial.entities.text.HealthText;
import javafx.scene.input.KeyCode;

import java.util.Random;
import java.util.Set;

public class Hanny extends DynamicSpriteEntity implements KeyListener, SceneBorderTouchingWatcher, Newtonian, Collided {

    private int health = 10;

    // TODO: Maak afhankelijk van enemy
    private static final int HIT_DECREMENT = 10;

    private final Waterworld waterworld;

    private final HealthText healthText;

    public Hanny(Coordinate2D initialLocation, Waterworld waterworld, HealthText healthText) {
        super("sprites/hanny.png", initialLocation, new Size(20, 40), 1, 2);

        this.waterworld = waterworld;

        this.healthText = healthText;
        healthText.setHealthText(getHealth());

        setGravityConstant(0.005);
        setFrictionConstant(0.04);
        setCurrentFrameIndex(1);
    }

    private int getHealth() {
        return health;
    }

    private void setHealth(int health) {
        this.health = health;
    }

    @Override
    public void onPressedKeysChange(Set<KeyCode> pressedKeys) {
        if (pressedKeys.contains(KeyCode.LEFT)) {
            setMotion(3, 270d);
            setCurrentFrameIndex(0);
        }
        else if (pressedKeys.contains(KeyCode.RIGHT)) {
            setMotion(3, 90d);
            setCurrentFrameIndex(1);
        }
        else if (pressedKeys.contains(KeyCode.UP)) {
            setMotion(3, 180d);
        }
        else if (pressedKeys.contains(KeyCode.DOWN)) {
            setMotion(3, 0d);
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
                setAnchorLocationX(1);
                break;
            case RIGHT:
                setAnchorLocationX(getSceneWidth() - getWidth() - 1);
            default:
                break;
        }
    }


    @Override
    public void onCollision(Collider collidingObject) {
        setAnchorLocation(
                new Coordinate2D(new Random().nextInt((int) (getSceneWidth()
                        - getWidth())),
                        new Random().nextInt((int) (getSceneHeight() - getHeight())))
        );

        setHealth(health - HIT_DECREMENT);

        if (health > 0) {
            healthText.setHealthText(getHealth());

        }
        else {
            waterworld.setActiveScene(2);
        }
    }
}
