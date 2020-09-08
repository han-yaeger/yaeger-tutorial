package com.github.hanyaeger.tutorial.entities.text;

import com.github.hanyaeger.api.engine.entities.entity.Coordinate2D;
import com.github.hanyaeger.api.engine.entities.entity.shape.text.TextEntity;
import com.github.hanyaeger.api.engine.styles.HanFont;
import javafx.scene.paint.Color;

public class HealthText extends TextEntity {

    public HealthText(Coordinate2D initialPosition) {
        super(initialPosition);

        setFont(HanFont.createDefaultCondensedFont(30));
        setFill(Color.DARKBLUE);
    }

    public void setText(final int health) {
        setText("Health: " + health);
    }
}
