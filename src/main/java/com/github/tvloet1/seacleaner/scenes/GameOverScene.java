package com.github.tvloet1.seacleaner.scenes;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.scenes.StaticScene;
import com.github.tvloet1.seacleaner.SeaCleaner;
import com.github.tvloet1.seacleaner.entities.buttons.PlayAgainButton;
import com.github.tvloet1.seacleaner.entities.buttons.QuitGameButton;

public class GameOverScene extends StaticScene {
	private SeaCleaner seacleaner;

	public GameOverScene(SeaCleaner seacleaner) {
		this.seacleaner = seacleaner;
	}

	@Override
	public void setupScene() {
		setBackgroundAudio("audio/ocean.mp3");
		setBackgroundImage("backgrounds/background3.jpg");
	}

	@Override
	public void setupEntities() {
		var playAgainButton = new PlayAgainButton(
				new Coordinate2D(getWidth() / 2,getHeight() / 10 * 3),seacleaner
		);
		playAgainButton.setAnchorPoint(AnchorPoint.CENTER_CENTER);
		addEntity(playAgainButton);


		var quitGameButton = new QuitGameButton(
				new Coordinate2D(getWidth() / 2,getHeight() / 10 * 4),seacleaner
		);
		quitGameButton.setAnchorPoint(AnchorPoint.CENTER_CENTER);
		addEntity(quitGameButton);
	}

}
