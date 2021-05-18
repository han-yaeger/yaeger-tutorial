package com.github.hanyaeger.tutorial.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.Direction;
import com.github.hanyaeger.api.entities.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.entities.impl.sprite.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;

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
