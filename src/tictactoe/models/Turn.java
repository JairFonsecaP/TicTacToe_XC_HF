package tictactoe.models;

import java.util.Random;

public class Turn
{
    private boolean turn;
    private enum players{ X, O};
    private static final Random random;

    static
    {
        random = new Random();
    }

    public Turn()
    {
        turn = selectRandomTurn();
    }

    private static boolean selectRandomTurn()
    {
        return random.nextBoolean();
    }

    public players getTurnPlayer()
    {
        return turn ? players.X : players.O;
    }

    public void changeTurn()
    {
        setTurn(!turn);
    }

    private void setTurn(boolean turn)
    {
        this.turn = turn;
    }
}
