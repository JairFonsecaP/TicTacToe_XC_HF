package tictactoe.interfaces;

import tictactoe.models.Player;

public interface IGameListener {
    void buttonClicked(int x,int y, Player player);
    void restart();
    void setRound(int round);
}
