# Adding many entities at once

The `GameLevel` needs a bit more decoration, so as the last step in this
tutorial, we are going to add some coral. The following four images are
available:

1. coral1.png: ![Coral1](images/game/coral1.png)
2. coral2.png:![Coral1](images/game/coral2.png)
3. coral3.png: ![Coral1](images/game/coral3.png)
4. coral4.png: ![Coral1](images/game/coral4.png)

We could just create new instances of `SpriteEntity` for each of the four coral
images and then use `addEntity(YaegerEntity)` to add them to the `GameLevel`. 
This would work, but it will be hard to add them in a nice pattern to the scene.

To facilitate this, Yaeger supplies a `TileMap`, with which you can create a 
two-dimensional map of entities that are placed on the scene. Yaeger will
calculate the location, width and height of each entity and instantiate them.
You will still have to create a class, with the correct constructor, but the 
rest will be handled by Yaeger.

## Create coral entities

Since we need four different coral entities, the approach would be to create 
four classes, which all extend `SpriteEntity`, but since their behaviour is 
identical, there is a better way. 

We'll dive into that later on, for now:

![Edit](images/edit.png) Create a class `Coral` that extends `SpriteEntity` to
the package `com.github.hanyaeger.tutorial.entities.map`.

It's constructor should accept a `Coordinate2D` as the first parameter, a 
`Size` as the second, and a `String` as the third. Pass these values to the
constructor of `SpriteEntity`, notice how that constructor accepts the same 
parameters, but in a different order.

Add the class to the package `com.github.hanyaeger.tutorial.entities.map`.

## Create a tile map for the coral

![Edit](images/edit.png) Create a class `CoralTileMap` that extends `TileMap` to
the package `com.github.hanyaeger.tutorial.entities.map`.

As you can see, `CoralTileMap` will need to implement two methods. The
method `setupEntities()` will be used to register the entities that are to be
used with the `TileMap`. The method `defineMap()` should return a 
two-dimensional array of `int` values. This array is a map of the scene and 
tells Yaeger where to place which entity. In the next step we will implement 
both methods.

## Implement the `CoralTileMap`

The method `setupEntities()` should be used to register entities on the 
`TileMap`. From this method we should call either `addEntity(int, Class)` or 
`addEntity(int, Class, Object)`. 

As you can see, these methods accept an `int` and a `Class`, and the second 
(overloaded) version also accepts an `Object`. The `int` is used to figure 
out which entity should be placed where. The `Class` shows us that this
method does not require an instance of the entity you want to add, but the 
actual `Class` itself. Yaeger will use this `Class` to create the instance.

The overloaded method, with three parameters can be used to pass a third 
parameter (of type `Object`), which is the used as the third parameter for 
the constructor of the provided `Class`. In our case, it's a `String` that 
contains the url of the coral image.

![Edit](images/edit.png) Implement the method `setupEntities()` as shown below.

```java
@Override
public void setupEntities() {
    addEntity(1, Coral.class, "sprites/coral1.png");
    addEntity(2, Coral.class, "sprites/coral2.png");
    addEntity(3, Coral.class, "sprites/coral3.png");
    addEntity(4, Coral.class, "sprites/coral4.png");
}
```

The Coral should be placed on the lower half of the scene. For this we can use
the method `defineMap()`, from which we will return a two-dimensional 
array of integers that represents the scene. The integer value 0 will mean no 
entity is to be placed. The other values are mapped on the entities registered 
from the method `setupEntities()`.

![Edit](images/edit.png) Implement the method `defineMap()` as shown below.

```java
@Override
public int[][] defineMap() {
    return new int[][]{
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 3, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0},
        {3, 0, 0, 0, 0, 4, 0, 0, 0, 0, 0, 1, 0, 0, 2, 0, 3, 0, 1},
        {0, 0, 2, 4, 0, 0, 1, 0, 0, 0, 0, 0, 0, 3, 0, 4, 0, 0, 0},
        {1, 0, 0, 0, 0, 0, 0, 0, 4, 0, 0, 0, 0, 0, 0, 1, 0, 3, 0},
        {2, 3, 1, 0, 0, 2, 0, 0, 0, 0, 3, 1, 0, 2, 0, 0, 0, 1, 4},
        };
}
```

## Add the tile map to the game scene

To be able to use the tile map, the scene will need to implement the
interface `TileMapContainer`. This will expose the method `setupTileMaps()`,
from which the `TileMap` can be added, by calling `addTileMap(TileMap);`. This
last method accepts a parameter of the type `TileMap`. So we can instantiate a
new `CoralTileMap` and pass this as a parameter to the method.

![Edit](images/edit.png) Add the `CoralTileMap` to the `GameLevel`.

![Run](images/play.png) Run the game. If you have done everything correctly,
when going to `GameLevel`, you will likely be greeted with the following
Exception:

```text
Caused by: java.lang.IllegalAccessException: class com.github.hanyaeger.core.factories.TileFactory (in module hanyaeger) cannot access class com.
github.hanyaeger.tutorial.entities.map.Coral (in module waterworld) because module waterworld does not export com.github.hanyaeger.tutorial.entities.map to module hanyaeger
	at java.base/jdk.internal.reflect.Reflection.newIllegalAccessException(Reflection.java:376)
	at java.base/java.lang.reflect.AccessibleObject.checkAccess(AccessibleObject.java:647)
	at java.base/java.lang.reflect.Constructor.newInstanceWithCaller(Constructor.java:490)
	at java.base/java.lang.reflect.Constructor.newInstance(Constructor.java:481)
	at hanyaeger.api@2020.2021-beta2-SNAPSHOT/com.github.hanyaeger.core.factories.tilemap.TileFactory.create(TileFactory.java:39)
```

Remember how we talked about the *Module Descriptor*? We are going to edit it,
to make sure that Yaeger is allowed to make instances of the coral entities.
Since all those classes are in the package 
`com.github.hanyaeger.tutorial.entities.map`, we have to export that package.

![Edit](images/edit.png) Add the following line to the file `module-info.java`:

```text
    exports com.github.hanyaeger.tutorial.entities.map;
```

![Run](images/play.png) Run the game. Note how the tiles in your tile map are
scaled automatically.

## Ensure Hanny is hindered whenever she crosses a piece of coral

Hanny can now still cross a piece of coral. This can be easily resolved, using
the `Collided` and `Collider`interfaces. If the speed of Hanny is set to 0, 
whenever she collides with a piece of Coral, she will stop moving for that Game 
World Update. Because this new speed is only applied after one GWU, she can 
still move, but very slowly.

![Edit](images/edit.png) Implement everything required to ensure Hanny cannot
cross a piece of coral. Also make sure a bubble can still cross them.

![Waterworld](images/game/game.png)
