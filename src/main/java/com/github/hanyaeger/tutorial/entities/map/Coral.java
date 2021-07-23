package com.github.hanyaeger.tutorial.entities.map;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.sprite.SpriteEntity;

/**
 * A {@code Coral} is just a basic {@link SpriteEntity} that implements {@link Collider}. Since
 * it will be part of a {@link com.github.hanyaeger.api.scenes.TileMap}, it requires the location as
 * a {@link Coordinate2D} as its first parameter and  its size as a {@link Size} as its second.
 * <p>
 * The third parameter is the image-resource that should be used. When adding this Entity to the
 * {@link com.github.hanyaeger.api.scenes.TileMap}, the third parameter of
 * {@link com.github.hanyaeger.api.scenes.TileMap#addEntity(int, Class, Object)} will be used.
 */
public class Coral extends SpriteEntity implements Collider {

    public Coral(final Coordinate2D location, final Size size, final String resource) {
        super(resource, location, size);
    }
}
