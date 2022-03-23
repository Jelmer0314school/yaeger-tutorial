package com.github.hanyaeger.game.game.entities.buttons;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import com.github.hanyaeger.api.userinput.MouseEnterListener;
import com.github.hanyaeger.api.userinput.MouseExitListener;
//import com.github.hanyaeger.tutorial.Waterworld;
import com.github.hanyaeger.game.TimmyTheJetpack;
import javafx.scene.Cursor;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class StartButton extends TextEntity implements MouseButtonPressedListener, MouseEnterListener, MouseExitListener {
    private TimmyTheJetpack waterworld;

    public StartButton(Coordinate2D initialLocation, TimmyTheJetpack waterworld){
        super(initialLocation,"Play game");
        this.waterworld = waterworld;
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
