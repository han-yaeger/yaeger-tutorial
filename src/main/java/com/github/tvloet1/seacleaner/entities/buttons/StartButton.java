package com.github.tvloet1.seacleaner.entities.buttons;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import com.github.hanyaeger.api.userinput.MouseEnterListener;
import com.github.hanyaeger.api.userinput.MouseExitListener;

import com.github.tvloet1.seacleaner.SeaCleaner;
import javafx.scene.Cursor;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class StartButton extends TextEntity
		implements MouseButtonPressedListener, MouseEnterListener, MouseExitListener {

	private SeaCleaner seacleaner;

	public StartButton(Coordinate2D initialLocation, SeaCleaner seacleaner) {
		super(initialLocation, "Play game");
		setFill(Color.ORANGE);
		setFont(Font.font("Courier New", FontWeight.BOLD, 50));
		this.seacleaner = seacleaner;
	}

	@Override
	public void onMouseExited() {
		setFill(Color.ORANGE);
		setCursor(Cursor.DEFAULT);
	}

	@Override
	public void onMouseEntered() {
		setFill(Color.YELLOW);
		setCursor(Cursor.HAND);
	}

	@Override
	public void onMouseButtonPressed(MouseButton button, Coordinate2D coordinate2d) {
		seacleaner.setActiveScene(1);
	}

}
