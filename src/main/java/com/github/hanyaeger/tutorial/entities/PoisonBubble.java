package com.github.hanyaeger.tutorial.entities;

import com.github.hanyaeger.api.engine.entities.entity.Location;

public class PoisonBubble extends Bubble {

    public PoisonBubble(Location initialLocation, double speed) {
        super("sprites/poisonbubble.png", initialLocation, speed);
    }
}
