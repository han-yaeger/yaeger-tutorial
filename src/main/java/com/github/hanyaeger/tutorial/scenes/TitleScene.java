package com.github.hanyaeger.tutorial.scenes;

import com.github.hanyaeger.api.engine.entities.entity.AnchorPoint;
import com.github.hanyaeger.api.engine.entities.entity.Location;
import com.github.hanyaeger.api.engine.entities.entity.shape.text.TextEntity;
import com.github.hanyaeger.api.engine.scenes.StaticScene;
import com.github.hanyaeger.api.engine.styles.HanFont;
import com.github.hanyaeger.api.engine.styles.HanFontStyle;
import com.github.hanyaeger.tutorial.Waterworld;
import com.github.hanyaeger.tutorial.buttons.StartButton;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;

import java.util.Set;

public class TitleScene extends StaticScene {

    private Waterworld waterworld;

    public TitleScene(Waterworld waterworld) {
        this.waterworld = waterworld;
    }

    @Override
    public void setupScene() {
        setBackgroundAudio("audio/ocean.mp3");
        setBackgroundImage("backgrounds/background1.jpg");
    }

    @Override
    public void setupEntities() {
        var waterworldText = new TextEntity(new Location(getWidth() / 2, getHeight() / 2), "Waterworld");
        waterworldText.setAnchorPoint(AnchorPoint.BOTTOM_CENTER);
        waterworldText.setFill(Color.LIGHTBLUE);
        waterworldText.setFont(HanFont.createDefaultCondensedFont(HanFontStyle.DEMI_BOLD, 80));
        addEntity(waterworldText);

        var playGameText = new StartButton(new Location(getWidth() / 2, getHeight() / 2), waterworld);
        playGameText.setAnchorPoint(AnchorPoint.TOP_CENTER);
        addEntity(playGameText);
    }

    @Override
    protected void onInputChanged(Set<KeyCode> input) {

    }
}
