package com.github.hanyaeger.tutorial.platforms;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.tutorial.Player;
import com.github.hanyaeger.tutorial.text.Text;

public class GewichtPlatform extends Platform implements Collided {
    private Text maxGewichtText;
    private int maxGewicht;
    private Player player;

    public GewichtPlatform(Text maxGewichtText, Player player, int maxGewicht, Coordinate2D initialLocation) {
        super(initialLocation);
        this.maxGewicht = maxGewicht;
        this.player = player;
        this.maxGewichtText = maxGewichtText;

        maxGewichtText.setText("max. ", maxGewicht);
    }

    @Override
    public void onCollision(Collider collider) {
        if (collider instanceof Player) {
            if (player.gewicht > maxGewicht){
                remove();
                maxGewichtText.remove();
            }
        }
    }
}
