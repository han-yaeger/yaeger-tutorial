package com.github.hanyaeger.tutorial.scenes;

import com.github.hanyaeger.api.engine.entities.entity.AnchorPoint;
import com.github.hanyaeger.api.engine.entities.entity.Location;
import com.github.hanyaeger.api.engine.entities.entity.shape.text.TextEntity;
import com.github.hanyaeger.api.engine.scenes.StaticScene;
import com.github.hanyaeger.api.engine.styles.HanFont;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;

import java.util.Set;

public class TitleScene extends StaticScene {

    @Override
    public void setupScene() {
        setBackgroundAudio("audio/ocean.mp3");
        setBackgroundImage("backgrounds/background1.jpg");
    }

    @Override
    public void setupEntities() {
        var waterworldText = new TextEntity(new Location(getWidth() / 2, getHeight() / 2), "Waterworld");
        waterworldText.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        waterworldText.setFill(Color.DARKBLUE);
        waterworldText.setFont(HanFont.createDefaultCondensedFont(80));
        addEntity(waterworldText);
    }

    @Override
    protected void onInputChanged(Set<KeyCode> input) {

    }
}
