package com.github.hanyaeger.tutorial;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.hanyaeger.tutorial.platforms.Platform;
import com.github.hanyaeger.tutorial.platforms.VastPlatform;

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

        Platform vastPlatform = new VastPlatform(new Coordinate2D(50, 500), new Size(100, 50), "sprites/platform-solid.png");
        addEntity(vastPlatform);
    }
}
