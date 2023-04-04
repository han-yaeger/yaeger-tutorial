package com.github.tvloet1.seacleaner.entities;

import java.util.Set;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.userinput.KeyListener;

import javafx.scene.input.KeyCode;

public class GarbageBag extends DynamicSpriteEntity implements KeyListener {

	public GarbageBag(Coordinate2D initialLocation) {
		super("sprites/garbageBag.png", initialLocation, new Size(60, 120), 1, 8);
	}

	@Override
	public void onPressedKeysChange(Set<KeyCode> pressedKeys) {
		if (pressedKeys.contains(KeyCode.A)) {
			setCurrentFrameIndex(getCurrentFrameIndex() + 1);
		} else if (pressedKeys.contains(KeyCode.B)) {
			setCurrentFrameIndex(getCurrentFrameIndex() - 1);
		}
	}

}
