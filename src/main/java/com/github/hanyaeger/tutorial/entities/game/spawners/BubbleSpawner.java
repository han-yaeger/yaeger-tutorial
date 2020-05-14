package com.github.hanyaeger.tutorial.entities.game.spawners;

import com.github.hanyaeger.api.engine.entities.EntitySpawner;
import com.github.hanyaeger.api.engine.entities.entity.Location;
import com.github.hanyaeger.tutorial.entities.game.Air;
import com.github.hanyaeger.tutorial.entities.game.Poison;
import com.github.hanyaeger.tutorial.scenes.levels.Level;

import java.util.Random;

public class BubbleSpawner extends EntitySpawner {

    private final double worldWidth;
    private final double worldHeight;
    private Level waterworld;

    public BubbleSpawner(double width, double height, Level waterworld) {
        super(100);

        this.worldWidth = width;
        this.worldHeight = height;
        this.waterworld = waterworld;
    }

    private void createAir() {
        var air = new Air(generateRandomPosition(), generateRandomSpeed(), waterworld);

        spawn(air);
    }

    private void createPoison() {
        var poison = new Poison(generateRandomPosition(), generateRandomSpeed(), waterworld);

        spawn(poison);
    }

    private int generateRandomSpeed() {
        return new Random().nextInt(4) + 1;
    }

    private Location generateRandomPosition() {
        int x = new Random().nextInt((int) Math.round(worldWidth));
        int y = (int) Math.round(worldHeight);

        return new Location(x, y);
    }

    @Override
    protected void spawnEntities() {
        if (new Random().nextInt(10) < 2) {
            createPoison();
        } else {
            createAir();
        }
    }
}
