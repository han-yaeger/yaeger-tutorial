package com.github.hanyaeger.tutorial;

import com.github.hanyaeger.api.engine.Size;
import com.github.hanyaeger.api.engine.YaegerApplication;
import com.github.hanyaeger.tutorial.scenes.TitleScene;

public class Waterworld extends YaegerApplication {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    protected void initializeGame() {
        setGameTitle("Waterworld");
        setSize(new Size(800, 600));
    }

    @Override
    protected void setupScenes() {
        addScene(0, new TitleScene());
    }
}
