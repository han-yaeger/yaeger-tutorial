package com.github.hanyaeger.tutorial;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;
import com.github.hanyaeger.tutorial.collectible.Key;

public class Door extends SpriteEntity implements Collided {
    private Key key;
    private LavaExit lavaExit;

    public Door(Key key, LavaExit lavaExit, Coordinate2D location, Size size) {
        super("sprites/door.png", location, size);
        this.key = key;
        this.lavaExit = lavaExit;
    }


    @Override
    public void onCollision(Collider collider) {
        if (collider instanceof Player) {
            Player player = (Player) collider;
            if(key.getOpgepakt()) {
                lavaExit.setActiveScene(3);
                key.setOpgepakt(false);
                player.setGewicht(70);
                player.setHoogSpringen(false);
            }
        }
    }
}
