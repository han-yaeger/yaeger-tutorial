package com.github.hanyaeger.tutorial.entities.bubbles;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.tutorial.entities.Hanny;
import com.github.hanyaeger.tutorial.settings.EnemyDamage;
import javafx.scene.paint.Color;

import java.util.List;

public class PoisonBubble extends Bubble {
    private final Hanny hanny;

    public PoisonBubble(Coordinate2D initialLocation, Hanny hanny) {
        super(initialLocation, 25.0, Color.DARKGREEN, Color.LIGHTGREEN);
        setMotion(1, 180d);

        this.hanny = hanny;
    }

    @Override
    public void onCollision(List<Collider> collidingObjects) {
        if (collidingObjects.contains(hanny)) {
            hanny.decrementHealth(EnemyDamage.POISON_BUBBLE.getDamage());
            this.remove();
        }
    }
}
