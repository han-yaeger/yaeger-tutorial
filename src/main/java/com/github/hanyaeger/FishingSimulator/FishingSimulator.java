package com.github.hanyaeger.FishingSimulator;

import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.YaegerGame;
import com.github.hanyaeger.FishingSimulator.scenes.GameScene;
import com.github.hanyaeger.FishingSimulator.scenes.TitleScene;

public class FishingSimulator extends YaegerGame {

    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void setupGame() {
        setGameTitle("Fishing Simulator");
        setSize(new Size(1280, 720));
    }

    @Override
    public void setupScenes() {
        addScene(0, new TitleScene(this));
        addScene(1, new GameScene());
    }

}
