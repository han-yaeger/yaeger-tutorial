package com.github.hanyaeger.tutorial.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.EntitySpawnerContainer;
import com.github.hanyaeger.api.entities.YaegerEntity;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.hanyaeger.tutorial.Waterworld;
import com.github.hanyaeger.tutorial.entities.Hanny;
import com.github.hanyaeger.tutorial.entities.sharky.SharkyEnemy;
import com.github.hanyaeger.tutorial.entities.spawners.BubbleSpawner;
import com.github.hanyaeger.tutorial.entities.swordfish.Swordfish;
import com.github.hanyaeger.tutorial.entities.text.HealthText;

public class GameLevel extends DynamicScene implements EntitySpawnerContainer {
    private final Waterworld waterworld;

    private static Hanny hanny;

    public GameLevel(Waterworld waterworld) {
        this.waterworld = waterworld;
    }

    private HealthText createHealthText() {
        return new HealthText(new Coordinate2D(getWidth() - (getWidth() / 5), 10));
    }

    private YaegerEntity createPlayer(HealthText healthText) {
        return hanny = new Hanny(new Coordinate2D(10, 10), waterworld, healthText);
    }

    private YaegerEntity createSwordfishEnemy() {
        return new Swordfish(new Coordinate2D(getWidth() - (getWidth() / 10), getHeight() - ((getHeight() / 4))));
    }

    private YaegerEntity createSharkyEnemy() {
        return new SharkyEnemy(new Coordinate2D(10, getHeight() - (getHeight() / 2)));
    }

    @Override
    public void setupScene() {
//        setBackgroundAudio("audio/waterworld.mp3");
        setBackgroundImage("backgrounds/background2.jpg");
    }

    @Override
    public void setupEntities() {
        HealthText healthText = createHealthText();
        addEntity(healthText);

        addEntity(createPlayer(healthText));

        addEntity(createSwordfishEnemy());
        addEntity(createSharkyEnemy());
    }

    @Override
    public void setupEntitySpawners() {
        addEntitySpawner(new BubbleSpawner(getWidth(), getHeight(), hanny));
    }
}
