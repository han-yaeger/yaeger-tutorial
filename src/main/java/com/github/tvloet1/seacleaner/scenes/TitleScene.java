package com.github.tvloet1.seacleaner.scenes;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.scenes.StaticScene;
import com.github.tvloet1.seacleaner.SeaCleaner;
import com.github.tvloet1.seacleaner.entities.buttons.StartButton;

import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class TitleScene extends StaticScene {
	private SeaCleaner seacleaner;

	public TitleScene(SeaCleaner seacleaner) {
		this.seacleaner = seacleaner;
	}

	@Override
	public void setupScene() {
		setBackgroundAudio("audio/behindEnemyLines.mp3");
		setBackgroundImage("backgrounds/background1.jpg");
	}

	@Override
	public void setupEntities() {
		var seacleanerText = new TextEntity(new Coordinate2D(getWidth() / 2, getHeight() / 2), "seacleaner");
		seacleanerText.setAnchorPoint(AnchorPoint.CENTER_CENTER);
		seacleanerText.setFill(Color.ORANGE);
		seacleanerText.setFont(Font.font("Courier New", FontWeight.BOLD, 80));
		addEntity(seacleanerText);
		var startButton = new StartButton(new Coordinate2D(getWidth() / 2, getHeight() * 0.6), seacleaner);
		startButton.setAnchorPoint(AnchorPoint.CENTER_CENTER);
		addEntity(startButton);
	}

}
