package tictactoe.views.game;

import tictactoe.interfaces.IGameListener;
import tictactoe.models.Game;
import tictactoe.models.PlayerType;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GameZonePanel extends JPanel implements IGameListener {

    private final ArrayList<ArrayList<SingleSquareGame>> matrix;
    private final int size;
    private Game game;

    public GameZonePanel(int size, Game game){
        this.game = game;
        this.size = size;
        matrix = new ArrayList<>();
        for (int i = 0; i < size; i++)
        {
            matrix.add(createFields());
        }

        createFields();
        setLayout(new GridLayout(size,size,3,3));


        for (int i = 0; i < matrix.size(); i++) {
            ArrayList<SingleSquareGame> row = matrix.get(i);
            for(int j = 0; j < row.size();j++)
            {
                SingleSquareGame field = row.get(j);
                add(field);
            }
        }

        int height = (size * 10) + (size* 3);
        Dimension dimension = new Dimension(height,height);
        setSize(dimension);
    }

    private ArrayList<SingleSquareGame> createFields(){
        ArrayList row = new ArrayList();
        for (int i = 0;i<size;i++){
            SingleSquareGame field = new SingleSquareGame();
            row.add(field);
        }
        return row;
    }

    public void addButtonsListener(ActionListener listener){

        for (ArrayList row: matrix) {
            for (Object list: row ) {
                SingleSquareGame button = (SingleSquareGame) list;
                button.addActionListener(listener);
            }
        }
    }

    public ArrayList<ArrayList<SingleSquareGame>> getMatrix()
    {
        return matrix;
    }

    @Override
    public void buttonClicked(int x,int y) {
        SingleSquareGame button = matrix.get(x).get(y);
        PlayerType playerType = game.getTurn().getTurnPlayer();
        button.setText(String.valueOf(playerType.getPlayerTypeChar()));
        button.setEnabled(false);
    }
}
