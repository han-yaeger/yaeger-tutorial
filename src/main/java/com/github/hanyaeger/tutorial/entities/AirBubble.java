package com.github.hanyaeger.tutorial.entities;

import com.github.hanyaeger.api.engine.entities.entity.Location;
import javafx.scene.paint.Color;

public class AirBubble extends Bubble {

    public AirBubble(Location initialLocation, double speed) {
        super(initialLocation, speed);
        setFill(Color.WHITE);
        setStrokeColor(Color.BLUE);
    }
}
