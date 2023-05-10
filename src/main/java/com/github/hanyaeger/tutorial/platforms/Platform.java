package com.github.hanyaeger.tutorial.platforms;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;
import com.github.hanyaeger.tutorial.Player;

public class Platform extends SpriteEntity implements Collider {

    public Platform(Coordinate2D initialLocation, Size size, String resource) {
        super(resource, initialLocation, size);
    }
}
