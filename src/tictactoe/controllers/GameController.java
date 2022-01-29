package tictactoe.controllers;

import tictactoe.logs.PlayerObjectLogger;
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

    private final GameWindow window;

    public GameController(int size, String namePlayerX, String namePlayerY) {

        model = new Game(size, namePlayerX, namePlayerY);

        view = new GamePanel(size, model.getRound(), model.getPlayerX().getName(),model.getPlayerO().getName());
        window = new GameWindow("Tic Tac Toe Game", view);
        window.setVisible(true);
        model.addListener(view);
        view.setTurn(model.getTurn());
        view.addButtonsListener((ActionEvent e) -> onButtonClicked(e));
        //TODO escribir log de jugada
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
        ProgramController programController;
        if (JOptionPane.showConfirmDialog(
                view.getParent(),
                createMessageOfAlert(),
                "Round Over",
                JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE) == JOptionPane.YES_OPTION){
            model.restart();
            view.scoreOPlayerChanged(model.getScorePlayerO());
            view.scoreXPlayerChanged(model.getScorePlayerX());
        }
        else
        {
            model.getPlayerX().setNumberOfGames(model.getPlayerX().getNumberOfGames()+1);
            model.getPlayerO().setNumberOfGames(model.getPlayerO().getNumberOfGames()+1);

            Player gameWinner = null;

            if (model.getScorePlayerO() > model.getScorePlayerX()){
                setWinnerAndLoserResults(model.getPlayerO(), model.getPlayerX());
                gameWinner = model.getPlayerO();
            }else if (model.getScorePlayerO() < model.getScorePlayerX()){
                setWinnerAndLoserResults(model.getPlayerX(), model.getPlayerO());
                gameWinner = model.getPlayerX();
            }
            else{
                model.getPlayerO().setNumberOfGamesDrew(model.getPlayerO().getNumberOfGamesDrew()+1);
                model.getPlayerX().setNumberOfGamesDrew(model.getPlayerX().getNumberOfGamesDrew()+1);

                PlayerObjectLogger.writePlayerLog(model.getPlayerX());
                PlayerObjectLogger.writePlayerLog(model.getPlayerO());
            }

            if (JOptionPane.showConfirmDialog(
                    view.getParent(),
                    createEndGameAlert(gameWinner,
                            model.getPlayerX(),
                            model.getPlayerO(),
                            model.getScorePlayerX(),
                            model.getScorePlayerO() ),
                    "Game Over",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE) == JOptionPane.YES_OPTION){

                window.dispose();
                programController = new ProgramController();

            }

        }
    }

    private void setWinnerAndLoserResults(Player winner, Player loser) {

        winner.setNumberOfGamesWon(winner.getNumberOfGamesWon() + 1);
        PlayerObjectLogger.writePlayerLog(winner);

        loser.setNumberOfGamesLost(loser.getNumberOfGamesLost()+1);
        PlayerObjectLogger.writePlayerLog(loser);
    }

    private JPanel createEndGameAlert(Player winner, Player playerX, Player playerO, int scorePlayerX, int scorePlayerO ) {
        return FinishPanel.createEndGamePopupPanel(
                winner == null ? null : winner.getName(),
                playerX.getName(),
                playerO.getName(),
                scorePlayerX,
                scorePlayerO);
    }

    private JPanel createMessageOfAlert()
    {
        return FinishPanel.createEndRoundPopupPanel(
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
