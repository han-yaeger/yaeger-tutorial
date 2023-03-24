package com.github.hanyaeger.tutorial;

import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.YaegerGame;

public class LavaExit extends YaegerGame {
    @Override
    public void setupGame() {
        setGameTitle("LavaExit");
        setSize(new Size(800, 600));
    }

    @Override
    public void setupScenes() {
        addScene(0, new Startscherm(this));
        addScene(1, new GameLevel());
    }
}
