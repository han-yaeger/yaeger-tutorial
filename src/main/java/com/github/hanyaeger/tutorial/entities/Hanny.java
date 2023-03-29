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
import com.github.hanyaeger.tutorial.entities.sharky.SharkyHitBox;
import com.github.hanyaeger.tutorial.entities.swordfish.SwordfishHitBox;
import com.github.hanyaeger.tutorial.entities.text.HealthText;
import com.github.hanyaeger.tutorial.settings.EnemyDamage;
import javafx.scene.input.KeyCode;

import java.util.List;
import java.util.Random;
import java.util.Set;

public class Hanny extends DynamicSpriteEntity implements KeyListener, SceneBorderTouchingWatcher, Newtonian,
        Collided, Collider {

    private int health = 10;

    private final Waterworld waterworld;

    private final HealthText healthText;

    private static final double SPEED = 4;

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

    public void decrementHealth(int decrement) {
        health = getHealth() - decrement;

        if (health > 0) {
            healthText.setHealthText(getHealth());
        }
        else {
            waterworld.setActiveScene(2);
        }
    }

    @Override
    public void onPressedKeysChange(Set<KeyCode> pressedKeys) {
        if (pressedKeys.contains(KeyCode.LEFT)) {
            setMotion(SPEED, 270d);
            setCurrentFrameIndex(0);
        }
        else if (pressedKeys.contains(KeyCode.RIGHT)) {
            setMotion(SPEED, 90d);
            setCurrentFrameIndex(1);
        }
        else if (pressedKeys.contains(KeyCode.UP)) {
            setMotion(SPEED, 180d);
        }
        else if (pressedKeys.contains(KeyCode.DOWN)) {
            setMotion(SPEED, 0d);
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
    public void onCollision(List<Collider> collidingObjects) {
        setAnchorLocation(
                new Coordinate2D(new Random().nextInt((int) (getSceneWidth()
                        - getWidth())),
                        new Random().nextInt((int) (getSceneHeight() - getHeight())))
        );

        Collider enemy = collidingObjects.get(0);
        int damage = 0;

        if (enemy instanceof SwordfishHitBox) {
            damage = EnemyDamage.SWORDFISH.getDamage();
        } else if (enemy instanceof SharkyHitBox) {
            damage = EnemyDamage.SHARKY.getDamage();
        }

        decrementHealth(damage);
    }
}
