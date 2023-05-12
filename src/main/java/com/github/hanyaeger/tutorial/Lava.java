package com.github.hanyaeger.tutorial;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;
import com.github.hanyaeger.tutorial.collectible.Key;

public class Lava extends SpriteEntity implements Collided {
    private Key key;
    private Player player;
    private LavaExit lavaExit;

    public Lava(Key key, Player player, LavaExit lavaExit, Coordinate2D location, Size size) {
        super("sprites/lava.jpg", location, size);
        this.key = key;
        this.player = player;
        this.lavaExit = lavaExit;
    }

    @Override
    public void onCollision(Collider collider) {
        if (collider instanceof Player) {
            lavaExit.setActiveScene(2);
            key.setOpgepakt(false);
            player.setGewicht(70);
            player.setHoogSpringen(false);
        }
    }
}
