package com.github.hanyaeger.tutorial.entities.game;

import com.github.hanyaeger.api.engine.Size;
import com.github.hanyaeger.api.engine.entities.entity.Location;
import com.github.hanyaeger.api.engine.entities.entity.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.engine.entities.entity.collisions.Collider;
import com.github.hanyaeger.api.engine.entities.entity.motion.Direction;
import com.github.hanyaeger.api.engine.entities.entity.sprite.DynamicSpriteEntity;
import com.github.hanyaeger.api.engine.scenes.SceneBorder;

public class AnimatedShark extends DynamicSpriteEntity implements Collider, SceneBorderCrossingWatcher {
    private static final String IMAGES_ANIMATED_SHARK_PNG = "sprites/shark.png";

    public AnimatedShark(Location location) {
        super(IMAGES_ANIMATED_SHARK_PNG, location, new Size(200, 200), 19);
        setAutoCycle(25);
        setMotionTo(4, Direction.LEFT.getValue());
    }

    @Override
    public void notifyBoundaryCrossing(SceneBorder border) {
        if (border.equals(SceneBorder.LEFT)) {
            setOriginX(getSceneWidth());
        }
    }
}
