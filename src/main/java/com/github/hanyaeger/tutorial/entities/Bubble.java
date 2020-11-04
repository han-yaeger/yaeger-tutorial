package com.github.hanyaeger.tutorial.entities;

import com.github.hanyaeger.api.engine.entities.entity.Coordinate2D;
import com.github.hanyaeger.api.engine.entities.entity.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.engine.entities.entity.collisions.AABBCollided;
import com.github.hanyaeger.api.engine.entities.entity.collisions.AABBCollider;
import com.github.hanyaeger.api.engine.entities.entity.shape.circle.DynamicCircleEntity;
import com.github.hanyaeger.api.engine.media.audio.SoundClip;
import com.github.hanyaeger.api.engine.scenes.SceneBorder;
import com.github.hanyaeger.tutorial.entities.map.Coral;

public abstract class Bubble extends DynamicCircleEntity implements AABBCollided, AABBCollider, SceneBorderCrossingWatcher {

    public Bubble(Coordinate2D initialLocation, double speed) {
        super(initialLocation);
        setRadius(8);
        setMotion(speed, 180d);
        setOpacity(0.5);
        setStrokeWidth(0.2);
    }

    @Override
    public void onCollision(AABBCollider collidingObject) {
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
