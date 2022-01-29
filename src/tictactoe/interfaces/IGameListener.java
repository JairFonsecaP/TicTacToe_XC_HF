package tictactoe.interfaces;

import tictactoe.models.Player;
import tictactoe.models.Turn;

public interface IGameListener {
    void buttonClicked(int x,int y, Player player);
    void restart();
    void setRound(int round);
    void setTurn(Turn turn);
}
