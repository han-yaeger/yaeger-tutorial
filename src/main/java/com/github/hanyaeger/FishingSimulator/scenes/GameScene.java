package com.github.hanyaeger.FishingSimulator.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.hanyaeger.FishingSimulator.entities.Player;

public class GameScene extends DynamicScene {

    @Override
    public void setupScene() {
        setBackgroundImage("backgrounds/gameBackground.gif");
    }

    @Override
    public void setupEntities() {
        addEntity(new Player(new Coordinate2D(250, 400)));
    }
}
