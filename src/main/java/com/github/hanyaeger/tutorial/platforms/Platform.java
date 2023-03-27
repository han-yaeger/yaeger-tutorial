package com.github.hanyaeger.tutorial.platforms;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;
import com.github.hanyaeger.tutorial.Player;

public class Platform extends SpriteEntity {
    private Player player;

    public Platform(Player player, Coordinate2D initialLocation, Size size, String resource) {
        super(resource, initialLocation, size);
        this.player = player;
    }

    public boolean staatErop(){

    }
}
