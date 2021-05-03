## Add Coral to the Game Level

The Game Level needs a bit more decoration, so as the last step in this tutorial, we are going to add some coral. The
following four images are available:

1. coral1.png: <img width="10%" src="src/main/resources/sprites/coral1.png">
2. coral2.png: <img width="10%" src="src/main/resources/sprites/coral2.png">
3. coral3.png: <img width="10%" src="src/main/resources/sprites/coral3.png">
4. coral4.png: <img width="10%" src="src/main/resources/sprites/coral4.png">

We could just create new instances of `SpriteEntity` for each of the four Coral images and then use
`addEntity(YaegerEntity)` to add them to the Game Level. This would work, but it will be hard to add them in a nice
pattern to a Scene.

To facilitate this, Yaeger supplies a `Tile Map`, which is an Object with which you can create a two-dimensional
discrete map that represents the Scene, and then use the map to decide where to place the Entities. Yaeger will then
calculate the location, width and height of each Entity and place them on the Scene. You do still need to create new
instances of `SpriteEntity` for each of the four Coral images, but the rest will be handled by Yaeger.

### Create Coral Entities

Lets first create the four Coral Entities. They should extend `SpriteEntity` and their constructor should accept
the `Coordinate2D` as the first parameter and the `Size` as the second. Add them to the package
`com.github.hanyaeger.tutorial.entities.map`.

### Create a Tile Map for the Coral

:computer: Create a class `CoralTileMap` that extends `TileMap` to the
package `com.github.hanyaeger.tutorial.entities.map`.

As you can see, `CoralTileMap` will need to implement two methods. The method `setupEntities()` will be used to register
the Entities that are to be used with the Tile Map. The method `defineMap()` should return a two dimensional array
of `int` values. This array is a map of the Scene and tells Yaeger where to place which Entity. In the next step we will
implement both methods.

### Implement the `CoralTileMap`

The method `setupEntities()` should be used to register Entities on the Tile Map. From this method we should call
`addEntity(int, Class);`. As you can see, this method accepts an integer and a Class. So in this case, we should not add
an instance of an Entity, but its Class. Yaeger will then use this Class to create instances.

:computer: Implement the method `setupEntities()` as shown below.

```java
@Override
public void setupEntities(){
    addEntity(1,CoralOne.class);
    addEntity(2,CoralTwo.class);
    addEntity(3,CoralThree.class);
    addEntity(4,CoralFour.class);
}
```

The Coral should be placed in the lower half of the Scene. For this we can use the method `defineMap()`. From this
method will return a two dimensional array that represents the Scene. The int value 0 will mean no Entity is to be
placed. The other values are mapped on the Entities that are registered from the method setupEntities().

:computer:  Implement the method `defineMap()` as shown below.

```java
@Override
public int[][]defineMap(){
    int[][]map = {
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,3,0,0,0,0,0},
            {0,0,0,0,3,0,0,0,2,0,0,0,0,0,0,0,0,2,0},
            {3,0,0,0,0,4,0,0,0,0,0,1,0,0,2,0,3,0,1},
            {0,0,2,4,0,0,1,0,0,0,0,0,0,3,0,4,0,0,0},
            {1,0,0,0,0,0,0,0,4,0,0,0,0,0,0,1,0,3,0},
            {2,3,1,0,0,2,0,0,0,0,3,1,0,2,0,0,0,1,4},
        };
    return map;
}
```

### Add the Tile Map to the Game Scene

To be able to use the Tile Map, the Scene will need to implement the interface `TileMapContainer`. This will expose the
method `setupTileMaps()`, from which the Tile Maps can be added, by calling `addTileMap(TileMap);`. This last method
accepts a parameter of the type `TileMap`. So we can instantiate a new `CoralTileMap` and pass this as a parameter to
the method.

:computer: Add the `CoralTileMap` to the Game Scene.

:arrow_forward: Run the game. If you have done everything correctly, when going to Game Scene, you will likely be
greeted with the following exception:

```text
Caused by: java.lang.IllegalAccessException: class com.github.hanyaeger.api.engine.entities.tilemap.TileFactory (in module hanyaeger.api) cannot access class com.github.hanyaeger.tutorial.entities.map.CoralThree (in module waterworld) because module waterworld does not export com.github.hanyaeger.tutorial.entities.map to module hanyaeger.api
	at java.base/jdk.internal.reflect.Reflection.newIllegalAccessException(Reflection.java:376)
	at java.base/java.lang.reflect.AccessibleObject.checkAccess(AccessibleObject.java:647)
	at java.base/java.lang.reflect.Constructor.newInstanceWithCaller(Constructor.java:490)
	at java.base/java.lang.reflect.Constructor.newInstance(Constructor.java:481)
	at hanyaeger.api@2020.2021-beta2-SNAPSHOT/com.github.hanyaeger.api.engine.entities.tilemap.TileFactory.create(TileFactory.java:39)
```

Remember how we talked about the *Module Descriptor*? We are going to edit it, to make sure that Yaeger is allowed to
make instances of the Coral Entities. Since all those classes are in the
package `com.github.hanyaeger.tutorial.entities.map`, we have to export that package.

:computer: Add the following line to the file `module-info.java`:

```text
    exports com.github.hanyaeger.tutorial.entities.map;
```

:arrow_forward: Run the game. Note how the tiles in your Tilemap are scaled automatically.

### Ensure Hanny is hindered whenever she crosses a piece of Coral

Hanny can now still cross a piece of Coral. This can be easily resolved, using the `Collided` and `Collider`
interfaces. If the speed of Hanny is set to 0, whenever she collides with a piece of Coral, she will stop moving for
that Game World Update. Because this new speed is only applied after one Game World Update, she can still move, but very
slowly.

:computer: Implement everything required to ensure Hanny cannot cross a piece of coral. Also make sure a bubble can
still cross them.

<img width="70%"  src="images/game/game.png">
