package com.github.hanyaeger.tutorial.scenes;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.scenes.StaticScene;
import com.github.hanyaeger.tutorial.Waterworld;
import com.github.hanyaeger.tutorial.entities.buttons.QuitButton;
import com.github.hanyaeger.tutorial.entities.buttons.StartButton;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;


public class GameOverScene extends StaticScene {

    private Waterworld waterworld;

    public GameOverScene(Waterworld waterworld) {
        this.waterworld = waterworld;
    }

    @Override
    public void setupScene() {
        setBackgroundAudio("audio/ocean.mp3");
        setBackgroundImage("backgrounds/background3.jpg");
    }

    @Override
    public void setupEntities() {
        var gameOverText = new TextEntity(new Coordinate2D(getWidth() / 2, getHeight() / 2), "Game Over");
        gameOverText.setAnchorPoint(AnchorPoint.BOTTOM_CENTER);
        gameOverText.setFill(Color.DEEPPINK);
        gameOverText.setFont(Font.font("Roboto", FontWeight.SEMI_BOLD, 80));
        addEntity(gameOverText);

        var playGamButton = new StartButton(new Coordinate2D((getWidth() / 2) - 20, getHeight() / 2), waterworld);
        playGamButton.setAnchorPoint(AnchorPoint.TOP_RIGHT);
        addEntity(playGamButton);

        var exitGameButton = new QuitButton(new Coordinate2D((getWidth() / 2) + 20, getHeight() / 2), waterworld);
        exitGameButton.setAnchorPoint(AnchorPoint.TOP_LEFT);
        addEntity(exitGameButton);
    }
}
