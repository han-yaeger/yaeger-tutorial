package com.github.hanyaeger.tutorial.entities.game;

import com.github.hanyaeger.api.engine.entities.entity.Location;
import com.github.hanyaeger.api.engine.entities.entity.collisions.Collider;
import com.github.hanyaeger.tutorial.scenes.levels.Level;

public class Poison extends Bubble {

    private static final String IMAGES_POISON_PNG = "sprites/poison.png";

    public Poison(final Location location, final double speed, final Level level) {
        super(location, IMAGES_POISON_PNG, speed, level);
    }

    @Override
    public void onCollision(Collider collidingObject) {
        super.onCollision(collidingObject);

        if (collidingObject instanceof Player) {
            handlePlayerCollision();

            Player player = (Player) collidingObject;
            player.doDamage();
        }
    }
}
