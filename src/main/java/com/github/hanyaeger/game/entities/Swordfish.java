package com.github.hanyaeger.game.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;

import java.util.Random;

public class Swordfish extends DynamicSpriteEntity implements SceneBorderCrossingWatcher {

//    protected Swordfish(String resource, Coordinate2D initialLocation) {
//        super(resource, initialLocation);
//    }

    public Swordfish(Coordinate2D location){
        super("sprites/swordfish.png", location);
        setMotion(4, 270d);

    }

    @Override
    public void notifyBoundaryCrossing(SceneBorder border){
        setAnchorLocationX(getSceneWidth());
        setAnchorLocationY(new Random().nextInt((int) getSceneHeight()- 81));
    }

}
