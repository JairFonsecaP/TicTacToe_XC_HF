package tictactoe.views.game;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GameZonePanel extends JPanel {
    private final ArrayList<ArrayList> rows;
    private final int size;

    public GameZonePanel(int sizeSide){
        size = sizeSide * sizeSide;
        rows = new ArrayList<>();
        for (int i = 0; i < sizeSide; i++)
        {
            rows.add(createFields(sizeSide));
        }

        createFields(sizeSide);
        setLayout(new GridLayout(sizeSide,sizeSide,3,3));


        for (int i = 0; i < rows.size(); i++) {
            ArrayList<SingleSquareGame> row = rows.get(i);
            for(int j = 0; j < row.size();j++)
            {
                SingleSquareGame field = row.get(j);
                add(field);
            }
        }

        int height = (sizeSide * 10) + (sizeSide* 3);
        Dimension dimension = new Dimension(height,height);
        setSize(dimension);
    }

    private ArrayList<SingleSquareGame> createFields(int sizeSide){
        ArrayList row = new ArrayList();
        for (int i = 0;i<sizeSide;i++){
            SingleSquareGame field = new SingleSquareGame();
            row.add(field);
        }
        return row;
    }
}
