package com.github.hanyaeger.tutorial.entities.sharky;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.DynamicCompositeEntity;
import com.github.hanyaeger.api.entities.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.entities.YaegerEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;

import java.util.Random;

public class SharkyEnemy extends DynamicCompositeEntity implements SceneBorderCrossingWatcher {
    public SharkyEnemy(Coordinate2D initialLocation) {
        super(initialLocation);
        setMotion(4, 90d);
    }

    @Override
    protected void setupEntities() {
        addEntity(createSprite());
        addEntity(createHitBox());
    }

    private YaegerEntity createSprite() {
        return new Sprite();
    }

    private YaegerEntity createHitBox() {
        return new HitBox(new Coordinate2D(0, 38));
    }

    @Override
    public void notifyBoundaryCrossing(SceneBorder border) {
        setAnchorLocationX(0);
        setAnchorLocationY(new Random().nextInt((int) getSceneHeight()- 81));
    }
}
