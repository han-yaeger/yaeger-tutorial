# Adding more entities and an `EntitySpawner`

## Add another enemy, called Sharky

![Sharky](images/game/sharky.png)

Not only the swordfish, but also another foe abides in the depth of the ocean:
the evil Sharky. As can be seen, Sharky swims from left to right and is composed
of many sprites. If these sprites are cycled at the correct speed, Sharky
becomes animated. To automatically cycle through the sprites,
a `DynamicSpriteEntity` provides the `setAutoCycle(long)` method.

![Edit](images/edit.png) Add Sharky to `GameLevel`, animate him and let him
swim from left to right. After crossing the scene border, he should reappear 
at a random location left of the screen. After colliding with Sharky, Hanny 
loses a health point.

![Run](images/play.png) Start the game and test if Sharky behaves as expected.

## Add air and poison bubbles

We are now going to add the game objective: Hanny is going to pop air bubbles. 
They emerge from the depth of the ocean and float upwards at random speeds. 
Some are filled with air, and some are filled with a poisonous gas. When Hanny 
pops one of those, she loses a health point, but when she pops an air bubble, 
her bubbles popped score increases, and she earns eternal fame.

### Create air and poison bubbles

For air- and poison bubbles we could provide two images of bubbles and use
a `DynamicSpriteEntity`, but we'll use a different approach. Yaeger provides
various entities for standard shapes and for a bubble we could perfectly use a
`DynamicCircleEntity`. With it, we can draw a circle and give it the appropriate
size and colors. The big advantage over using an image is that we can give it
any color and size we like, and change it while running the game. Even more
important, it will save on memory usage, since no images need to be loaded into
memory.

Because both air- and poison bubbles share much of their behaviour, a superclass
called `Bubble` would be the preferable approach, but it is not required. Their
interaction with Hanny will be of later concern.

![Edit](images/edit.png) Create an `AirBubble` and a `PoisonBubble` that accept
both the `initialLocation` and the `speed` as a parameter of their constructor.
Do not yet add them to the scene. Use
the [API](https://han-yaeger.github.io/yaeger/hanyaeger/com/github/hanyaeger/api/entities/impl/DynamicCircleEntity.html)
to figure out how to set the size and color (fill and stroke) of both 
bubbles. Note that the `DynamicCircleEntity` inherits those methods from its 
parent `ShapeEntity`, so look for the inherited methods in the JavaDoc.
Ensure you can differentiate between both bubbles.

![Edit](images/edit.png) Use
the [API](https://han-yaeger.github.io/yaeger/hanyaeger/com/github/hanyaeger/api/entities/impl/DynamicCircleEntity.html)
to figure out how to change their opacity to make them transparent.

> Besides the interface `DynamicCircleEntity`, Yaeger also contains a `DynamicRectangleEntity`, a `DynamicEllipseEntity`
> and their static versions.

### Create a bubble spawner

Because spawning entities into a level is a common feature of games, Yaeger
supports this through the class `EntitySpawner`. An `EntitySpawner` should 
be extended and can then be added to a scene. The `EntitySpawner` will 
create new instances of `YaegerEntity`and add them to the scene.

We are going to create a `BubbleSpawner` that can create both instances
of `AirBubble` and `PoisonBubble`.

![Edit](images/edit.png) Create a class called `BubbleSpawner` that
extends `EntitySpawner` in the package
`com.github.hanyaeger.tutorial.spawners`. Notice that the constructor
of `EntitySpawner` accepts a parameter called `intervalInMs`. This parameter
will define the interval at which the method `spawnEntities()` is called. From
this method you can call `spawn(YaegerEntity)`.

### Let the bubble spawner spawn air bubbles

The `spawn(YaegerEntity)` method from the `BubbleSpawner` should be used for
spawning an entity. Furthermore, the `BubbleSpawner` should be able to place its
bubbles anywhere below the scene, so it should know the *width*
and *height* of the scene. To facilitate this, we are going to pass those two
values to the constructor.

We are going to start with spawning only instances of `AirBubble`.
The `PoisonBubble` will be added later on.

![Edit](images/edit.png) Add the following body to the `BubbleSpawner`.

```java
public class BubbleSpawner extends EntitySpawner {

    private final double sceneWidth;
    private final double sceneHeight;

    public BubbleSpawner(double sceneWidth, double sceneHeight) {
        super(100);
        this.sceneWidth = sceneWidth;
        this.sceneHeight = sceneHeight;
    }

    @Override
    protected void spawnEntities() {
        spawn(new AirBubble(randomLocation(), 2));
    }

    private Coordinate2D randomLocation() {
        double x = new Random().nextInt((int) sceneWidth);
        return new Coordinate2D(x, sceneHeight);
    }
}
```

### Add the bubble spawner to the game level

A `YaegerScene` does not support entity spawners by default, to enable it, the
scene needs to implement the interface `EntitySpawnerContainer`, which requires
implementing the method `setupEntitySpawners()`. From this method we can
call ` addEntitySpawner(new BubbleSpawner(getWidth(), getHeight()));`, which
adds the entity spawner to the scene and ensures the spawned entities appear on
the scene.

![Edit](images/edit.png) Add the `BubbleSpawner` to the `GameLevel`.

![Run](images/play.png) Run the game to see if everything works as expected.

### Make the bubble spawner also spawn instances of `PoisonBubble`

Let's change the `spawnEntities()` method to ensure that four out of ten spawned
bubbles will be a `PoisonBubble`. For this we can use the class `Random` from
the Java [API](https://docs.oracle.com/en/java/javase/16/docs/api/java.base/java/util/Random.html)

![Edit](images/edit.png) Change the `spawnEntities()` method to:

```java
@Override
protected void spawnEntities(){
    if(new Random().nextInt(10) < 4){
        spawn(new PoisonBubble(randomLocation(), 2));
    } else {
        spawn(new AirBubble(randomLocation(), 2));
    }
}
```

### Make the bubbles pop if they collide with Hanny

Whenever a bubble collides with Hanny, a popping sound should be played, and
they should be removed from the scene. We have already seen how to approach
this. Apparently the bubble needs to be notified when something collides with
it. Remember the interface `Collided`? But then, this is only applicable if the
entity that collides with it, becomes an `Collider`. So Hanny will not only be
a `Collided`, but also a `Collider`.

![Edit](images/edit.png) Add the interface `Collider` to Hanny

![Edit](images/edit.png) Add the interface `Collided` to the `PoisonBubble`
and `AirBubble` (since this is shared behaviour, and we are doing proper object
orientation, we will add it to their superclass). Implement the event handler in
the following way:

```java
@Override
public void onCollision(Collider collidingObject){
    var popSound = new SoundClip("audio/pop.mp3");
    popSound.play();

    remove();
}
```

Notice that we create a `SoundClip` and call its method `play()` to create the
pop-sound. The `remove()` method is available on all entities and ensures they
are removed from the scene.

### Remove the bubbles if they leave the scene

Bubbles that leave the scene should still be removed, otherwise they will float
on for ever and consume an increasing amount of memory, bringing even the
fastest computer to a grinding halt. We have already seen everything needed to
accomplish this.

![Edit](images/edit.png) Add the interface `SceneBorderCrossingWatcher` to
the `PoisonBubble` and `AirBubble`, and call the method `remove()` from the
event handler. Do make sure you call this method only when the top-border has
been crossed. 

![Run](images/play.png) Run the game and use the debugger to see if the bubbles
that leave the top of the screen are actually removed (and garbage collected).

### Remove health point when Hanny collides with a `PoisonBubble`

Whenever Hanny collides with a `PoisonBubble`, one health point should be
removed. Adding this shouldn't be too hard, since we have already seen
everything we need to accomplish this.

![Edit](images/edit.png) Make Hanny lose a health point whenever she collides
with a `PoisonBubble`.

### Add a Bubbles Popped counter and increase it whenever Hanny pops an `AirBubble`

Just like the health counter, shown at the top of the screen, we are going 
to add a *Bubbles Popped* counter. Again, something we have done before, so it 
shouldn't be too hard. The main question will be which entity is responsible 
for changing the *Bubbles Popped* counter. Is it Hanny, or are the air bubbles 
responsible for this?

In this case we are going to model it by letting Hanny know how many bubbles she
has popped. This way the implementation can mirror that of the `HealthText`. The
main difference will be that the event handler for collision will have to
differentiate between an `AirBubble` and other entities.

![Edit](images/edit.png) Implement a new `TextEntity` for the *Bubbles Popped*
text. This should be analogue to the way the health counter was implemented.
Think about which entities need to become a `Collider` and implement the event
handler for collisions on Hanny in the following way:

```java
@Override
public void onCollision(Collider collidingObject){
    if (collidingObject instanceof AirBubble){
        bubblesPoppedText.setText(++bubblesPopped);
    } else {
        healthText.setText(--health);

        if (health == 0){
            this.waterworld.setActiveScene(2);
        } else {
            setAnchorLocation(new Coordinate2D(
                new Random().nextInt((int)(getSceneWidth() - getWidth())),
                new Random().nextInt((int)(getSceneHeight() - getHeight()))));
        }
    }
}
```

## Apply some proper Object Orientation

When you followed the steps above you might have implemented the `Collider`
interface in the `AirBubble` class as well as in the `PoissonBubble` class.
Again shared behaviour, so it's time to clean that up.

![Edit](images/edit.png) Create a superclass for both `AirBubble`
and `PoisonBubble` and move all their shared behaviour to this superclass.
