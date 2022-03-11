# Add interaction through collision detection

A standard feature of a game engine is collision detection. It is an
algorithmically complex calculation that determines if any two entities occupy
the same part of the screen. If so, they have collided.

Yaeger differentiates between entities that need to be notified about a
collision (a `Collided`), and those that do not need to be notified (a 
`Collider`). Think of this as a train and a fly. If they collide, the train 
doesn't even notice it; the fly does (and dies).

With this approach, it is possible to minimize the number of entities that need
to be checked for collisions every GWU, and it also enables a good
Object-Oriented approach to place the responsibility of handling a collision on
the right entity.

## Add collision detection for Hanny and the swordfish

The swordfish is a dangerous foe and each time Hanny collides with him, she will
lose a life point. At the start of the game Hanny has ten of those and when she
reaches zero, she dies, and it is Game Over.

There are several algorithms for collision detection but Yaeger only supports
the simplest implementation, which is based on the Bounding Box of an entity.
This method is called Axis Aligned Bounding Box (AABB) collision detection and
is implemented through the interfaces `Collided` and `Collider`.

![Edit](images/edit.png) Add the correct interface to Hanny and the swordfish.
You do not yet need to implement the event handler, but for testing purposes you
should add a `System.out.println("Collision!");`

![Run](images/play.png) Start the game and test if the collision has been
detected. To get more insight into these collisions, it is possible to run
Yaeger with the commandline argument `--showBB`, which makes all bounding boxes
visible.

> You might have noticed that because Yaeger uses the Bounding Box to check for 
> collisions, the collision detection is not as accurate as you might like it to
> be. This can be solved by using the notion of a hit box, a shape that defines 
> the area that is being checked during a collision detection cycle.
>
> We will first finish implementing what happens after a collision. In the next
> chapter we will rework the swordfish to a version where only the sword causes
> a collision.

## Let Hanny respawn after a collision with the swordfish

Because Hanny is the one who needs to know if she has collided with the
swordfish, she will be the one who implements `Collided`. We are going to 
use the event handler to let Hanny respawn at a different location, using 
her `setAnchorLocation()` method.

![Edit](images/edit.png) Use the following event handler to let Hanny respawn at
a random location:

```java
@Override
public void onCollision(Collider collidingObject){
    setAnchorLocation(
        new Coordinate2D(new Random().nextInt((int)(getSceneWidth() 
        - getWidth())),
        new Random().nextInt((int)(getSceneHeight() - getHeight())))
    );
}
```

Notice that we have access to the *SceneWidth* and *SceneHeight* and that we
subtract, respectively, the *width* and *height* of Hanny to ensure that 
Hanny respawns within the scene.

## Add health points and subtract one on a collision

The next step should be fairly simple, since we will use only features we have
already seen.

![Edit](images/edit.png) Create a new static `TextEntity` called `HealthText`
with the constructor and method shown below. Add it to the
package `com.github.hanyaeger.tutorial.entities.text`.

```java
public HealthText(Coordinate2D initialLocation){
    super(initialLocation);
    setFont(Font.font("Roboto",FontWeight.NORMAL, 30));
    setFill(Color.DARKBLUE);
}

public void setHealthText(int health){
    setText("Health: " + health);
}
```

![Edit](images/edit.png) Add this entity to `GameLevel`, by using  the 
`setupEntities()` method, but also pass the instance to the constructor of
Hanny. This way, Hanny has access to the `HealthText` entity and can call the
method `setHealthText(int)` whenever her health changes.

![Edit](images/edit.png) Give Hanny a private instance field called health of
type `int` and initialize it to 10. Also bind the constructor
parameter `HealthText` to an instance field. After this change, the 
constructor and instance fields of Hanny should look like:

```java
private HealthText healthText;
private int health = 10;

public Hanny(Coordinate2D location, HealthText healthText){
    super("sprites/hanny.png", location, new Size(20,40), 2);

    this.healthText = healthText;
    healthText.setHealthText(health);

    setGravityConstant(0.005);
    setFrictionConstant(0.04);
}
```

The last step is to integrate the health into the event handler of Hanny.

![Edit](images/edit.png) Change the event handler to ensure that the health is
decreased, and the `healthText` changed:

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

## Add a Game Over-scene for when health reaches zero

When health reaches 0 Hanny dies, and the player should see a new scene
containing the text *Game Over*, with below it the clickable text *Play
again*. We have seen all of Yaeger's features that are required for this, so
it should be clear how to implement this.

![Edit](images/edit.png) Add a *Game Over* scene with a *Play Again* button.
Clicking the *Play Again* button should load the Game Level Scene.

![Edit](images/edit.png) Change the event handler in Hanny in such a way that
when the health reaches zero, the Game Over scene is loaded.

## Add a quit game button to the game over scene

![Edit](images/edit.png) Add a second button to the *Game Over* scene. Clicking
this button should quit Yaeger. The class `YaegerGame` provides a method to
quit the game, so use
the [JavaDoc](https://han-yaeger.github.io/yaeger/hanyaeger/com/github/hanyaeger/api/YaegerGame.html)
to figure out which one it is.

![Run](images/play.png) Run the game and test if the quit button works.

