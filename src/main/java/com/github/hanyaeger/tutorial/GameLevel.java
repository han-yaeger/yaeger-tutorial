package com.github.hanyaeger.tutorial;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.hanyaeger.tutorial.collectible.Collectible;
import com.github.hanyaeger.tutorial.collectible.HeavierPowerup;
import com.github.hanyaeger.tutorial.collectible.Key;
import com.github.hanyaeger.tutorial.platforms.GewichtPlatform;
import com.github.hanyaeger.tutorial.platforms.Platform;
import com.github.hanyaeger.tutorial.platforms.VastPlatform;

public class GameLevel extends DynamicScene  {
    private LavaExit lavaExit;

    public GameLevel(LavaExit lavaExit) {
        this.lavaExit = lavaExit;
    }
    @Override
    public void setupScene() {
        setBackgroundAudio("audio/lava.mp3");
        setBackgroundImage("backgrounds/slaapkamer.jpg");
    }

    @Override
    public void setupEntities() {
        Door door = new Door(new Coordinate2D(700, 500), new Size(50, 100));
        addEntity(door);

        Collectible heavierPowerup = new HeavierPowerup(new Coordinate2D(50, 470), new Size(70,70), 70);
        addEntity(heavierPowerup);

        Player player = new Player(new Coordinate2D(700, 20), lavaExit);
        addEntity(player);

        Collectible key = new Key(new Coordinate2D(500, 400), new Size(100, 50));
        addEntity(key);

        Platform vastPlatform = new VastPlatform(new Coordinate2D(50, 500), new Size(100, 50), "sprites/platform-solid.png");
        addEntity(vastPlatform);

        Platform aantalKeerPlatform = new GewichtPlatform(100, new Coordinate2D(200, 500), new Size(100, 50), "sprites/platform-solid.png");
        addEntity(aantalKeerPlatform);

    }
}
