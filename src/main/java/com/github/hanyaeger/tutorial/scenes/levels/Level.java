package com.github.hanyaeger.tutorial.scenes.levels;

import com.github.hanyaeger.api.engine.entities.entity.Location;
import com.github.hanyaeger.api.engine.entities.entity.shape.text.TextEntity;
import com.github.hanyaeger.api.engine.scenes.DynamicScene;
import com.github.hanyaeger.api.engine.scenes.WithSpawners;
import com.github.hanyaeger.tutorial.Waterworld;
import com.github.hanyaeger.tutorial.entities.game.Player;
import com.github.hanyaeger.tutorial.entities.game.spawners.BubbleSpawner;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import com.github.hanyaeger.tutorial.entities.game.Swordfish;

public abstract class Level extends DynamicScene implements WithSpawners {

    private static final String BACKGROUND_AUDIO = "audio/waterworld.mp3";

    protected Waterworld waterworld;
    int bubblesPopped = 0;
    private TextEntity bubblesPoppedText;
    private TextEntity healthText;

    Level(final Waterworld waterworld) {
        this.waterworld = waterworld;
    }

    @Override
    public void setupEntities() {
        bubblesPoppedText = new TextEntity(new Location(10, 5));
        bubblesPoppedText.setFont(Font.font(Waterworld.FONT, 40));
        bubblesPoppedText.setFill(Color.VIOLET);
        addEntity(bubblesPoppedText);
        updateBubblesPoppedText();

        healthText = new TextEntity(new Location(960, 5));
        healthText.setFont(Font.font(Waterworld.FONT, 40));
        healthText.setFill(Color.DARKBLUE);
        addEntity(healthText);
        setHealthText(10);

        var swordFish = new Swordfish(new Location(200, 200));
        addEntity(swordFish);

        var player = new Player(new Location(100, 100), this, 10);
        addEntity(player);
    }

    @Override
    public void setupScene() {
        setBackgroundAudio(BACKGROUND_AUDIO);
    }

    /**
     * Zet de healthwaarde van de speler.
     *
     * @param health De health als integer.
     */
    public void setHealthText(final int health) {
        healthText.setText("Health: " + health);
    }

    /**
     * Verhoog de waarde van het aantal gepopte bubbles.
     */
    public void increaseBubblesPopped() {
        bubblesPopped++;
        updateBubblesPoppedText();
    }

    public void setupEntitySpawners() {
        addEntitySpawner(new BubbleSpawner(getWidth(), getHeight(), this));
    }

    /**
     * Deze methode wordt aangeroepen wanneer de speler sterft.
     */
    public void playerDied() {
        waterworld.nextScene(Waterworld.SCENE_GAME_OVER);
    }

    private void updateBubblesPoppedText() {
        bubblesPoppedText.setText("Bubbles popped: " + bubblesPopped);
    }
}
