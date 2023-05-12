package com.github.hanyaeger.tutorial.text;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class Text extends TextEntity {
    public Text(Coordinate2D initialLocation, int grootte) {
        super(initialLocation);

        setFont(Font.font("Roboto", FontWeight.NORMAL, grootte));
        setFill(Color.DARKBLUE);
    }

    public void setText(String text, int index) {
        setText(text + index);
    }
}