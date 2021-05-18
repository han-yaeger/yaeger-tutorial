package com.github.hanyaeger.tutorial.entities;

import com.github.hanyaeger.api.Coordinate2D;
import javafx.scene.paint.Color;

public class PoisonBubble extends Bubble {

    public PoisonBubble(Coordinate2D initialLocation, double speed) {
        super(initialLocation, speed);
        setFill(Color.LIGHTPINK);
        setStrokeColor(Color.PURPLE);
    }
}
