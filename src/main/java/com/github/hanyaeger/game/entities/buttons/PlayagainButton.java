package com.github.hanyaeger.game.entities.buttons;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import com.github.hanyaeger.api.userinput.MouseEnterListener;
import com.github.hanyaeger.api.userinput.MouseExitListener;
import com.github.hanyaeger.game.TimmyTheJetpack;
import javafx.scene.Cursor;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class PlayagainButton extends TextEntity implements MouseButtonPressedListener, MouseEnterListener, MouseExitListener {
    private TimmyTheJetpack waterworld;

    public PlayagainButton(Coordinate2D initialLocation, TimmyTheJetpack timmyTheJetpack){
        super(initialLocation,"Game over ");
        this.waterworld = timmyTheJetpack;
        setFill(Color.GREEN);
        setFont(Font.font("Roboto", FontWeight.BOLD, 30));
    }

//    public StartButton(Coordinate2D initialLocation, String text) {
//        super(initialLocation, text);
//    }

    @Override
    public void onMouseEntered(){
        setFill(Color.VIOLET);
        setCursor(Cursor.HAND);
    }

    @Override
    public void onMouseExited(){
        setFill(Color.PURPLE);
        setCursor(Cursor.DEFAULT);
    }

    @Override
    public void onMouseButtonPressed(MouseButton button, Coordinate2D coordinate2D){
        System.out.println("ingedrukt");
        waterworld.setActiveScene(1);

    }
}
