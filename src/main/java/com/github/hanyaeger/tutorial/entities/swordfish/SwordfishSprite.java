package com.github.hanyaeger.tutorial.entities.swordfish;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.RectangleEntity;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;
import javafx.scene.paint.Color;

public class SwordfishSprite extends SpriteEntity {
    public SwordfishSprite(final Coordinate2D location) {
        super("sprites/swordfish.png", location);
    }
}

