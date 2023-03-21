package com.github.hanyaeger.tutorial;

import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.YaegerGame;
import com.github.hanyaeger.tutorial.scenes.GameLevel;

public class Waterworld extends YaegerGame {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void setupGame() {
        setGameTitle("Waterworld");
        setSize(new Size(1024, 768));
    }

    @Override
    public void setupScenes() {
        addScene(0, new TitleScene(this));
        addScene(1, new GameLevel(this));
        addScene(2, new GameOver(this));
    }
}
