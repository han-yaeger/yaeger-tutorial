package com.github.hanyaeger.tutorial.entities.game;

import com.github.hanyaeger.api.engine.entities.entity.Location;
import com.github.hanyaeger.api.engine.entities.entity.collisions.Collider;
import com.github.hanyaeger.tutorial.scenes.levels.Level;

public class Air extends Bubble {

    private static final String IMAGES_BUBBLE_PNG = "sprites/bubble.png";

    public Air(final Location location, final double speed, final Level waterworld) {
        super(location, IMAGES_BUBBLE_PNG, speed, waterworld);
    }

    @Override
    public void onCollision(final Collider collidingObject) {
        super.onCollision(collidingObject);

        if (collidingObject instanceof Player) {
            handlePlayerCollision();
        }
    }
}
