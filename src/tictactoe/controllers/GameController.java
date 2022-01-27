package tictactoe.controllers;

import tictactoe.models.Game;
import tictactoe.models.Player;
import tictactoe.models.PlayerType;
import tictactoe.views.game.GamePanel;
import tictactoe.views.game.GameWindow;
import tictactoe.views.game.SingleSquareGame;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class GameController {
//
    private final static char xPlayerCharacter = 'X';
    private final static char oPlayerCharacter = 'O';
    private final GamePanel view;
    private final Game model;

    public GameController(int size,String namePlayerX,String namePlayerY)
    {


        model = new Game(size, namePlayerX, namePlayerY);

        view = new GamePanel(model);
        GameWindow window = new GameWindow("Tic Tac Toe Game", view);
        window.setVisible(true);
//todo error
        //model.addListener(view.getGameZonePanel());
        view.getGameZonePanel().addButtonsListener((ActionEvent e) -> onButtonClicked(e));

    }


    private void onButtonClicked(ActionEvent e)
    {
        SingleSquareGame button = (SingleSquareGame) e.getSource();

//TODO: implementar el cambio en el modelo

        ArrayList<ArrayList<SingleSquareGame>> matrix = view.getGameZonePanel().getMatrix();
        for (int i = 0; i < matrix.size(); i++) {
            for (int j = 0; j < matrix.get(i).size(); j++) {
                if (matrix.get(i).get(j).equals(button))
                    model.setAPosition(i,j);
            }
        }

        if (model.getTurn().getTurnPlayer() == PlayerType.X )
            button.setText(String.valueOf(xPlayerCharacter));
        else
            button.setText(String.valueOf(oPlayerCharacter));

        button.setEnabled(false);
    }
}
