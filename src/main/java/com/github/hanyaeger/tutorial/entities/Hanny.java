package com.github.hanyaeger.tutorial.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.*;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;
import com.github.hanyaeger.api.userinput.KeyListener;
import com.github.hanyaeger.tutorial.Waterworld;
import com.github.hanyaeger.tutorial.entities.map.Coral;
import com.github.hanyaeger.tutorial.entities.text.BubblesPoppedText;
import com.github.hanyaeger.tutorial.entities.text.HealthText;
import javafx.scene.input.KeyCode;

import java.util.List;
import java.util.Random;
import java.util.Set;

public class Hanny extends DynamicSpriteEntity implements SceneBorderTouchingWatcher, KeyListener, Collided, Collider, Newtonian {

    private final HealthText healthText;
    private final BubblesPoppedText bubblesPoppedText;
    private final Waterworld waterworld;
    private int health = 10;
    private int bubblesPopped = 0;

    public Hanny(final Coordinate2D location, final HealthText healthText, final BubblesPoppedText bubblesPoppedText, final Waterworld waterworld) {
        super("sprites/hanny.png", location, new Size(20, 40), 1, 2);

        this.healthText = healthText;
        this.bubblesPoppedText = bubblesPoppedText;
        this.waterworld = waterworld;
        healthText.setText(health);
        bubblesPoppedText.setText(bubblesPopped);

        setGravityConstant(0.005);
        setFrictionConstant(0.04);
    }

    @Override
    public void onPressedKeysChange(Set<KeyCode> pressedKeys) {
        if (pressedKeys.contains(KeyCode.LEFT)) {
            setCurrentFrameIndex(0);
            setMotion(3, Direction.LEFT);
        } else if (pressedKeys.contains(KeyCode.RIGHT)) {
            setCurrentFrameIndex(1);
            setMotion(3, Direction.RIGHT);
        } else if (pressedKeys.contains(KeyCode.UP)) {
            setMotion(3, Direction.UP);
        } else if (pressedKeys.contains(KeyCode.DOWN)) {
            setMotion(3, Direction.DOWN);
        }
    }

    @Override
    public void onCollision(List<Collider> collidingObject) {
        var coralCollision = false;
        var airBubbleCollision = false;
        var enemyCollision = false;

        for (Collider collider : collidingObject) {
            if (collider instanceof Coral) {
                coralCollision = true;
            } else if (collider instanceof AirBubble) {
                airBubbleCollision = true;
            } else {
                enemyCollision = true;
            }
        }

        if (coralCollision) {
            setSpeed(0);
        }
        if (airBubbleCollision) {
            bubblesPoppedText.setText(++bubblesPopped);
        }
        if (enemyCollision) {
            healthText.setText(--health);

            if (health == 0) {
                this.waterworld.setActiveScene(2);
            } else {
                setAnchorLocation(new Coordinate2D(
                        new Random().nextInt((int) (getSceneWidth() - getWidth())),
                        new Random().nextInt((int) (getSceneHeight() - getHeight()))));
            }
        }
    }

    @Override
    public void notifyBoundaryTouching(final SceneBorder border) {
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
}
