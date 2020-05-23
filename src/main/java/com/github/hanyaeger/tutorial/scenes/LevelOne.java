package com.github.hanyaeger.tutorial.scenes;

import com.github.hanyaeger.api.engine.scenes.DynamicScene;

public class LevelOne extends DynamicScene {

    @Override
    public void setupScene() {
        setBackgroundImage("backgrounds/background2.jpg");
        setBackgroundAudio("audio/waterworld.mp3");
    }

    @Override
    public void setupEntities() {

    }
}
