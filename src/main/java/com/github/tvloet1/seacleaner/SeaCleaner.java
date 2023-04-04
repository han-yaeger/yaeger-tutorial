package com.github.tvloet1.seacleaner;

import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.YaegerGame;
import com.github.tvloet1.seacleaner.scenes.GameLevel;
import com.github.tvloet1.seacleaner.scenes.GameOverScene;
import com.github.tvloet1.seacleaner.scenes.TitleScene;

public class SeaCleaner extends YaegerGame {
    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void setupGame() {
        setGameTitle("Sea Cleaner");
        setSize(new Size(1200, 800));
    }

    @Override
    public void setupScenes() {
        addScene(0, new TitleScene(this));
        addScene(1, new GameLevel(this));
        addScene(2, new GameOverScene(this));
    }
}
