# Improve collision detection through the use of composition

Now we have implemented both the swordfish and Hanny, and collision detection
between them, we might notice that the collision detection is to rough. The
bounding box of the swordfish is much too large, compared to its area, and we
would much rather only register a collision if Hanny collides with the actual
sword of the swordfish.

We are going to create a new version of the swordfish that does just that. For
this, we will be using a composition of several entities, that will be part of
a `DynamicCompositeEntity`.

![Edit](images/edit.png) Create a package
`com.github.hanyaeger.tutorial.entities.swordfish`. In this package create a
class `SwordFish` that extends `DynamicCompositeEntity`. Implement the methods,
but leave them empty for now. Delete the previous implementation of the
swordfish and replace all usages with the new one.

## Another `setupEntities()`?

Because a composite entity enables the possibility to create a 
composition of entities, it supplies its own `setupEntities()` method, which 
should be used to add the entities that are to be a part of the composition. 

A composite entity defines its own area, where the top-left corner has 
coordinate (0,0). The size of a composite entity is derived from it content.

### Create the entities that should be part of the composite entity

The composition will consist of two entities, a `SpriteEntity` that provides 
the image of the swordfish, and a `RectangleEntity` that will implement 
`Collided`, be invisible and placed exactly on the sword of the swordfish.

![Edit](images/edit.png) Create the class `SwordFishSprite` that extends 
`SpriteEntity` and place it in the package 
`com.github.hanyaeger.tutorial.entities.swordfish` in the following way:

```java
public class SwordfishSprite extends SpriteEntity {

    public SwordfishSprite(final Coordinate2D location) {
        super("sprites/swordfish.png", location);
    }
}
```

![Edit](images/edit.png) Create a class `HitBox` that extends `RectangleEntity`
and implements `Collider` in the following way:

```java
public class HitBox extends RectangleEntity implements Collider {

    public HitBox(final Coordinate2D initialPosition) {
        super(initialPosition);
        setWidth(60);
        setHeight(2);
        setFill(Color.TRANSPARENT);
    }
}
```

### Add the entities to the composition

Now use the `setupEntities()` method from `SwordFish` to add both entities. 
First the `SwordFishSprite` and then the `HitBox`. Since the 
`SwordFishSprite` should be placed in the upper-left corner of the 
`SwordFish`, it should be placed at coordinate (0,0). 

![Edit](images/edit.png) Add the `SwordFishSprite` to the `SwordFish` at 
coordinate (0,0).

![Edit](images/edit.png) Add the `HitBox` to the swordfish in such a way 
that it overlaps the sword of the swordfish. It could help to set the fill 
of the hitbox to a specific color, so you can see what you're doing.

## Make the swordfish swim

Notice that both the image and the hitbox are static entities. They are part 
of the composite entity, which is a dynamic entity. This 
`DynamicCompositeEntity` is the one that will move around the scene, and its 
content will move with it. 

![Edit](images/edit.png) Make the `SwordFish` swim through the scene as it 
did before. Don't forget to make him reappear if he leaves the screen.

![Run](images/play.png) Start the game and test if the swordfish behaves as 
expected. 


