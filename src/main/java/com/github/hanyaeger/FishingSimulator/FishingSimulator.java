package com.github.hanyaeger.FishingSimulator;

import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.YaegerGame;

public class FishingSimulator extends YaegerGame {
    public void main(String[] args) {
        launch(args);
    }

    private static final String GAME_TITLE = "Fishing Simulator";
    private static final Size SIZE = new Size(1280, 720);

    @Override
    public void setupGame() {
        setGameTitle(GAME_TITLE);
        setSize(SIZE);
    }

    @Override
    public void setupScenes() {

    }
}

