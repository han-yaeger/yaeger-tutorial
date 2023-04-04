package com.github.tvloet1.seacleaner.scenes;

import com.github.hanyaeger.api.scenes.StaticScene;
import com.github.tvloet1.seacleaner.SeaCleaner;

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
	}

}
