package com.github.hanyaeger.tutorial.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;

public class Player extends SpriteEntity {

    public Player(Coordinate2D initialLocation) {
        super("sprites/player.png", initialLocation, new Size(200, 150), 1, 1);
    }
}
