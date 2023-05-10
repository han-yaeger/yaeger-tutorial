package com.github.hanyaeger.tutorial;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;

public class Door extends SpriteEntity implements Collider {
    public Door(Coordinate2D location, Size size) {

        super("sprites/door.png", location, size);
    }


}
