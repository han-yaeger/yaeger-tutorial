package com.github.hanyaeger.tutorial.collectible;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;

public abstract class Collectible extends SpriteEntity {
    public Collectible(String resource, Coordinate2D location, Size size) {
        super(resource, location, size);
    }

    public abstract void onCollision(Collider collider);
}
