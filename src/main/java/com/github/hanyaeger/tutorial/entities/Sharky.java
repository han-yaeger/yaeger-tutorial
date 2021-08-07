package com.github.hanyaeger.tutorial.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.Direction;
import com.github.hanyaeger.api.entities.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;

import java.util.Random;

public class Sharky extends DynamicSpriteEntity implements SceneBorderCrossingWatcher, Collider {

    public Sharky(Coordinate2D location) {
        super("sprites/sharky.png", location, new Size(150, 150), 1, 19);
        setAutoCycle(25);
        setMotion(4, Direction.RIGHT);
    }

    @Override
    public void notifyBoundaryCrossing(SceneBorder border) {
        setAnchorLocation(new Coordinate2D(-150, new Random().nextInt((int) getSceneHeight() - 150)));
    }
}
