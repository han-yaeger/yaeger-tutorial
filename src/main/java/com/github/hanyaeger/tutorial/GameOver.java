package com.github.hanyaeger.tutorial;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.scenes.StaticScene;
import com.github.hanyaeger.tutorial.buttons.Button;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class GameOver extends StaticScene {
    private LavaExit lavaExit;

    public GameOver(LavaExit lavaExit){
        this.lavaExit = lavaExit;
    }

    @Override
    public void setupScene() {
        setBackgroundAudio("audio/lava.mp3");
        setBackgroundImage("backgrounds/startscherm.jpg");
    }

    @Override
    public void setupEntities() {
        var lavaExitText = new TextEntity(
                new Coordinate2D(getWidth() / 2, getHeight() / 2),
                "Game Over"
        );
        lavaExitText.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        lavaExitText.setFill(Color.WHITE);
        lavaExitText.setFont(Font.font("Roboto", FontWeight.SEMI_BOLD, 80));
        addEntity(lavaExitText);

        var gameOverTekst = new Button(new Coordinate2D(getWidth() / 2.5, getHeight() / 1.75), "Restart", 1, lavaExit);
        addEntity(gameOverTekst);
    }
}
