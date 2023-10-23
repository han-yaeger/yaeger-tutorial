package com.github.hanyaeger.FishingSimulator;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.RectangleEntity;
import javafx.scene.paint.Color;

public class Zee extends RectangleEntity {
    public Zee(final Coordinate2D initialPosition, final Size size) {
        super(initialPosition);
        setAnchorPoint(AnchorPoint.CENTER_CENTER);
        setWidth(size.width());
        setHeight(size.height());
        setFill(Color.TRANSPARENT);
        setStrokeColor(Color.RED);
        setStrokeWidth(1D);
    }
}
