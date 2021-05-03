package com.github.hanyaeger.tutorial.entities.buttons;

import com.github.hanyaeger.api.engine.entities.entity.Coordinate2D;
import com.github.hanyaeger.api.engine.entities.entity.shape.text.TextEntity;
import com.github.hanyaeger.api.engine.styles.HanFont;
import com.github.hanyaeger.api.engine.styles.HanFontStyle;
import com.github.hanyaeger.api.engine.userinput.MouseButtonPressedListener;
import com.github.hanyaeger.api.engine.userinput.MouseEnterListener;
import com.github.hanyaeger.api.engine.userinput.MouseExitListener;
import com.github.hanyaeger.tutorial.Waterworld;
import javafx.scene.Cursor;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;

public class QuitButton extends TextEntity implements MouseButtonPressedListener, MouseEnterListener, MouseExitListener {

    private final Waterworld waterworld;

    public QuitButton(Coordinate2D initialPosition, Waterworld waterworld) {
        super(initialPosition, "Quit game");
        this.waterworld = waterworld;
        setFill(Color.ORANGE);
        setFont(HanFont.createDefaultCondensedFont(HanFontStyle.BOLD, 30));
    }

    @Override
    public void onMouseButtonPressed(MouseButton button, double x, double y) {
        waterworld.quit();
    }

    @Override
    public void onMouseEntered() {
        setFill(Color.LIGHTYELLOW);
        setCursor(Cursor.HAND);
    }

    @Override
    public void onMouseExited() {
        setFill(Color.ORANGE);
        setCursor(Cursor.DEFAULT);
    }
}
