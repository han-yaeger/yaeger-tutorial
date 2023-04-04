package com.github.tvloet1.seacleaner.scenes;

import java.util.Timer;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.EntitySpawnerContainer;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.hanyaeger.api.scenes.TileMapContainer;
import com.github.tvloet1.seacleaner.SeaCleaner;
import com.github.tvloet1.seacleaner.entities.GarbageBag;
import com.github.tvloet1.seacleaner.entities.Swimmer;
import com.github.tvloet1.seacleaner.entities.text.BreathText;

public class GameLevel extends DynamicScene implements EntitySpawnerContainer, TileMapContainer {

	private SeaCleaner seacleaner;

	public GameLevel(SeaCleaner seacleaner) {
		this.seacleaner = seacleaner;
	}

	@Override
	public void setupScene() {
		setBackgroundAudio("audio/behindEnemyLines.mp3");
		setBackgroundImage("backgrounds/background1.jpg");
	}

	@Override
	public void setupEntities() {
		var breathText = new BreathText(new Coordinate2D(5, 5));
		addEntity(breathText);
		var timer = new Timer();
		var swimmer = new Swimmer(new Coordinate2D(500, 500), breathText, timer);
		addEntity(swimmer);
		var garbageBag = new GarbageBag(new Coordinate2D(250, 250));
		addEntity(garbageBag);
	}

	@Override
	public void setupEntitySpawners() {

	}

	@Override
	public void setupTileMaps() {
	}

}
