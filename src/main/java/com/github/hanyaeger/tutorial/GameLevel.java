package com.github.hanyaeger.tutorial;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.hanyaeger.tutorial.collectible.Collectible;
import com.github.hanyaeger.tutorial.collectible.powerup.HeavierPowerup;
import com.github.hanyaeger.tutorial.collectible.Key;
import com.github.hanyaeger.tutorial.collectible.powerup.Powerup;
import com.github.hanyaeger.tutorial.collectible.powerup.SpringenPowerup;
import com.github.hanyaeger.tutorial.platforms.GewichtPlatform;
import com.github.hanyaeger.tutorial.platforms.Platform;
import com.github.hanyaeger.tutorial.platforms.SecondenPlatform;
import com.github.hanyaeger.tutorial.platforms.VastPlatform;
import com.github.hanyaeger.tutorial.text.Text;

public class GameLevel extends DynamicScene {
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
        Text gewichtText = new Text(new Coordinate2D(10, 10), 30);
        Text inventoryText = new Text(new Coordinate2D(10, 40), 20);
        Player player = new Player(gewichtText, inventoryText, new Coordinate2D(70, 300));

        Collectible key = new Key(new Coordinate2D(530, 150), new Size(100, 50));
        Collectible heavierPowerup = new HeavierPowerup(new Coordinate2D(600, 500), new Size(50, 50), 70);
        Collectible springenPowerup = new SpringenPowerup(new Coordinate2D(500, 450), new Size(120, 60));

        Door door = new Door((Key) key, lavaExit, new Coordinate2D(720, 480), new Size(50, 100));

        Lava lava = new Lava((Key) key, player, lavaExit, new Coordinate2D(0, 580), new Size(800, 800));

        Platform vastPlatform1 = new VastPlatform(new Coordinate2D(0, 500));
        Platform vastPlatform2 = new VastPlatform(new Coordinate2D(325, 400));
        Platform vastPlatform3 = new VastPlatform(new Coordinate2D(700, 550));
        Platform vastPlatform4 = new VastPlatform(new Coordinate2D(450, 500));

        Text maxGewichtText1 = new Text(new Coordinate2D(500, 200), 10);
        Platform gewichtPlatform1 = new GewichtPlatform(maxGewichtText1, 100, new Coordinate2D(500, 200));

        Text secondenText1 = new Text(new Coordinate2D(200, 500), 10);
        Platform secondenPlatform1 = new SecondenPlatform(secondenText1, new Coordinate2D(200, 500), 7);
        Text secondenText2 = new Text(new Coordinate2D(550, 550), 10);
        Platform secondenPlatform2 = new SecondenPlatform(secondenText2, new Coordinate2D(550, 550), 7);

        addEntity(gewichtText);
        addEntity(inventoryText);
        addEntity(key);
        addEntity(heavierPowerup);
        addEntity(springenPowerup);
        addEntity(door);
        addEntity(player);
        addEntity(lava);
        addEntity(vastPlatform1);
        addEntity(vastPlatform2);
        addEntity(vastPlatform3);
        addEntity(vastPlatform4);

        addEntity(gewichtPlatform1);
        addEntity(maxGewichtText1);

        addEntity(secondenPlatform1);
        addEntity(secondenText1);
        addEntity(secondenPlatform2);
        addEntity(secondenText2);
    }

}
