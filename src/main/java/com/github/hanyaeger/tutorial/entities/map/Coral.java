package com.github.hanyaeger.tutorial.entities.map;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.sprite.SpriteEntity;

public class Coral extends SpriteEntity implements Collider {

    protected Coral(String resource, Coordinate2D location, Size size) {
        super(resource, location, size);
    }
}
