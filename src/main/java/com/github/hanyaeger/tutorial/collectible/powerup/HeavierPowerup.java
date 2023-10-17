package com.github.hanyaeger.tutorial.collectible.powerup;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.tutorial.Player;

public class HeavierPowerup extends Powerup implements Collided {
    private final int zwaarte;

    public HeavierPowerup(Coordinate2D location, Size size, int zwaarte) {
            super("sprites/heavyPowerup.png", location, size);
            this.zwaarte = zwaarte;
    }

    @Override
    public void pasToe(Player player){
        player.setGewicht(player.getGewicht() + zwaarte);
    }
}
