package com.github.hanyaeger.tutorial.tutorial.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.Newtonian;
import com.github.hanyaeger.api.entities.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;
import com.github.hanyaeger.api.userinput.KeyListener;
import com.github.hanyaeger.tutorial.Gameoverscene;
import com.github.hanyaeger.tutorial.Waterworld;
import com.github.hanyaeger.tutorial.tutorial.entities.map.Coral;
import com.github.hanyaeger.tutorial.tutorial.entities.swordfish.SwordFish;
import com.github.hanyaeger.tutorial.tutorial.entities.text.BubblesPoppedText;
import com.github.hanyaeger.tutorial.tutorial.entities.text.HealthText;
import javafx.scene.input.KeyCode;

import java.util.Random;
import java.util.Set;

public class Hanny extends DynamicSpriteEntity implements KeyListener, SceneBorderCrossingWatcher, Newtonian, Collided , Collider{

    private HealthText healthText;
    private Gameoverscene gameoverscene;
    private Waterworld waterworld;
    private int health = 10;
    private int bubblesPopped = 0;
    private final BubblesPoppedText bubblesPoppedText;
    public Hanny(Coordinate2D location, HealthText healthText,final BubblesPoppedText bubblesPoppedText, Waterworld waterworld) {
        super("sprites/hanny.png", location, new Size(20, 40), 1, 2);

        this.healthText = healthText;
        healthText.setHealthText(health);

        this.bubblesPoppedText = bubblesPoppedText;
        bubblesPoppedText.setText(bubblesPopped);

        this.waterworld = waterworld;
        setGravityConstant(0.005);
        setFrictionConstant(0.04);
    }

    @Override
    public void onPressedKeysChange(Set<KeyCode> pressedKeys) {
        if (pressedKeys.contains(KeyCode.LEFT)) {
            setMotion(14, 270d);
            setCurrentFrameIndex(0);
        } else if (pressedKeys.contains(KeyCode.RIGHT)) {
            setMotion(13, 90d);
            setCurrentFrameIndex(1);
        } else if (pressedKeys.contains(KeyCode.UP)) {
            setMotion(13, 180d);
        } else if (pressedKeys.contains(KeyCode.DOWN)) {
            setMotion(13, 0d);
        } else if (pressedKeys.isEmpty()) {
//            setSpeed(0);
        }
    }

    @Override
    public void notifyBoundaryCrossing(SceneBorder border) {
        setSpeed(0);

        switch (border) {
            case TOP:
                setAnchorLocationY(1);
                break;
            case BOTTOM:
                setAnchorLocationY(getSceneHeight() - getHeight() - 1);
                break;
            case LEFT:
                setAnchorLocationX(1);
                break;
            case RIGHT:
                setAnchorLocationX(getSceneWidth() - getWidth() - 1);
            default:
                break;
        }
    }


    @Override
    public void onCollision(Collider collidingObject) {
        System.out.println("mooi te pakken ");
//        setAnchorLocation(
//                new Coordinate2D(new Random().nextInt((int) (getSceneWidth()
//                        - getWidth())),
//                        new Random().nextInt((int) (getSceneHeight() - getHeight())))
//        );
//        if (collidingObject instanceof AirBubble){
//            health++;
//        }
//        else if (collidingObject instanceof PoisonBubble){
//            health--;
//        }
//        else if (collidingObject instanceof Sharky ){
//            health--;
//        }
////        health--;
//        healthText.setHealthText(health);
//
//        if (health <= 8){
//            waterworld.setActiveScene(2);
//        }

        if (collidingObject instanceof Coral) {
            setSpeed(0);
        }
        else if (collidingObject instanceof AirBubble) {
            bubblesPoppedText.setText(++bubblesPopped);
        } else {
             health--;
            healthText.setHealthText(health);

            if (health == 7) {
                this.waterworld.setActiveScene(2);
            } else {
                setAnchorLocation(new Coordinate2D(
                        new Random().nextInt((int) (getSceneWidth() - getWidth())),
                        new Random().nextInt((int) (getSceneHeight() - getHeight()))));
            }
        }

    }

}
