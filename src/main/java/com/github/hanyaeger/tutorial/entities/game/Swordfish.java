package com.github.hanyaeger.tutorial.entities.game;

import com.github.hanyaeger.api.engine.Size;
import com.github.hanyaeger.api.engine.entities.entity.Location;
import com.github.hanyaeger.api.engine.entities.entity.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.engine.entities.entity.collisions.Collider;
import com.github.hanyaeger.api.engine.entities.entity.motion.Direction;
import com.github.hanyaeger.api.engine.entities.entity.sprite.DynamicSpriteEntity;
import com.github.hanyaeger.api.engine.scenes.SceneBorder;

public class Swordfish extends DynamicSpriteEntity implements Collider, SceneBorderCrossingWatcher {

    private static final String IMAGES_SWORDFISH_PNG = "sprites/swordfish.png";

    public Swordfish(final Location location) {
        super(IMAGES_SWORDFISH_PNG, location, new Size(300, 108), 1);
        setMotionTo(2, Direction.LEFT.getValue());
    }

    @Override
    public void notifyBoundaryCrossing(SceneBorder border) {
        if (border.equals(SceneBorder.LEFT)) {
            setOriginX(getSceneWidth());
        }
    }
}
