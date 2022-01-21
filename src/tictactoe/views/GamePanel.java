package tictactoe.views;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GamePanel extends JPanel {
    private final ArrayList<SingleSquareGame> fields;
    private final int size;

    public GamePanel(int sizeSide){
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
