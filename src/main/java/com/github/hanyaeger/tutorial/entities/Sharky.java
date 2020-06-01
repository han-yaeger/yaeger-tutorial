package com.github.hanyaeger.tutorial.entities;

import com.github.hanyaeger.api.engine.Size;
import com.github.hanyaeger.api.engine.entities.entity.Location;
import com.github.hanyaeger.api.engine.entities.entity.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.engine.entities.entity.collisions.AABBCollider;
import com.github.hanyaeger.api.engine.entities.entity.sprite.DynamicSpriteEntity;
import com.github.hanyaeger.api.engine.scenes.SceneBorder;

import java.util.Random;

public class Sharky extends DynamicSpriteEntity implements SceneBorderCrossingWatcher, AABBCollider {

    public Sharky(Location location) {
        super("sprites/sharky.png", location, new Size(150, 150), 19);
        setAutoCycle(25);
        setMotionTo(4, 90);
    }

    @Override
    public void notifyBoundaryCrossing(SceneBorder border) {
        setOriginY(new Random().nextInt((int) getSceneHeight() - 150));
        setOriginX(-150);
    }
}
