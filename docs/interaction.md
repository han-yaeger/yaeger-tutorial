# Add interaction between Hanny and the Swordfish

A standard feature of a game engine is collision detection. It is an algorithmically complex calculation that determines
if any two Entities occupy the same part of the screen. If so, they have collided.

Yaeger differentiates between entities that need to be notified about a collision (a Collided), and those that do not
need to be notified (a Collider). Thinks of this as a train and a fly. If they collide, the train doesn't even notice
it; the fly does
(and dies).

With this approach, it is possible to minimize the number of entities that need to be checked for collisions every Game
Loop. And it also enables a good Object Oriented approach to place the responsibility of handling a collision at the
right entity.

## Add collision detection for Hanny and the Swordfish

The Swordfish is a dangerous foe and each time Hanny collides with him, she will lose a life point. At the start of the
game Hanny has ten of those and when she reaches zero, she dies, and it is Game Over.

There are several algorithms for collision detection but Yaeger only supports the simplest implementation, which is
based on the Bounding Box of an Entity. This method is called Axis Aligned Bounding Box (AABB) collision detection and
is implemented through the interfaces `Collided` and `Collider`.

:computer: Add the correct interface to Hanny and the SwordFish. You do not yet need to implement the event handler, but
for testing purposes you should add a `System.out.println("Collision!");`

:arrow_forward: Start the game and test if the collision has been detected. To get more insight into these collisions,
it is possible to run Yaeger with the commandline argument `--showBB`, which makes all bounding boxes visible.

> You might have noticed that because Yaeger uses the Bounding Box to check for collisions, the collision detection  
> is not as accurate as you might like it to be. This can be solved by using the notion of a hit box, a shape that
> defines the area that is being checked during a collision detection cycle. Hit Boxes can be used in Yaeger, through
> the use of a `CompositeEntity`: an Entity that consists of other Entities.
> An implementation of this can be found in the [Yaeger Showcase](https://github.com/han-yaeger/yaeger-showcase) on
> the *Composing* Scene. On that Scene we again find Hanny and the Swordfish, but both are constructed through the use
> of a `CompositeEntity`. The Swordfish consists of a `SpriteEntity` and a `RectangleEntity` that is invisible and
> placed on top of the Swordsfish's sword. Since that rectangle implements the interface `Collider`, the collision between
> Hanny and the sword is the collision that is detected.
>

## Let Hanny respawn after a collision with the SwordFish

Because Hanny is the one who needs to know if she has collided with the SwordFish, she will be the one who implements
`Collided`. We are going to use the event handler to let Hanny respawn at a different location, using
her `setAnchorLocation()`
method.

:computer: Use the following event handler to let Hanny respawn at a random location:

```java
@Override
public void onCollision(Collider collidingObject){
    setAnchorLocation(new Coordinate2D(new Random().nextInt((int)(getSceneWidth()-getWidth())),
        new Random().nextInt((int)(getSceneHeight()-getHeight()))));
}
```

Notice that we have access to the *SceneWidth* and *SceneHeight* and that we subtract, respectively, the *width*
and *height* of Hanny to ensure that Hanny respawns within the Scene.

## Add health points and subtract one on a collision

The next step should be fairly simple, since we will use only features we have already seen.

:computer: Create a new static `TextEntity` called `HealthText` with the constructor and method shown below. Add it to
the package `com.github.hanyaeger.tutorial.entities.text`.

```java
public HealthText(Coordinate2D initialLocation){
    super(initialLocation);

    setFont(HanFont.createDefaultCondensedFont(40));
    setFill(Color.DARKBLUE);
}

public void setHealthText(int health){
    setText("Health: "+health);
}
```

:computer: Add this entity to the Game Level, by using the `setupEntities()` method, but also pass the instance to the
constructor of Hanny. This way, Hanny has access to the `HealthText` Entity and can call the method `setHealthText(int)`
whenever her health changes.

:computer: Give Hanny a private instance field called health of type `int` and initialize it to 10. Also bind the
constructor parameter `HealthText` to an instance field. Af this change, the constructor and instance fields of Hanny
should look like:

```java
private final HealthText healthText;
private int health=10;

public Hanny(Coordinate2D location,HealthText healthText){
    super("sprites/hanny.png",location,new Size(20,40),2);

    this.healthText=healthText;
    healthText.setHealthText(health);
}
```

The last step is to integrate the health into the event handler of Hanny.

:computer: Change the event handler to ensure that the health is decreased, and the healthText changed:

```java
@Override
public void onCollision(Collider collidingObject){
    setAnchorLocation(new Coordinate2D(
            new Random().nextInt((int)(getSceneWidth()-getWidth())),
            new Random().nextInt((int)(getSceneHeight()-getHeight())))
        );

    health--;
    healthText.setHealthText(health);
}
```
