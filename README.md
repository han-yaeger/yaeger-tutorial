# Yaeger tutorial: Creating Waterworld
In this tutorial you will create a simple game called Waterworld. 
We start of with an empty project that does not contain any code. 
Only the assets and the project settings are provided. Step-by-step you will be guided in the creation of simple 
game, and in doing so, become familiar with many of the features of Yaeger.

## Requirements
Yaeger requires Java JDK12 or above to work, and can be used with any IDE that supports Java.

# Creating your first Yaeger Game

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

## Add a title/welcome screen
We're going to add the first Scene to the game. Yaeger supports two different types of Scenes. 
A Static and a Dynamic Scene. A Static Scene will have no Game World update and should be used for Scenes
in which nothing should move or be animated. A Dynamic Scene does receive a Game World update and should be 
used for Game Levels, or Scenes that contain animated elements.

### Add a StaticScene
Create a new Class called `TitleScene` that extends `StaticScene` in the package `com.github.hanyaeger.tutorial.scenes`.
Implement the required methods, but leave them empty.

### Set the backgound image and audio
The method `setupScene()` should be used for setting the background image and audio of a Scene. For this you
can use the methods `setBackgroundImage(String url)` and `setBackgroundAudio(String url)`. Both the image
and the audio are provided in the `resources/` folder. This folder should be the only place to store your assets.
The url is relative to this folder, so the file `background1.jpg` from the folder `backgrounds/` should be accessed
through the url `backgrounds/background1.jpg`. For the background audio, we will use `ocean.mp3`. So add the 
following body to the `setupScene()`.

```java
    @Override
    public void setupScene() {
        setBackgroundAudio("audio/ocean.mp3");
        setBackgroundImage("backgrounds/background1.jpg");
    }
```

At this point you should have a look at the file `module-info.java`. This is a special file that defines 
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

## Add a first level
