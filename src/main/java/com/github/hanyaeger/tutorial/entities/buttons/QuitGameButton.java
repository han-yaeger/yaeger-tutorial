package com.github.hanyaeger.tutorial.entities.buttons;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import com.github.hanyaeger.api.userinput.MouseEnterListener;
import com.github.hanyaeger.api.userinput.MouseExitListener;
import com.github.hanyaeger.tutorial.Waterworld;
import javafx.scene.Cursor;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class QuitGameButton extends TextEntity implements MouseButtonPressedListener, MouseEnterListener, MouseExitListener {
    private final Waterworld waterworld;

    public QuitGameButton(Coordinate2D initialLocation, Waterworld waterworld) {
        super(initialLocation);
        this.waterworld = waterworld;

        setFont(Font.font("Roboto", FontWeight.NORMAL, 30));
        setFill(Color.LIGHTGREY);
        setAnchorPoint(AnchorPoint.CENTER_CENTER);
        setText("Quit Game");
    }

    @Override
    public void onMouseButtonPressed(MouseButton button, Coordinate2D coordinate2D) {
        waterworld.quit();
    }

    @Override
    public void onMouseEntered() {
        setFill(Color.SLATEGREY);
        setCursor(Cursor.HAND);
    }

    @Override
    public void onMouseExited() {
        setFill(Color.LIGHTGREY);
        setCursor(Cursor.DEFAULT);
    }
}
