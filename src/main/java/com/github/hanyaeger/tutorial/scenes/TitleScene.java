package com.github.hanyaeger.tutorial.scenes;

import com.github.hanyaeger.api.engine.scenes.StaticScene;
import javafx.scene.input.KeyCode;

import java.util.Set;

public class TitleScene extends StaticScene {

    @Override
    public void setupScene() {
        setBackgroundAudio("audio/ocean.mp3");
        setBackgroundImage("backgrounds/background1.jpg");
    }

    @Override
    public void setupEntities() {

    }

    @Override
    protected void onInputChanged(Set<KeyCode> input) {

    }
}
