package com.github.tvloet1.seacleaner.entities;

import java.util.Set;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.SceneBorderTouchingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;
import com.github.hanyaeger.api.userinput.KeyListener;
import com.github.tvloet1.seacleaner.SeaCleaner;

import com.github.tvloet1.seacleaner.entities.text.ScoreText;
import javafx.scene.input.KeyCode;

public class Swimmer extends DynamicSpriteEntity implements KeyListener, SceneBorderTouchingWatcher {

	private SeaCleaner seacleaner;
	private ScoreText scoreText;

	public Swimmer(Coordinate2D initialLocation, SeaCleaner seacleaner, ScoreText scoreText) {
		super("sprites/swimmingMan.png", initialLocation, new Size(120, 240), 1, 2);
		this.seacleaner = seacleaner;
		this.scoreText = scoreText;
		scoreText.setScoreText(0);
	}

	@Override
	public void onPressedKeysChange(Set<KeyCode> pressedKeys) {
		if (pressedKeys.contains(KeyCode.RIGHT) & pressedKeys.contains(KeyCode.DOWN)) {
			setMotion(3, 45d);
			setCurrentFrameIndex(2);
		} else if (pressedKeys.contains(KeyCode.RIGHT) & pressedKeys.contains(KeyCode.UP)) {
			setMotion(3, 135d);
			setCurrentFrameIndex(2);
		} else if (pressedKeys.contains(KeyCode.LEFT) & pressedKeys.contains(KeyCode.DOWN)) {
			setMotion(3, 315d);
			setCurrentFrameIndex(1);
		} else if (pressedKeys.contains(KeyCode.LEFT) & pressedKeys.contains(KeyCode.UP)) {
			setMotion(3, 225d);
			setCurrentFrameIndex(1);
		} else if (pressedKeys.contains(KeyCode.LEFT)) {
			setMotion(3, 270d);
			setCurrentFrameIndex(1);
		} else if (pressedKeys.contains(KeyCode.RIGHT)) {
			setMotion(3, 90d);
			setCurrentFrameIndex(2);
		} else if (pressedKeys.contains(KeyCode.UP)) {
			setMotion(3, 180d);
		} else if (pressedKeys.contains(KeyCode.DOWN)) {
			setMotion(3, 0d);
		} else if (pressedKeys.contains(KeyCode.T)) {
			seacleaner.setActiveScene(2);
		} else {
			setSpeed(0);
		}
	}

	@Override
	public void notifyBoundaryTouching(SceneBorder border) {
		setSpeed(0);
		switch (border) {
		case TOP:
			setAnchorLocationY(1);
			break;
		case BOTTOM:
			setAnchorLocationY(getSceneHeight() - getHeight() - 1);
			break;
		case LEFT:
			setAnchorLocationX(1);
			break;
		case RIGHT:
			setAnchorLocationX(getSceneWidth() - getWidth() - 1);
		default:
			break;
		}
	}

}
