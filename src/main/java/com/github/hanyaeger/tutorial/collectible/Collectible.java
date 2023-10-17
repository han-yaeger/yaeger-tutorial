package com.github.hanyaeger.tutorial.collectible;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;
import com.github.hanyaeger.tutorial.Player;

public class Collectible extends SpriteEntity {
    public Collectible(String resource, Coordinate2D location, Size size) {
        super(resource, location, size);
    }

    public void onCollision(Collider collider){
        if (collider instanceof Player){
            remove();
        }
    }
}
