package com.github.hanyaeger.tutorial.collectible;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.tutorial.Player;

public class Key extends Collectible implements Collided {
    private boolean opgepakt = false;
    private Player player;

    public Key(Player player, Coordinate2D initialLocation, Size size) {
        super("sprites/key.png", initialLocation, size);
        this.player = player;
    }

    public void onCollision(Collider collider) {
        if(collider instanceof Player) {
            opgepakt = true;
            remove();
        }

    }

    public boolean getOpgepakt(){
        return opgepakt;
    }
    public void setOpgepakt(boolean aanraken){
        opgepakt = aanraken;
    }
}
