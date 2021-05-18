package com.github.hanyaeger.tutorial.entities.text;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.text.TextEntity;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class BubblesPoppedText extends TextEntity {

    public BubblesPoppedText(Coordinate2D initialPosition) {
        super(initialPosition);

        setFont(Font.font("Roboto", FontWeight.NORMAL, 30));
        setFill(Color.PINK);
    }

    public void setText(final int bubblesPopped) {
        setText("Bubbles Popped: " + bubblesPopped);
    }
}
