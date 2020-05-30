package com.github.hanyaeger.tutorial.scenes;

import com.github.hanyaeger.api.engine.entities.entity.Location;
import com.github.hanyaeger.api.engine.scenes.DynamicScene;
import com.github.hanyaeger.tutorial.entities.Hanny;
import com.github.hanyaeger.tutorial.entities.HealthText;
import com.github.hanyaeger.tutorial.entities.Swordfish;

public class Level extends DynamicScene {

    @Override
    public void setupScene() {
        setBackgroundImage("backgrounds/background2.jpg");
        setBackgroundAudio("audio/waterworld.mp3");
    }

    @Override
    public void setupEntities() {
        var healthText = new HealthText(new Location(5, 5));
        addEntity(healthText);

        addEntity(new Hanny(new Location(0, 0), healthText));
        addEntity(new Swordfish(new Location(200, 300)));
    }
}
