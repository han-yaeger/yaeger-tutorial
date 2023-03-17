package com.github.hanyaeger.tutorial;

import com.github.hanyaeger.api.YaegerGame;


public class Waterworld extends YaegerGame {
    public static void main(String[] args){
        launch(args);
    }
    @Override
    protected void setupGame() {
        setGameTitle("Waterworld");
        setSize(new Size(800, 600));
    }
}

