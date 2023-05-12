package com.github.hanyaeger.tutorial.platforms;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.tutorial.Player;

public class VastPlatform extends Platform implements Collider {

    public VastPlatform(Coordinate2D initialLocation) {
        super(initialLocation);
    }
}
