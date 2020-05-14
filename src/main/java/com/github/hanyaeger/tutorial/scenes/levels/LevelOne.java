package com.github.hanyaeger.tutorial.scenes.levels;

import com.github.hanyaeger.api.engine.entities.tilemap.WithTileMaps;
import com.github.hanyaeger.tutorial.Waterworld;
import com.github.hanyaeger.tutorial.entities.game.tilemaps.CoralTileMap;

public class LevelOne extends Level implements WithTileMaps {

    private static final String BACKGROUND_IMAGE = "backgrounds/underwater2.jpg";

    public LevelOne(final Waterworld waterworld) {
        super(waterworld);
    }

    @Override
    public void setupScene() {
        super.setupScene();
        setBackgroundImage(BACKGROUND_IMAGE);
    }

    @Override
    public void increaseBubblesPopped() {
        super.increaseBubblesPopped();

        if (bubblesPopped > 2) {
            waterworld.nextScene(Waterworld.SCENE_LEVEL_TWO);
        }
    }

    @Override
    public void setupTileMaps() {
        var coralMap = new CoralTileMap();
        addTileMap(coralMap);
    }
}
