package com.github.hanyaeger.tutorial.scenes;

import com.github.hanyaeger.api.scenes.DynamicScene;

public class GameLevel extends DynamicScene {
    @Override
    public void setupScene() {
        setBackgroundAudio("audio/waterworld.mp3");
        setBackgroundImage("backgrounds/background2.jpg");
    }

    @Override
    public void setupEntities() {

    }
}
