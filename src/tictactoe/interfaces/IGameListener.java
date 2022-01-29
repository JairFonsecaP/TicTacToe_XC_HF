package tictactoe.interfaces;

import tictactoe.models.PlayerType;

import javax.swing.*;

public interface IGameListener {
    void buttonClicked(int x,int y);
    void thereIsWinner(PlayerType player);
}
