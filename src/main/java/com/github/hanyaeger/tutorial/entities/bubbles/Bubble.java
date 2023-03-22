package com.github.hanyaeger.tutorial.entities.bubbles;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.DynamicCircleEntity;

public class Bubble extends DynamicCircleEntity {
    protected Bubble(Coordinate2D initialLocation) {
        super(initialLocation);
    }
}
