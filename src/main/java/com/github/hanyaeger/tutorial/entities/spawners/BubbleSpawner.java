package com.github.hanyaeger.tutorial.entities.spawners;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.EntitySpawner;
import com.github.hanyaeger.tutorial.entities.Hanny;
import com.github.hanyaeger.tutorial.entities.bubbles.AirBubble;
import com.github.hanyaeger.tutorial.entities.bubbles.PoisonBubble;

import java.util.Random;

public class BubbleSpawner extends EntitySpawner {
    private final double sceneWidth;
    private final double sceneHeight;
    private final Hanny hanny;

    public BubbleSpawner(double sceneWidth, double sceneHeight, Hanny hanny) {
        super(1000);
        this.sceneWidth = sceneWidth;
        this.sceneHeight = sceneHeight;
        this.hanny = hanny;
    }

    private Coordinate2D randomLocation() {
        double x = new Random().nextInt((int) sceneWidth);
        return new Coordinate2D(x, sceneHeight);
    }

    @Override
    protected void spawnEntities() {
        if (new Random().nextInt(10) < 3) {
            spawn(new PoisonBubble(randomLocation(), hanny));
        }
        else {
            spawn(new AirBubble(randomLocation()));
        }
    }
}
