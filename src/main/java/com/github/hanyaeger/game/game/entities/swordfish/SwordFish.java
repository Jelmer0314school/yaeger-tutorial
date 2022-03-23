package com.github.hanyaeger.game.game.entities.swordfish;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Direction;
import com.github.hanyaeger.api.entities.DynamicCompositeEntity;
import com.github.hanyaeger.api.entities.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.scenes.SceneBorder;

import java.util.Random;

public class SwordFish extends DynamicCompositeEntity implements SceneBorderCrossingWatcher {

    public SwordFish(final Coordinate2D initialLocation) {
        super(initialLocation);
        setMotion(4, Direction.LEFT);
    }
    @Override
    protected void setupEntities() {
        var swordfish = new SwordfishSprite (new Coordinate2D(0,0));
        addEntity(swordfish);

        var hithox = new HitBox(new Coordinate2D(0,40));
        addEntity(hithox);
    }

    @Override
    public void notifyBoundaryCrossing(SceneBorder border){
        setAnchorLocationX(getSceneWidth());
        setAnchorLocationY(new Random().nextInt((int) getSceneHeight()- 81));
    }
}
