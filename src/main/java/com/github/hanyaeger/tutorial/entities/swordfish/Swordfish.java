package com.github.hanyaeger.tutorial.entities.swordfish;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.DynamicCompositeEntity;
import com.github.hanyaeger.api.entities.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.entities.YaegerEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;

import java.util.Random;

public class Swordfish extends DynamicCompositeEntity implements SceneBorderCrossingWatcher {
    public Swordfish(Coordinate2D initialLocation) {
        super(initialLocation);
        setMotion(2, 270d);
    }

    private YaegerEntity createSprite() {
        return new SwordfishSprite();
    }

    private YaegerEntity createHitBox() {
        return new SwordfishHitBox(new Coordinate2D(0, 38));
    }

    @Override
    protected void setupEntities() {
        addEntity(createSprite());
        addEntity(createHitBox());
    }

    @Override
    public void notifyBoundaryCrossing(SceneBorder border) {
        setAnchorLocationX(getSceneWidth());
        setAnchorLocationY(new Random().nextInt((int) getSceneHeight()- 81));
    }

    @Override
    public void update(long timestamp) {
        super.update(timestamp);
    }
}
