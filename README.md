# Yaeger tutorial: Creating Waterworld
In this tutorial you will create a simple game called Waterworld. We start of with an empty project that 
does not contain any code. Only the assets and the project settings are provided. Step-by-step you will 
be guided in the creation of simple game, and in doing so, become familiar with many of the features of 
Yaeger.

## Requirements
Yaeger requires Java JDK12 or above to work, and can be used with any IDE that supports Java.

# Creating your first Yaeger Game

We are going to create a game that consists of three **Scenes**. A Title Scene, a Level Scene and a Game Over Scene.
The Game itself will be about a fish called Hanny, that swims in the ocean and tries to pop air bubbles. Sadly most bubbles
contain a poisonous gas and popping to many of those kills Hanny.
But not only Hanny swims in the Ocean, but also an evil Shark. If he gets his hands on Hanny, Hanny gets eaten.

## Clone the starter project
We provide a repository, that contains both a starter project and the required assets. Either clone this repository
to your local machine, or download the zip file.

The project is a Maven project, which will be recognized by all modern IDE's. Knowledge of Maven is therefore not required.
But just to paint the full picture, you'll find a `pom.xml` file at the root of the project. This file contains the full
project setup and you will notice the dependency it has on `Yaeger`. 
 
### Importing the project in IntelliJ

### Importing the project in Eclipse

## Create the entry-point of Waterworld
Let's first create the entry-point, the Class that contains the `main`-method.

:computer: Create a Class called `Waterworld.java` in the package `com.github.hanyaeger.tutorial`.

:computer: Let `Waterworld` extend the Class `YaegerApplication`and implement the required methods. Leave them empty for now.

<img align="right" src="images/splash.png">

:computer: Add a `main`-method that calls the static method `launch()` from the class `YaegerApplication`. Pass the arguments from the `main`-method
to the `launch`-method:
```java
    public static void main(String[] args) {
        launch(args);
    }
```

:arrow_forward: You now have a minimal Yaeger game. Run the `main`-method to start the game. As you will
notice, there is a default width and height and you'll be greeted with the
Splash Screen. Since no Scenes have been added, Yaeger exits after showing this SplashScreen.

## Set the width, height and title of the game
The game now uses the default size (width/height), which might be a bit small. You can use the method `setupGame()` to 
set the size to a specific value. Furthermore you can set the title of the game, which will be shown as the title of the window.

:computer: Add the following body to the `setupGame()` method
```java    
    @Override
      protected void setupGame() {
          setGameTitle("Waterworld");
          setSize(new Size(800, 600));
      }
```

## Add a title/welcome screen
We're going to add the first Scene to the game. Yaeger supports two different types of Scenes. 
A `StaticScene` and a `DynamicScene`. A `StaticScene` will have no Game World update and should be used for Scenes
in which nothing should move or be animated. A `DynamicScene` does receive a Game World update and should be 
used for Game Levels, or Scenes that contain animated elements. Since nothing will have to be animated for the TitleScene, 
it can become `StaticScene`.

### Add the TileScene
:computer: Create a new Class called `TitleScene` that extends `StaticScene` in the package `com.github.hanyaeger.tutorial.scenes`.
Implement the required methods, but leave them empty.

### Set the backgound image and audio
The method `setupScene()` should be used for setting the background image and audio of a Scene. For this you
can use the methods `setBackgroundImage(String url)` and `setBackgroundAudio(String url)`. Both the image
and the audio are provided in the `resources/` folder. This folder should be the only place to store your assets.
The url is relative to this folder, so the file `background1.jpg` from the folder `backgrounds/` should be accessed
through the url `backgrounds/background1.jpg`. For the background audio, we will use `ocean.mp3`. 

:computer:  Add the 
following body to the `setupScene()`.

```java
    @Override
    public void setupScene() {
        setBackgroundAudio("audio/ocean.mp3");
        setBackgroundImage("backgrounds/background1.jpg");
    }
```

At this point you should have a look at the file `module-info.java`, which is called the *Module Descriptor*. This is a special file that defines 
(amongst other things) which directories should be opened up. The `resources` folder itself is open by default,
but any subdirectory should be added for the resources in those directories to be available. As you will notice
this has already been done: 
    ```java
        opens audio;
        opens backgrounds;
        opens sprites;
    ```
Do not forget to do this for your own game, or an Exception will be thrown when the game is trying to access 
a resource that is in a directory that has not been opened up.

### Add the scene to the Yaeger Game
Now that we have created the TitleScene, we should add it to the Game. For this, we will use the method `setupScenes()` from `Waterworld.java`.
This method takes two parameters. The first one identifies the Scene, which you can use to set the active Scene. The second parameter is an 
instance of the Scene.

:computer: So add the following body to the `setupScenes()` method:
           
```java
    @Override
    protected void setupScenes() {
        addScene(0, new TitleScene());
    }
```

:arrow_forward: Its time to run the game again. After the Splash Screen has been shown, the TitleScene should be loaded. 

### Add some text to the TitleScene
Lets add the title of the game to the TitleScene. All objects you can add to a Scene are called *Entities*. Of these there 
are various different types. There are *TextEntities* that should be used for dislaying a text, *SpriteEntities* for displaying
a Sprite and shape-based Entities, such as, for instance, a *RectangleEntity*. For all these types there are the Static and Dynamic version.

A title is typically the static version of a `TextEntity`. We will use the method `setupEntities()` to add Entities to the Scene.

:computer: Add the following body to the setupEntities() method:

```java
    @Override
    public void setupEntities() {
        var waterworldText = new TextEntity(new Location(getWidth() / 2, getHeight() / 2), "Waterworld");
        waterworldText.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        waterworldText.setFill(Color.DARKBLUE);
        waterworldText.setFont(HanFont.createDefaultCondensedFont(80));
        addEntity(waterworldText);
    }
```

<img align="right" src="images/title-no-buttons.png">

First we create the `waterworldText` by instantiating a `TextEntity`. The first parameter of the constructor is the `Location`. To
place it at the center of the Scene, we use the `getWidth()/2` and `getHeight()/2`. The second parameter is the text to be shown.
To actually place the center of the `TextEntity` at the center of the Scene, we use the method `setAnchorPoint()` and to set the 
color, we use `setFill()`. We set the font to the HAN font, through the method `setFont()` and lastly we add the `Entity` to the Scene, 
by calling the method `addEntity()`.

:arrow_forward: Run the game again. The TitleScene should now contain the title.

## Add the Game Scene
Now that we have a TitleScene, lets add a level. Since a level is typically a Scene that contains animated Entities, we are going to extend
a `DynamicScene`.

:computer: Add a scene called `LevelOne`, which extends a `DynamicScene`, to the `com.github.hanyaeger.tutorial.scenes` package.
Use the method `setupScene()` to set the background to the asset `background2.jpg` and the audio to `waterworld.mp3`.

At this moment the level has not yet been added to the game. You have only created a new class, that needs
to be instantiated and added to the `YaegerApplication`.

:computer: Use the `setupScenes()` from the `Waterworld`-class to add `LevelOne` to the game. Choose a wise `id`.

### Add a button to switch to the Game Scene
Although `LevelOne` has now been added to the Yaeger Game, there is no way to reach it yet. As said before, the
first added Scene is set as the active scene and that should be the `TitleScene`. To switch to `LevelOne`
you will need to call the method `setActiveScene(id)` on the `Waterworld` class.

To enable this, we are going to add a button to the `TitleScene`. Clicking the button will result in switching to
`LevelOne`. As said before, everything that should appear on a Scene is an Entity. For the button we are going to use
a `TextEntity` that will need to listen to mouse-clicks. Because of the latter, we can no longer use an inline 
`TextEntity` as we did for the title. We are going to create a new Class, called `StartButton` that extends `TextEntity`,
and add all the required behaviour to this Class.

### Create and add the button
:computer: Create a new Class `StartButton` that extends `TextEntity` and place it in the package 
`com.github.hanyaeger.tutorial.buttons`. Use the following constructor:

```java
    public StartButton(Location initialPosition) {
        super(initialPosition, "Play game");
        setFill(Color.PURPLE);
        setFont(HanFont.createDefaultCondensedFont(30));
    }
```

As you will notice we use the text *Play Game*, set the color to *Purple* and use the condensed version
of the HAN font.

:computer: Now use the `setupEntities()` from the `TitleScene` to add the `StartButton`. Place it at the center
of the screen, just below the title.

### Add behaviour to handle mouse clicks
In general, to expand the behaviour of an `Entity`, you should add the appropriate Interface to the `Entity`. 
To let an `Entity` listen to mouse button clicks, the `Entity` should implement the Interface `MouseButtonPressedListener`.

:computer: Let `StartButton` implement the interface `MouseButtonPressedListener`.

When the user clicks on the `StartButton` the handler (`onMouseButtonPressed()`) is called. this handler should call
`setActiveScene()` on the `Waterworld` class, but this method is not available from the `TitleScene`. So lets pass
the instance of `Waterworld` to the `StartButton` and then call `setActiveScene()` from the mouse pressed handler.

:computer: Change the constructor of `TitleScene` to 
```java
    private Waterworld waterworld;

    public TitleScene(Waterworld waterworld) {
        this.waterworld = waterworld;
    }
```
and supply an instance of `Waterworld` (notice the `this`) to the `TitleScene` in the `setupScenes` method:
```java
    @Override
    protected void setupScenes() {
        addScene(0, new TitleScene(this));
        addScene(1, new LevelOne());
    }
```

:computer: Now do the same for the constructor of the `StartButton`. This constructor already has the location
as a parameter, so after this change it will have two parameters.

As the last step wel would like to add the following to the mouse button handler:
```java
    @Override
    public void onMouseButtonPressed(MouseButton button, double x, double y) {
        waterworld.setActiveScene(1);
    }
```

but you will notice that the method `setActiveScene()` is not available. Alas! `setActiveScene()` has access
modifier `protected` and is therefore only available to instances of subclasses of `YaegerGame`. 

:computer: To make the method visible to other Objects, you should change the visibility by adding a 
public method to `Waterworld`:
```java
    @Override
    public void setActiveScene(int id) {
        super.setActiveScene(id);
    }
```

:arrow_forward: Run the game again. The TitleScene should now contain the title and a start button. Clicking this
start button should switch the game to level one.

### Add more behaviour to make the button into a real button
The Button should work now, but it gives little visual feedback on it's behaviour. We are going to add two more 
interfaces to the `StartButton`, being the `MouseEnterListener` and `MouseExitListener`.

:computer: Add the interface `MouseEnterListener` and `MouseExitListener` and implement their handlers in the following
way:

```java
    @Override
    public void onMouseEntered() {
        setFill(Color.VIOLET);
        setCursor(Cursor.HAND);
    }

    @Override
    public void onMouseExited() {
        setFill(Color.PURPLE);
        setCursor(Cursor.DEFAULT);
    }
```

Notice how we change both the color of the `Entity` as the mouse cursor.

## Add the player Entity to the Game
The player will control a fish by using the arrow keys. For this we will be using a `DynamicSpriteEntity`, which will
support using an image and, because it is a dynamic entity, can swim around the Scene.

:computer: Create a new Class called `Player` that extends `DynamicSpriteEntity` in package `com.github.hanyaeger.tutorial.entities`.
Give it the following constructor:
```java
    public Player(Location location) {
        super("sprites/player.png", location, new Size(20, 40), 2);
    }
```

<img align="right" src="images/player.png">

The image on the right will be used for the fish. As you can see, it contains two different images of the fish. 
These are called sprites and depending on the direction the fish is swimming, a different one will be shown. To get
more insight into the parameters of the constructor, check the [JavaDoc of DynamicSpriteEntity](https://han-yaeger.github.io/yaeger/hanyaeger.api/com/github/hanyaeger/api/engine/entities/entity/sprite/DynamicSpriteEntity.html).

:computer: Now use the `setupEntities()` from the `LevelOne` to add the `Player`. Place it at the top left corner
of the screen.

### Animate the Player
To animate the Player, we are going to let the Player listen to user input through the keyboard. As with the 
`MouseButtonPressedListener`, we are going to add an Interface. 

:computer: Let `Player` implement the interface `KeyListener` and implement the event handler in
the following way:

```java
  @Override
    public void onPressedKeysChange(Set<KeyCode> pressedKeys) {
        if (pressedKeys.contains(KeyCode.LEFT)) {
            setMotionTo(3, Direction.LEFT.getValue());
        } else if (pressedKeys.contains(KeyCode.RIGHT)) {
            setMotionTo(3, Direction.RIGHT.getValue());
        } else if (pressedKeys.contains(KeyCode.UP)) {
            setMotionTo(3, Direction.UP.getValue());
        } else if (pressedKeys.contains(KeyCode.DOWN)) {
            setMotionTo(3, Direction.DOWN.getValue());
        } else if (pressedKeys.isEmpty()) {
            setSpeedTo(0);
        }
    }
```

Notice how the event handler receives a `Set<KeyCode>`. This Set will contain all the buttons that are 
currently pressed. Depending on this, we set the motion of the Entity. To set the motion, we must set both
the direction and the speed. For convenience Yaeger supplied an Enumeration for setting the `Direction`.

### Change the frame index depending on the direction of the Player
We should still change the frame index depending on the direction of the Player. For this a `DynamicSpriteEntity`
provides the method ` setCurrentFrameIndex(int)`. 

:computer: Set the correct frame index. Make sure only the left and right buttons change the direction in which
the Player seems to be swimming.

## Add the air bubbles to the Game 



