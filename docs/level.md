# Creating a level

Now that we have a Title Scene, lets add a Game Level. Since a level is
typically a Scene that contains animated Entities, we are going to extend a
`DynamicScene`.

![Edit](images/edit.png) Add a scene called `GameLevel`, which extends
`DynamicScene`, to the `com.github.hanyaeger.tutorial.scenes`
package. Use the method `setupScene()` to set the background to the
asset `background2.jpg` and the audio to `waterworld.mp3`.

At this moment the level has not yet been added to the game. You have only
created a new class, that needs to be instantiated and added to
`YaegerGame`.

![Edit](images/edit.png) Use the `setupScenes()` from the `Waterworld`-class to
add `GameLevel` to the game. Choose a wise `id`.

## Add a button to switch to the game scene

Although `GameLevel` has now been added to the Yaeger Game, there is no way to
reach it yet. As said before, the first added Scene is set as the active scene
and that should be the `TitleScene`. To switch to `GameLevel`
you will need to call the method `setActiveScene(id)` on the `Waterworld` class.

To trigger this call, we are going to add a button to the `TitleScene`. Clicking
the button will result in switching to
`GameLevel`. As said before, everything that should appear on a Scene is an
Entity. For the button we are going to use a `TextEntity` that will need to
listen to mouse-clicks. Because of the latter, we can no longer use an inline
`TextEntity` as we did for the title. We are going to create a new Class,
called `StartButton` that extends `TextEntity`
, and add all the required behaviour to this Class.

## Create and add the button

![Edit](images/edit.png) Create a new Class `StartButton` that
extends `TextEntity` and place it in the package
`com.github.hanyaeger.tutorial.entities.buttons`. Use the following constructor:

```java
public StartButton(Coordinate2D initialLocation){
    super(initialLocation,"Play game");
    setFill(Color.PURPLE);
    setFont(Font.font("Roboto", FontWeight.BOLD, 30));
}
```

As you will notice we use the text *Play Game*, set the color to *Purple* and
use *Roboto* for the font.

![Edit](images/edit.png) Now use the `setupEntities()` from the `TitleScene` to
add the `StartButton`. Place it at the center of the screen, just below the
title.

## Add behaviour to handle mouse clicks

In general, to expand the behaviour of an `Entity`, you should add the
appropriate Interface to the `Entity`. To let an `Entity` listen to mouse button
clicks, the `Entity` should implement the Interface
`MouseButtonPressedListener`.

![Edit](images/edit.png) Let `StartButton` implement the interface
`MouseButtonPressedListener`.

When the user clicks on the `StartButton` the handler (`onMouseButtonPressed()`)
is called. this handler should call `setActiveScene()` on the `Waterworld`
class, but this method is not available from the `TitleScene`. So lets pass the
instance of `Waterworld` to the `StartButton` and then call
`setActiveScene()` from the mouse pressed handler.

![Edit](images/edit.png) Change the constructor of `TitleScene` to

```java
private Waterworld waterworld;

public TitleScene(Waterworld waterworld){
    this.waterworld = waterworld;
}
```

and supply an instance of `Waterworld` (notice the `this`) to the `TitleScene`
in the `setupScenes()` method:

```java
@Override
protected void setupScenes(){
    addScene(0, new TitleScene(this));
    addScene(1, new GameLevel());
}
```

![Edit](images/edit.png) Now do the same for the constructor of
the `StartButton`. This constructor already has the location as a parameter, so
after this change it will have two parameters.

As the last step wel would like to add the following to the mouse button
handler:

```java
@Override
public void onMouseButtonPressed(MouseButton button, Coordinate2D coordinate2D){
    waterworld.setActiveScene(1);
}
```

![Run](images/play.png) Run the game again. The `TitleScene` should now contain
the title, and a start button. Clicking this start button should switch the game
to `GameLevel`.

## Add more behaviour to make the button into a real button

The Button should work now, but it gives little visual feedback on its
behaviour. We are going to add two more interfaces to the `StartButton`, being
the `MouseEnterListener` and `MouseExitListener`.

![Edit](images/edit.png) Add the interface `MouseEnterListener`
and `MouseExitListener` and implement their handlers in the following way:

```java
@Override
public void onMouseEntered(){
    setFill(Color.VIOLET);
    setCursor(Cursor.HAND);
}

@Override
public void onMouseExited(){
    setFill(Color.PURPLE);
    setCursor(Cursor.DEFAULT);
}
```

Notice how we change both the color of the entity and the mouse cursor.

Now we have set up the game level, in the next chapter we'll add entities to
turn it into an actual game.
