package com.github.hanyaeger.tutorial.entities.sharky;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;

public class SharkySprite extends DynamicSpriteEntity {
    public SharkySprite(Size sharkySize) {
        super("sprites/sharky.png", new Coordinate2D(0, 0), sharkySize , 1, 19);
        setAutoCycle(250);
    }
}
