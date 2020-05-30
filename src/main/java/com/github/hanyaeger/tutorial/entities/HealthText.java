package com.github.hanyaeger.tutorial.entities;

import com.github.hanyaeger.api.engine.entities.entity.Location;
import com.github.hanyaeger.api.engine.entities.entity.shape.text.TextEntity;
import com.github.hanyaeger.api.engine.styles.HanFont;
import javafx.scene.paint.Color;

public class HealthText extends TextEntity {

    public HealthText(Location initialPosition) {
        super(initialPosition);

        setFont(HanFont.createDefaultCondensedFont(40));
        setFill(Color.DARKBLUE);
    }

    public void setHealthText(final int health) {
        setText("Health: " + health);
    }
}
