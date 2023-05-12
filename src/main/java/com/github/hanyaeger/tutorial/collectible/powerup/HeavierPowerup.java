package com.github.hanyaeger.tutorial.collectible.powerup;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.tutorial.Player;
import com.github.hanyaeger.tutorial.collectible.Collectible;

public class HeavierPowerup extends Powerup implements Collided {
    private int zwaarte;
    private Player player;

    public HeavierPowerup(Player player, Coordinate2D location, Size size, int zwaarte) {
            super("sprites/heavyPowerup.png", location, size);
            this.zwaarte = zwaarte;
            this.player = player;
    }

    @Override
    public void onCollision(Collider collider) {
        if (collider instanceof Player){
            player.setGewicht(pasToe(player.gewicht));
            System.out.println(player.gewicht);
            remove();
        }
    }

    public int pasToe(int gewicht){
        return gewicht + zwaarte;
    }
}
