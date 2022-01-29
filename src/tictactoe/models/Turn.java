package tictactoe.models;
import java.util.Random;

public class Turn
{
    private boolean turn;
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

    public PlayerType getTurnPlayer()
    {
        return turn ? PlayerType.X : PlayerType.O;
    }

    public void changeTurn()
    {
        setTurn(!turn);
    }

    private void setTurn(boolean turn)
    {
        this.turn = turn;
    }

    public void restart()
    {
        setTurn(selectRandomTurn());
    }
}
