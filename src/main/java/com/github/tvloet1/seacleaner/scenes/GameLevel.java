package com.github.tvloet1.seacleaner.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.EntitySpawnerContainer;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.hanyaeger.api.scenes.TileMapContainer;
import com.github.tvloet1.seacleaner.SeaCleaner;
import com.github.tvloet1.seacleaner.entities.Swimmer;
import com.github.tvloet1.seacleaner.entities.text.ScoreText;

public class GameLevel extends DynamicScene implements EntitySpawnerContainer, TileMapContainer {

	private SeaCleaner seacleaner;

	public GameLevel(SeaCleaner seacleaner) {
		this.seacleaner = seacleaner;
	}

	@Override
	public void setupScene() {
		setBackgroundAudio("audio/behindEnemyLines.mp3");
		setBackgroundImage("backgrounds/backgroundGame.jpg");
	}

	@Override
	public void setupEntities() {
		var scoreText = new ScoreText(new Coordinate2D(5,5));
		addEntity(scoreText);
		var swimmer = new Swimmer(new Coordinate2D(500, 500), seacleaner, scoreText);
		addEntity(swimmer);
	}

	@Override
	public void setupEntitySpawners() {
	}

	@Override
	public void setupTileMaps() {
	}

}
