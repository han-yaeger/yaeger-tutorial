package com.github.hanyaeger.tutorial.platforms;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;

public abstract class Platform extends DynamicSpriteEntity implements Collider {

    public Platform(Coordinate2D initialLocation) {
        super("sprites/platform.png", initialLocation, new Size(100, 50));
    }
}
