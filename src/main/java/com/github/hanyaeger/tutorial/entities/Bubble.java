package com.github.hanyaeger.tutorial.entities;

import com.github.hanyaeger.api.Coordinate2D;

import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.Direction;
import com.github.hanyaeger.api.entities.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.entities.impl.circle.DynamicCircleEntity;
import com.github.hanyaeger.api.media.SoundClip;
import com.github.hanyaeger.api.scenes.SceneBorder;
import com.github.hanyaeger.tutorial.entities.map.Coral;

public abstract class Bubble extends DynamicCircleEntity implements Collided, Collider, SceneBorderCrossingWatcher {

    public Bubble(Coordinate2D initialLocation, double speed) {
        super(initialLocation);
        setRadius(8);
        setMotion(speed, Direction.UP);
        setOpacity(0.5);
        setStrokeWidth(0.2);
    }

    @Override
    public void onCollision(Collider collidingObject) {
        if (collidingObject instanceof Coral) {
            return;
        }

        var popSound = new SoundClip("audio/pop.mp3");
        popSound.play();

        remove();
    }

    @Override
    public void notifyBoundaryCrossing(SceneBorder border) {
        if (border.equals(SceneBorder.TOP)) {
            remove();
        }
    }
}
