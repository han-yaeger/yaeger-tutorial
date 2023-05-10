package com.github.hanyaeger.tutorial.collectible;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.tutorial.Player;

public class HeavierPowerup extends Collectible implements Collided {
    private static int zwaarte;

    public HeavierPowerup(Coordinate2D location, Size size, int zwaarte) {
        super("sprites/heavyPowerup.png", location, size);
        this.zwaarte = zwaarte;
    }

    @Override
    public void onCollision(Collider collider) {
        if (collider instanceof Player){
            Player.setGewicht(pasToe(Player.gewicht));
            System.out.println(Player.gewicht);
        }
    }

    public static int pasToe(int gewicht){
        return gewicht + zwaarte;
    }
}
