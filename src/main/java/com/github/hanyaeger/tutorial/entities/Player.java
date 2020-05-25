package com.github.hanyaeger.tutorial.entities;

import com.github.hanyaeger.api.engine.Size;
import com.github.hanyaeger.api.engine.entities.entity.Location;
import com.github.hanyaeger.api.engine.entities.entity.sprite.DynamicSpriteEntity;

public class Player extends DynamicSpriteEntity {

    public Player(final Location location) {
        super("sprites/player.png", location, new Size(20, 40), 2);
    }
}
