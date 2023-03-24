package com.github.hanyaeger.tutorial;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.scenes.DynamicScene;

public class GameLevel extends DynamicScene  {
    @Override
    public void setupScene() {
        setBackgroundAudio("audio/lava.mp3");
        setBackgroundImage("backgrounds/slaapkamer.jpg");
    }

    @Override
    public void setupEntities() {
        Player player = new Player(new Coordinate2D(700, 20));
        addEntity(player);
    }
}
