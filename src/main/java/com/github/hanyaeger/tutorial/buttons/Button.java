package com.github.hanyaeger.tutorial.buttons;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import com.github.hanyaeger.api.userinput.MouseEnterListener;
import com.github.hanyaeger.api.userinput.MouseExitListener;
import com.github.hanyaeger.tutorial.LavaExit;
import javafx.scene.Cursor;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class Button extends TextEntity implements MouseButtonPressedListener, MouseEnterListener, MouseExitListener {
    private LavaExit lavaExit;
    private int scene;

    public Button(Coordinate2D initialLocation, String titel, int scene, LavaExit lavaExit){
        super(initialLocation, titel);
        this.lavaExit = lavaExit;
        this.scene = scene;
        setFill(Color.WHITE);
        setFont(Font.font("Roboto", FontWeight.BOLD, 30));
    }

    @Override
    public void onMouseButtonPressed(MouseButton mouseButton, Coordinate2D coordinate2D) {
        lavaExit.setActiveScene(scene);
    }

    @Override
    public void onMouseExited() {
        setFill(Color.WHITE);
        setCursor(Cursor.DEFAULT);
    }

    @Override
    public void onMouseEntered() {
        setFill(Color.LIGHTGREY);
        setCursor(Cursor.HAND);
    }
}
