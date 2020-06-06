package com.github.hanyaeger.tutorial.entities;

import com.github.hanyaeger.api.engine.entities.entity.Location;

public class AirBubble extends Bubble {

    public AirBubble(Location initialLocation, double speed) {
        super("sprites/airbubble.png", initialLocation, speed);

    }
}
