package com.github.hanyaeger.tutorial.entities;

import com.github.hanyaeger.api.engine.entities.entity.Location;
import javafx.scene.paint.Color;

public class PoisonBubble extends Bubble {

    public PoisonBubble(Location initialLocation, double speed) {
        super(initialLocation, speed);
        setFill(Color.LIGHTPINK);
        setStrokeColor(Color.PURPLE);
    }
}
