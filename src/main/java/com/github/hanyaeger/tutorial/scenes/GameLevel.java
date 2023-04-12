package com.github.hanyaeger.tutorial.scenes;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.hanyaeger.tutorial.entities.Hanny;
import com.github.hanyaeger.tutorial.entities.sharky.Sharky;
import com.github.hanyaeger.tutorial.entities.swordfish.SwordFish;
import com.github.hanyaeger.tutorial.entities.text.HealthText;

import java.util.Random;

public class GameLevel extends DynamicScene {
    @Override
    public void setupScene() {
        setBackgroundAudio("audio/waterworld.mp3");
        setBackgroundImage("backgrounds/background2.jpg");
    }

    @Override
    public void setupEntities() {
        var swordfish = new SwordFish(new Coordinate2D(getHeight() / 2, getWidth() / 2));
        addEntity(swordfish);
        var sharky = new Sharky(new Coordinate2D(getHeight() / 2,getWidth() / 2));
        addEntity(sharky);
        var healthText = new HealthText(new Coordinate2D(getHeight() / 2, getWidth() / 2));
        healthText.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        addEntity(healthText);
        var hanny = new Hanny(new Coordinate2D(getHeight() / 10, getWidth() / 10), healthText);
        addEntity(hanny);
    }
}
