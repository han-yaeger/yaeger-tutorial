package com.github.hanyaeger.tutorial.platforms;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.tutorial.Player;

public class GewichtPlatform extends Platform implements Collider, Collided {
    private int zwaar;

    public GewichtPlatform(int zwaar, Coordinate2D initialLocation, Size size, String resource) {
        super(initialLocation, size, resource);
        this.zwaar = zwaar;
    }

    @Override
    public void onCollision(Collider collider) {
        if (collider instanceof Player) {
            if (Player.gewicht > zwaar){
                remove();
            }
        }
    }
}
