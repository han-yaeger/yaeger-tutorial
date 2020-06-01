package com.github.hanyaeger.tutorial.entities;

import com.github.hanyaeger.api.engine.Size;
import com.github.hanyaeger.api.engine.entities.entity.Location;
import com.github.hanyaeger.api.engine.entities.entity.collisions.AABBCollided;
import com.github.hanyaeger.api.engine.entities.entity.collisions.AABBCollider;
import com.github.hanyaeger.api.engine.entities.entity.events.userinput.KeyListener;
import com.github.hanyaeger.api.engine.entities.entity.motion.Direction;
import com.github.hanyaeger.api.engine.entities.entity.sprite.DynamicSpriteEntity;
import com.github.hanyaeger.tutorial.Waterworld;
import javafx.scene.input.KeyCode;

import java.util.Random;
import java.util.Set;

public class Hanny extends DynamicSpriteEntity implements KeyListener, AABBCollided {

    private final HealthText healthText;
    private final Waterworld waterworld;
    private int health = 10;

    public Hanny(Location location, HealthText healthText, Waterworld waterworld) {
        super("sprites/hanny.png", location, new Size(20, 40), 2);

        this.healthText = healthText;
        this.waterworld = waterworld;
        healthText.setHealthText(health);
    }

    @Override
    public void onPressedKeysChange(Set<KeyCode> pressedKeys) {
        if (pressedKeys.contains(KeyCode.LEFT)) {
            setCurrentFrameIndex(0);
            setMotionTo(3, Direction.LEFT.getValue());
        } else if (pressedKeys.contains(KeyCode.RIGHT)) {
            setCurrentFrameIndex(1);
            setMotionTo(3, Direction.RIGHT.getValue());
        } else if (pressedKeys.contains(KeyCode.UP)) {
            setMotionTo(3, Direction.UP.getValue());
        } else if (pressedKeys.contains(KeyCode.DOWN)) {
            setMotionTo(3, Direction.DOWN.getValue());
        } else if (pressedKeys.isEmpty()) {
            setSpeedTo(0);
        }
    }

    @Override
    public void onCollision(AABBCollider collidingObject) {

        health--;
        healthText.setHealthText(health);

        if (health == 8) {
            this.waterworld.setActiveScene(2);
        } else {
            setOriginX(new Random().nextInt((int) (getSceneWidth() - getWidth())));
            setOriginY(new Random().nextInt((int) (getSceneHeight() - getHeight())));
        }
    }
}
