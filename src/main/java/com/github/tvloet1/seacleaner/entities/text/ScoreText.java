package com.github.tvloet1.seacleaner.entities.text;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class ScoreText extends TextEntity {
    public ScoreText(Coordinate2D initialLocation) {
        super(initialLocation);
        setFont(Font.font("Courier", FontWeight.NORMAL, 30));
        setFill(Color.GOLD);
    }

    public void setScoreText(int score) {
        setText("Score: " + score);
    }
}
