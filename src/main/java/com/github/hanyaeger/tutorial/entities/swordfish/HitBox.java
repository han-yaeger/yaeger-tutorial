package com.github.hanyaeger.tutorial.entities.swordfish;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.RectangleEntity;
import javafx.scene.paint.Color;

public class HitBox extends RectangleEntity implements Collider {

    public HitBox(final Coordinate2D initialPosition) {
        super(initialPosition);
        setWidth(60);
        setHeight(2);
        setFill(Color.TRANSPARENT);
    }
}
