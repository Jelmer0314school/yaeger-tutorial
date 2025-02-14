package com.github.hanyaeger.tutorial.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;
import com.github.hanyaeger.api.userinput.KeyListener;
import javafx.scene.input.KeyCode;

import java.util.Random;
import java.util.Set;

public class Hanny extends DynamicSpriteEntity implements KeyListener {

    public Hanny(Coordinate2D location){
        super("sprites/hanny.png", location, new Size(20,40), 1, 2);
    }


    @Override
    public void onPressedKeysChange(Set<KeyCode> pressedKeys){
        if(pressedKeys.contains(KeyCode.LEFT)){
            setMotion(3,270d);
            setCurrentFrameIndex(0);
        } else if(pressedKeys.contains(KeyCode.RIGHT)){
            setMotion(3,90d);
            setCurrentFrameIndex(1);
        } else if(pressedKeys.contains(KeyCode.UP)){
            setMotion(3,180d);
        } else if(pressedKeys.contains(KeyCode.DOWN)){
            setMotion(3,0d);
        } else if(pressedKeys.isEmpty()){
            setSpeed(0);
        }
    }

//    @Override
//    public void notifyBoundaryCrossing(SceneBorder sceneBorder) {
//
//    }


//    @Override
//    public void notifyBoundaryCrossing(SceneBorder border) {
//        setSpeed(0);
//
//        switch(border){
//            case TOP:
//                setAnchorLocationY(1);
//                break;
//            case BOTTOM:
//                setAnchorLocationY(getSceneHeight() - getHeight() - 1);
//                break;
//            case LEFT:
//                setAnchorLocationX(1);
//                break;
//            case RIGHT:
//                setAnchorLocationX(getSceneWidth() - getWidth() - 1);
//            default:
//                break;
//        }
//    }


}
