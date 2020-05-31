package com.github.hanyaeger.tutorial.scenes;

import com.github.hanyaeger.api.engine.entities.entity.AnchorPoint;
import com.github.hanyaeger.api.engine.entities.entity.Location;
import com.github.hanyaeger.api.engine.entities.entity.shape.text.TextEntity;
import com.github.hanyaeger.api.engine.scenes.StaticScene;
import com.github.hanyaeger.api.engine.styles.HanFont;
import com.github.hanyaeger.api.engine.styles.HanFontStyle;
import com.github.hanyaeger.tutorial.Waterworld;
import com.github.hanyaeger.tutorial.buttons.QuitButton;
import com.github.hanyaeger.tutorial.buttons.StartButton;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;

import java.util.Set;

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
        var gameOverText = new TextEntity(new Location(getWidth() / 2, getHeight() / 2), "Game Over");
        gameOverText.setAnchorPoint(AnchorPoint.BOTTOM_CENTER);
        gameOverText.setFill(Color.DEEPPINK);
        gameOverText.setFont(HanFont.createDefaultCondensedFont(HanFontStyle.DEMI_BOLD, 80));
        addEntity(gameOverText);

        var playGamButton = new StartButton(new Location(getWidth() / 2, getHeight() / 2), waterworld);
        playGamButton.setAnchorPoint(AnchorPoint.TOP_RIGHT);
        addEntity(playGamButton);

        var exitGameButton = new QuitButton(new Location(getWidth() / 2, getHeight() / 2), waterworld);
        exitGameButton.setAnchorPoint(AnchorPoint.TOP_LEFT);
        addEntity(exitGameButton);
    }

    @Override
    protected void onInputChanged(Set<KeyCode> input) {

    }
}
