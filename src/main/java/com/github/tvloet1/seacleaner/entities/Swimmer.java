package com.github.tvloet1.seacleaner.entities;

import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.SceneBorderTouchingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;
import com.github.hanyaeger.api.userinput.KeyListener;
import com.github.tvloet1.seacleaner.entities.text.BreathText;

import javafx.scene.input.KeyCode;

public class Swimmer extends DynamicSpriteEntity implements KeyListener, SceneBorderTouchingWatcher {

	private BreathText breathText;
	private int breath = 60;
	private Timer timer;

	public Swimmer(Coordinate2D initialLocation, BreathText breathText, Timer timer) {
		super("sprites/swimmingMan.png", initialLocation, new Size(120, 240), 1, 2);
		this.breathText = breathText;
		this.timer = timer;
		breathText.setBreathText(breath);
		initiateBreathTimer();
	}

	private void initiateBreathTimer() {
		TimerTask task = new TimerTask() {
			@Override
			public void run() {
				decreaseBreath();
				System.out.println("Breathe!");
			}
		};
		timer.scheduleAtFixedRate(task, 1, 1000);
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
			decreaseBreath();
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
			increaseBreath();
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

	public void decreaseBreath() {
		breath--;
		breathText.setBreathText(breath);
	}

	private void increaseBreath() {
		breath += 10;
		if (breath > 60) {
			breath = 60;
		}
		breathText.setBreathText(breath);
	}

	private void constrainToRange(int breath2, int i, int j) {
		// TODO Auto-generated method stub

	}
}
