package com.github.hanyaeger.tutorial.scenes.levels;

import com.github.hanyaeger.api.engine.entities.entity.Location;
import com.github.hanyaeger.tutorial.Waterworld;
import com.github.hanyaeger.tutorial.entities.game.AnimatedShark;

public class LevelTwo extends Level {

    private static final String BACKGROUND_IMAGE = "backgrounds/underwater3.jpg";

    public LevelTwo(Waterworld waterworld) {
        super(waterworld);
    }

    @Override
    public void setupScene() {
        super.setupScene();
        setBackgroundImage(BACKGROUND_IMAGE);
    }

    @Override
    public void setupEntities() {
        super.setupEntities();

        var animatedSwordFish = new AnimatedShark(new Location(400, 400));
        addEntity(animatedSwordFish);
    }
}
