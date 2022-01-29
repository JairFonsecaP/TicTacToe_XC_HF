package tictactoe.controllers;

import tictactoe.models.Game;
import tictactoe.models.Player;

import tictactoe.views.game.FinishPanel;
import tictactoe.views.game.GamePanel;
import tictactoe.views.game.GameWindow;
import tictactoe.views.game.SingleSquareGame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class GameController {
    //
    private final GamePanel view;
    private final Game model;

    public GameController(int size, String namePlayerX, String namePlayerY) {

        model = new Game(size, namePlayerX, namePlayerY);

        view = new GamePanel(size, model.getRound(), model.getPlayerX().getName(),model.getPlayerO().getName());
        GameWindow window = new GameWindow("Tic Tac Toe Game", view);
        window.setVisible(true);
        model.addListener(view);
        view.addButtonsListener((ActionEvent e) -> onButtonClicked(e));
    }


    private void onButtonClicked(ActionEvent e) {

        SingleSquareGame button = (SingleSquareGame) e.getSource();
        Player player = model.getTurn().getTurnPlayer() == model.getPlayerX().getPlayerType() ? model.getPlayerX() : model.getPlayerO();
        play(button,player);
        if (model.getElapsedTurns() >= model.getSize())
            validateWinner(player);
    }

    private void validateWinner(Player player)
    {
        if (model.isThereWinner()) {
            model.thereIsWinner(player);
            alert();
        }
        else if (model.isATieGame())
        {
            alert();
        }
    }

    private void alert()
    {
        if (JOptionPane.showConfirmDialog(
                view.getParent(),
                createMessageOfAlert(),
                "Game Over",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
            model.restart();
        else
            System.exit(0);
    }

    private JPanel createMessageOfAlert()
    {
        return FinishPanel.createPopUpPanel(
                model.getWinner() == null ? null : model.getWinner().getName(),
                model.getPlayerX().getName(),
                model.getPlayerO().getName(),
                model.getScorePlayerX(),
                model.getScorePlayerO());
    }

    private void play(SingleSquareGame button,Player player)
    {
        ArrayList<ArrayList<SingleSquareGame>> matrix = view.getMatrix();
        for (int i = 0; i < matrix.size(); i++) {
            for (int j = 0; j < matrix.get(i).size(); j++) {
                if (matrix.get(i).get(j).equals(button))
                    model.play(i, j,player);
            }
        }
        model.setElapsedTurns(model.getElapsedTurns() + 1);
    }
}
