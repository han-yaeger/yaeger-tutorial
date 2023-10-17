package com.github.hanyaeger.tutorial.collectible.powerup;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.tutorial.Player;
import com.github.hanyaeger.tutorial.collectible.Collectible;

public abstract class Powerup extends Collectible implements Collider {
    public Powerup(String resource, Coordinate2D location, Size size) {
        super(resource, location, size);
    }

    public abstract void pasToe(Player player);
}