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
    private final GamePanel view;
    private final Game model;

    public GameController(int size, String namePlayerX, String namePlayerY) {

        model = new Game(size, namePlayerX, namePlayerY);

        view = new GamePanel(model);
        GameWindow window = new GameWindow("Tic Tac Toe Game", view);
        window.setVisible(true);
        model.addListener(view.getGameZonePanel());
        view.getGameZonePanel().addButtonsListener((ActionEvent e) -> onButtonClicked(e));

    }


    private void onButtonClicked(ActionEvent e) {

        SingleSquareGame button = (SingleSquareGame) e.getSource();
        ArrayList<ArrayList<SingleSquareGame>> matrix = view.getGameZonePanel().getMatrix();
        for (int i = 0; i < matrix.size(); i++) {
            for (int j = 0; j < matrix.get(i).size(); j++) {
                if (matrix.get(i).get(j).equals(button))
                    model.setAPosition(i, j);
            }
        }
        if (model.isThereWinner()){

        }
    }
}
