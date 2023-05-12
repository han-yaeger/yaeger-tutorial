package com.github.hanyaeger.tutorial.collectible.powerup;

import com.github.hanyaeger.api.*;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.tutorial.Player;

public class SpringenPowerup extends Powerup implements Collided {
    private Player player;

    public SpringenPowerup(Player player, Coordinate2D location, Size size) {
        super("sprites/springen.png", location, size);
        this.player = player;
    }

    @Override
    public void onCollision(Collider collider) {
        if (collider instanceof Player){
            player.setHoogSpringen(true);
            remove();
        }
    }
}
