package com.github.hanyaeger.tutorial.scenes;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.scenes.StaticScene;
import com.github.hanyaeger.tutorial.FishingSimulator;
import com.github.hanyaeger.tutorial.buttons.StartButton;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class TitleScene extends StaticScene {
    private FishingSimulator fishingSimulator;

    public TitleScene(FishingSimulator fishingSimulator){
        this.fishingSimulator = fishingSimulator;
    }

    @Override
    public void setupScene() {
        setBackgroundColor(Color.BEIGE);
    }

    @Override
    public void setupEntities() {
        var fishingSimulatorText = new TextEntity(
                new Coordinate2D(getWidth() / 2, getHeight() / 2),
                "Fishing Simulator"
        );
        fishingSimulatorText.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        fishingSimulatorText.setFill(Color.LIGHTSEAGREEN);
        fishingSimulatorText.setFont(Font.font("Roboto", FontWeight.SEMI_BOLD, 80));
        addEntity(fishingSimulatorText);

        var startButton = new StartButton(new Coordinate2D(getWidth() / 2, getHeight() / 2 + 100), fishingSimulator);
        addEntity(startButton);
    }

}
