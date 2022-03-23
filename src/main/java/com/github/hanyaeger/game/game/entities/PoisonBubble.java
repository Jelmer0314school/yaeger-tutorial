package com.github.hanyaeger.game.game.entities;

import com.github.hanyaeger.api.Coordinate2D;
import javafx.scene.paint.Color;

public class PoisonBubble extends Bubble{
    public PoisonBubble(Coordinate2D initialLocation, double speed) {
        super(initialLocation, speed);
        setFill(Color.GREEN);
        setStrokeColor(Color.PURPLE);
    }
}
