package com.github.hanyaeger.tutorial.tutorial;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.scenes.DynamicScene;
//import com.github.hanyaeger.tutorial.entities.Hanny;
//import com.github.hanyaeger.tutorial.entities.Swordfish;
import com.github.hanyaeger.tutorial.tutorial.entities.Hanny;
import com.github.hanyaeger.tutorial.tutorial.entities.Swordfish;
import com.github.hanyaeger.tutorial.tutorial.entities.text.HealthText;
import javafx.scene.Cursor;

public class GameLevel extends DynamicScene {
    @Override
    public void setupScene() {
        setBackgroundAudio("audio/waterworld.mp3");
        setBackgroundImage("backgrounds/background2.jpg");
    }

    @Override
    public void setupEntities() {

        var swordFish = new Swordfish(new Coordinate2D(getWidth() / 2, getHeight() / 2));
        var healthboard = new HealthText(new Coordinate2D(getWidth() / 2, 20));
        var hanny =  new Hanny(new Coordinate2D(getWidth() / 2, getHeight() / 2), healthboard);
        addEntity(swordFish);
        addEntity(hanny);
        addEntity(healthboard);


    }

    @Override
    public void setCursor(Cursor cursor) {
        super.setCursor(cursor);
    }

    @Override
    public double getWidth() {
        return super.getWidth();
    }

    @Override
    public double getHeight() {
        return super.getHeight();
    }

    @Override
    public void beforeInitialize() {
        super.beforeInitialize();
    }
}
