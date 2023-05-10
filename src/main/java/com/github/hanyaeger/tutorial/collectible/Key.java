package com.github.hanyaeger.tutorial.collectible;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;

public class Key extends Collectible implements Collided {
    private static boolean opgepakt = false;

    public Key(Coordinate2D initialLocation, Size size) {
        super("sprites/key.png", initialLocation, size);
    }

    public void onCollision(Collider collider) {
        opgepakt = true;
    }

    public static boolean getOpgepakt(){
        return opgepakt;
    }
    public static void setOpgepakt(boolean aanraken){
        opgepakt = aanraken;
    }
}
