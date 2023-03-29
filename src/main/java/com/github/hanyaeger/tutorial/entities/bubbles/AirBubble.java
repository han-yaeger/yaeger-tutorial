package com.github.hanyaeger.tutorial.entities.bubbles;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.media.SoundClip;
import javafx.scene.paint.Color;

import java.util.List;

public class AirBubble extends Bubble {

    public AirBubble(Coordinate2D initialLocation) {
        super(initialLocation, 10.0, Color.DARKBLUE, Color.LIGHTBLUE);
        setMotion(2, 180d);
    }

    @Override
    public void onCollision(List<Collider> collidingObjects) {
        new SoundClip("audio/pop.mp3").play();
        this.remove();
    }
}
