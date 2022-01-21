package tictactoe.views;

import tictactoe.models.Player;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GamePanel extends JPanel {
    private final ArrayList<SingleSquareGame> fields;
    private final int size;
    private final Player player1;
    private final Player player2;

    public GamePanel(int sizeSide, Player player1, Player player2 ){
        this.player1 = player1;
        this.player2 = player2;
        size = sizeSide * sizeSide;
        fields = new ArrayList<>();
        createFields();
        setLayout(new GridLayout(sizeSide,sizeSide,5,5));
        for (SingleSquareGame field: fields) {
            add(field);
        }
    }
    private void createFields(){
        for (int i = 0;i<size;i++){
            SingleSquareGame field = new SingleSquareGame();
            fields.add(field);
        }
    }
}
