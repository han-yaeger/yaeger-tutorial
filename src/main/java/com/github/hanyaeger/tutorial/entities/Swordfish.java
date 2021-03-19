package com.github.hanyaeger.tutorial.entities;

import com.github.hanyaeger.api.engine.entities.entity.Coordinate2D;
import com.github.hanyaeger.api.engine.entities.entity.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.engine.entities.entity.collisions.Collider;
import com.github.hanyaeger.api.engine.entities.entity.motion.Direction;
import com.github.hanyaeger.api.engine.entities.entity.sprite.DynamicSpriteEntity;
import com.github.hanyaeger.api.engine.scenes.SceneBorder;

import java.util.Random;

public class Swordfish extends DynamicSpriteEntity implements SceneBorderCrossingWatcher, Collider {

    public Swordfish(Coordinate2D location) {
        super("sprites/swordfish.png", location);
        setMotion(2, Direction.LEFT);
    }

    @Override
    public void notifyBoundaryCrossing(SceneBorder border) {
        setAnchorLocation(new Coordinate2D(getSceneWidth(), new Random().nextInt((int) getSceneHeight() - 81)));
    }
}
