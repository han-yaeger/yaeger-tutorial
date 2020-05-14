package com.github.hanyaeger.tutorial.scenes;

import com.github.hanyaeger.api.engine.entities.entity.Location;
import com.github.hanyaeger.api.engine.entities.entity.shape.text.TextEntity;
import com.github.hanyaeger.api.engine.scenes.StaticScene;
import com.github.hanyaeger.tutorial.Waterworld;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.util.Set;

public class GameOver extends StaticScene {

    public static final String GAME_OVER = "Game over";
    public static final String BACKGROUND_IMAGE = "backgrounds/underwater2.jpg";
    public static final String BACKGROUND_AUDIO = "audio/ocean.mp3";

    private Waterworld waterworld;

    public GameOver(Waterworld waterworld) {
        this.waterworld = waterworld;
    }

    @Override
    public void onInputChanged(Set<KeyCode> input) {
        if (input.contains(KeyCode.ENTER)) {
            waterworld.nextScene(Waterworld.SCENE_INTRO);
        }
    }

    @Override
    public void setupScene() {
        setBackgroundImage(BACKGROUND_IMAGE);
        setBackgroundAudio(BACKGROUND_AUDIO);
    }

    @Override
    public void setupEntities() {
        var gameOverText = new TextEntity(new Location(440, 350), GAME_OVER);
        gameOverText.setFill(Color.VIOLET);
        gameOverText.setFont(Font.font(Waterworld.FONT, FontWeight.BOLD, 60));
        addEntity(gameOverText);
    }
}
