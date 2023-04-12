package com.github.hanyaeger.tutorial.entities.sharky;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.DynamicCompositeEntity;
import com.github.hanyaeger.api.entities.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;

import java.util.Random;

public class Sharky extends DynamicSpriteEntity implements Collider, SceneBorderCrossingWatcher {
    public Sharky(Coordinate2D location){
        super("sprites/sharky.png", location, new Size(80,160), 1, 19);
        setAutoCycle(100);
        setMotion(3, 90d);
    }


    @Override
    public void notifyBoundaryCrossing(SceneBorder sceneBorder) {
        setAnchorLocationX(0);
        setAnchorLocationY(new Random().nextInt((int)(getSceneHeight()-getHeight())));
    }
}
