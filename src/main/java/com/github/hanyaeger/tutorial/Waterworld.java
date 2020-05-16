package com.github.hanyaeger.tutorial;

import com.github.hanyaeger.api.engine.YaegerApplication;
import com.github.hanyaeger.tutorial.scenes.TitleScene;

public class Waterworld extends YaegerApplication {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    protected void initializeGame() {

    }

    @Override
    protected void setupScenes() {
        addScene(0, new TitleScene());
    }
}
