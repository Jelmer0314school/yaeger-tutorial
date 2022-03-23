package com.github.hanyaeger.game;

import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.YaegerGame;

public class TimmyTheJetpack extends YaegerGame {

    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void setupGame() {
        setGameTitle("Waterworld");
        setSize(new Size(1600, 800));
    }

    @Override
    public void setupScenes() {
        addScene(0, new TitleScene(this));
        addScene(1, new GameLevel(this));
        addScene(2, new Gameoverscene(this));
    }
}
