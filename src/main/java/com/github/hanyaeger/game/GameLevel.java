package com.github.hanyaeger.game;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.EntitySpawnerContainer;
import com.github.hanyaeger.api.scenes.DynamicScene;
//import com.github.hanyaeger.tutorial.entities.Hanny;
import com.github.hanyaeger.api.scenes.TileMapContainer;
import com.github.hanyaeger.game.game.entities.Hanny;
import com.github.hanyaeger.game.game.entities.Sharky;
import com.github.hanyaeger.game.game.entities.map.CoralTileMap;
import com.github.hanyaeger.game.game.entities.text.BubblesPoppedText;
import com.github.hanyaeger.game.game.entities.text.HealthText;
import com.github.hanyaeger.game.game.entities.swordfish.SwordFish;
import com.github.hanyaeger.game.game.spawners.BubbleSpawner;
import javafx.scene.Cursor;

public class GameLevel extends DynamicScene implements EntitySpawnerContainer, TileMapContainer {
    @Override
    public void setupScene() {
        setBackgroundAudio("audio/waterworld.mp3");
        setBackgroundImage("backgrounds/background2.jpg");
    }

    public GameLevel(TimmyTheJetpack waterworld) {
        this.waterworld = waterworld;
    }

    TimmyTheJetpack waterworld;

    @Override
    public void setupEntities() {
        var swordFish = new SwordFish(new Coordinate2D(getWidth(), getHeight() / 2));
        var healthboard = new HealthText(new Coordinate2D(0,0));

        var bubblesPoppedText = new BubblesPoppedText(new Coordinate2D(0, 30));
        addEntity(bubblesPoppedText);

        var hanny =  new Hanny(new Coordinate2D(getWidth() / 2, getHeight() / 2), healthboard,bubblesPoppedText, waterworld);
        var sharky = new Sharky(new Coordinate2D(0,100));
        addEntity(swordFish);
        addEntity(hanny);
        addEntity(healthboard);
        addEntity(sharky);
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

    @Override
    public void setupEntitySpawners() {
        addEntitySpawner(new BubbleSpawner(getWidth(), getHeight()));
    }
    @Override
    public void setupTileMaps() {
        addTileMap(new CoralTileMap());
    }
}
