package com.github.hanyaeger.tutorial.entities;

import com.github.hanyaeger.api.engine.Size;
import com.github.hanyaeger.api.engine.entities.entity.Location;
import com.github.hanyaeger.api.engine.entities.entity.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.engine.entities.entity.collisions.AABBCollided;
import com.github.hanyaeger.api.engine.entities.entity.collisions.AABBCollider;
import com.github.hanyaeger.api.engine.entities.entity.sprite.DynamicSpriteEntity;
import com.github.hanyaeger.api.engine.media.audio.SoundClip;
import com.github.hanyaeger.api.engine.scenes.SceneBorder;
import com.github.hanyaeger.tutorial.entities.map.Coral;

public abstract class Bubble extends DynamicSpriteEntity implements AABBCollided, AABBCollider, SceneBorderCrossingWatcher {

    public Bubble(String resource, Location initialLocation, double speed) {
        super(resource, initialLocation, new Size(20, 20));
        setMotionTo(speed, 180d);
        setOpacity(0.8);
        setRotationSpeed(Math.random() * 5);
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
