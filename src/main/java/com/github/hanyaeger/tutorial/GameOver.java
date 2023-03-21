package com.github.hanyaeger.tutorial;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.YaegerEntity;
import com.github.hanyaeger.api.scenes.StaticScene;
import com.github.hanyaeger.tutorial.entities.buttons.PlayAgainButton;
import com.github.hanyaeger.tutorial.entities.buttons.QuitGameButton;
import com.github.hanyaeger.tutorial.entities.text.GameOverText;

public class GameOver extends StaticScene {
    private final Waterworld waterworld;

    public GameOver(Waterworld waterworld) {
        this.waterworld = waterworld;
    }

    @Override
    public void setupScene() {
        setBackgroundImage("backgrounds/background3.jpg");
    }

    @Override
    public void setupEntities() {
        addEntity(createGameOverText());
        addEntity(createPlayAgainButton());
        addEntity(createQuitGameButton());
    }

    private YaegerEntity createGameOverText() {
        return new GameOverText(new Coordinate2D(getWidth() / 2, getHeight() / 2));
    }

    private YaegerEntity createPlayAgainButton() {
        return new PlayAgainButton(new Coordinate2D(getWidth() / 2, getHeight() - (getHeight() / 3)), waterworld);
    }

    private YaegerEntity createQuitGameButton() {
        return new QuitGameButton(new Coordinate2D(getWidth() / 2, getHeight() - (getHeight() / 4)), waterworld);
    }
}
