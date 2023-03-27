package com.github.hanyaeger.tutorial.platforms;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.tutorial.Player;

public class VastPlatform extends Platform implements Collider {

    public VastPlatform(Player player, Coordinate2D initialLocation, Size size, String resource) {
        super(player, initialLocation, size, resource);
    }

    @Override
    public boolean staatErop(){
        if(player)
    }
}
