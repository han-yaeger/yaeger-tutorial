package com.github.hanyaeger.tutorial.collectible.powerup;

import com.github.hanyaeger.api.*;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.tutorial.Player;

public class SpringenPowerup extends Powerup implements Collided {

    public SpringenPowerup(Coordinate2D location, Size size) {
        super("sprites/springen.png", location, size);
    }

    @Override
    public void pasToe(Player player) {
        player.setHoogSpringen(true);
    }

    @Override
    public void verwijderEffect(Player player) {
        player.setHoogSpringen(false);
    }
}
