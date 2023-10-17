package com.github.hanyaeger.tutorial.collectible;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.tutorial.Player;

public class Key extends Collectible implements Collided {
    private boolean isOpgepakt = false;

    public Key(Coordinate2D initialLocation, Size size) {
        super("sprites/key.png", initialLocation, size);
    }

    public void onCollision(Collider collider) {
        super.onCollision(collider);
        if(collider instanceof Player) {
            isOpgepakt = true;
        }
    }

    public boolean getOpgepakt(){
        return isOpgepakt;
    }
    public void setOpgepakt(boolean aanraken){
        isOpgepakt = aanraken;
    }
}
