package tictactoe.views;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GameZonePanel extends JPanel {
    private final ArrayList<SingleSquareGame> fields;
    private final int size;

    public GameZonePanel(int sizeSide){
        size = sizeSide * sizeSide;
        fields = new ArrayList<>();
        createFields();
        setLayout(new GridLayout(sizeSide,sizeSide,3,3));
        for (SingleSquareGame field: fields) {
            add(field);
        }
        int height = (sizeSide * 10) + (sizeSide* 3);
        Dimension dimension = new Dimension(height,height);
        setSize(dimension);
    }
    private void createFields(){
        for (int i = 0;i<size;i++){
            SingleSquareGame field = new SingleSquareGame();
            fields.add(field);
        }
    }
}
