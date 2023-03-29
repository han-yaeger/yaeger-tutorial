package com.github.hanyaeger.tutorial.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.hanyaeger.tutorial.entities.Hanny;
import com.github.hanyaeger.tutorial.entities.Swordfish;

public class GameLevel extends DynamicScene {
    @Override
    public void setupScene() {
        setBackgroundAudio("audio/waterworld.mp3");
        setBackgroundImage("backgrounds/background2.jpg");
    }

    @Override
    public void setupEntities() {
        var swordfish = new Swordfish(new Coordinate2D(getHeight() / 2, getWidth() / 2));
        addEntity(swordfish);
        var hanny = new Hanny(new Coordinate2D(getHeight() / 10, getWidth() / 10));
        addEntity(hanny);
    }
}
