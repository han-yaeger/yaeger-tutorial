package com.github.hanyaeger.tutorial.entities;

import com.github.hanyaeger.api.engine.Size;
import com.github.hanyaeger.api.engine.entities.entity.Location;
import com.github.hanyaeger.api.engine.entities.entity.SceneBorderTouchingWatcher;
import com.github.hanyaeger.api.engine.entities.entity.collisions.AABBCollided;
import com.github.hanyaeger.api.engine.entities.entity.collisions.AABBCollider;
import com.github.hanyaeger.api.engine.entities.entity.events.userinput.KeyListener;
import com.github.hanyaeger.api.engine.entities.entity.motion.Direction;
import com.github.hanyaeger.api.engine.entities.entity.sprite.DynamicSpriteEntity;
import com.github.hanyaeger.api.engine.scenes.SceneBorder;
import com.github.hanyaeger.tutorial.Waterworld;
import com.github.hanyaeger.tutorial.entities.map.Coral;
import com.github.hanyaeger.tutorial.entities.text.BubblesPoppedText;
import com.github.hanyaeger.tutorial.entities.text.HealthText;
import javafx.scene.input.KeyCode;

import java.util.Random;
import java.util.Set;

public class Hanny extends DynamicSpriteEntity implements SceneBorderTouchingWatcher, KeyListener, AABBCollided, AABBCollider {

    private final HealthText healthText;
    private final BubblesPoppedText bubblesPoppedText;
    private final Waterworld waterworld;
    private int health = 10;
    private int bubblesPopped = 0;

    public Hanny(Location location, HealthText healthText, BubblesPoppedText bubblesPoppedText, Waterworld waterworld) {
        super("sprites/hanny.png", location, new Size(20, 40), 2);

        this.healthText = healthText;
        this.bubblesPoppedText = bubblesPoppedText;
        this.waterworld = waterworld;
        healthText.setText(health);
        bubblesPoppedText.setText(bubblesPopped);
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

        if (collidingObject instanceof Coral) {
            setSpeedTo(0);
        } else if (collidingObject instanceof AirBubble) {
            bubblesPoppedText.setText(++bubblesPopped);
        } else {
            healthText.setText(--health);

            if (health == 0) {
                this.waterworld.setActiveScene(2);
            } else {
                setOriginX(new Random().nextInt((int) (getSceneWidth() - getWidth())));
                setOriginY(new Random().nextInt((int) (getSceneHeight() - getHeight())));
            }
        }
    }

    @Override
    public void notifyBoundaryTouching(SceneBorder border) {
        setSpeedTo(0);
    }
}
