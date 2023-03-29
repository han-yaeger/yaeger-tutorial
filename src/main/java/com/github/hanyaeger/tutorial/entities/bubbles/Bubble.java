package com.github.hanyaeger.tutorial.entities.bubbles;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicCircleEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;
import javafx.scene.paint.Color;

public abstract class Bubble extends DynamicCircleEntity implements SceneBorderCrossingWatcher, Collided {
    protected Bubble(Coordinate2D initialLocation, double radius, Color strokeColor, Color fillColor) {
        super(initialLocation);

        setRadius(radius);
        setStrokeColor(strokeColor);
        setFill(fillColor);
        setOpacity(0.5);
    }

    @Override
    public void notifyBoundaryCrossing(SceneBorder border) {
        if (border == SceneBorder.TOP) {
            remove();
        }
    }
}
