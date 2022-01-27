package tictactoe.views.game;

import tictactoe.PlayerType;
import tictactoe.interfaces.IGameListener;
import tictactoe.models.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GameZonePanel extends JPanel  implements IGameListener {
    private final static char xPlayerCharacter = 'X';
    private final static char oPlayerCharacter = 'O';
    private final ArrayList<ArrayList<SingleSquareGame>> rows;
    private final int size;
    private Game game;

    public GameZonePanel(int sizeSide, Game game){
        this.game = game;
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

    public void addButtonsListener(ActionListener listener){

        for (ArrayList row: rows) {
            for (Object list: row ) {
                SingleSquareGame button = (SingleSquareGame) list;
                button.addActionListener(listener);
            }
        }
    }


    @Override
    public void buttonClicked(Object buttonClicked) {
        SingleSquareGame button = (SingleSquareGame) buttonClicked;

//TODO: implementar el cambio en el modelo
//TODO: cambiar este metodo al controlador

        if (game.getTurn().getTurnPlayer() == PlayerType.X )
            button.setText(String.valueOf(xPlayerCharacter));
        else
            button.setText(String.valueOf(oPlayerCharacter));

        button.setEnabled(false);
        game.getTurn().changeTurn();
    }
}
