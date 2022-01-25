package tictactoe.models;

import tictactoe.interfaces.IGameListener;

import java.util.ArrayList;

public class Game
{

    private static final int PlayerX = 1;
    private static final int PlayerY = 10;
    private static int nextId = 1;
    private final int id;
    private final Turn turn;


    private final Player player1;
    private final Player player2;
    private final int scorePlayer1;
    private final int scorePlayer2;
    private final int round;
    private final int sideSize;
    private final ArrayList<ArrayList> rows;

    private transient ArrayList<IGameListener> listeners;


    public Game(String player1, String player2)
    {
        this.id = nextId++;
        this.player1 = createPlayer(player1);
        this.player2 = createPlayer(player2);
        this.scorePlayer1 = 0;
        this.scorePlayer2 = 0;
        this.round = 1;
        turn = new Turn();
        //TODO: toca cambialo para que este objeto tenga la informacion y los demas la consumande aca.
        sideSize = 3;

        rows = createRows(sideSize);
        listeners = new ArrayList<>();
    }

    private static final ArrayList createRows(int sizeSide)
    {
        ArrayList<ArrayList> toReturn = new ArrayList<>();
        for (int i = 0; i < sizeSide; i++)
        {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j < sizeSide; j++)
            {
                row.add(0);
            }
            toReturn.add(row);

        }
        return toReturn;
    }

    public boolean isThereWinner()
    {
        return validateRows() || validateColumns() || validateDiagonal();
    }
    
    private boolean validateRows()
    {
        for (int i = 0; i < sideSize;i++)
        {
            int counter = 0;
            for (int j = 0; j < sideSize; j++)
                counter += (Integer)rows.get(i).get(j);

            if (counter == PlayerX * sideSize || counter == PlayerY * sideSize)
                return true;
        }
        return false;
    }

    private boolean validateColumns()
    {
        for (int i = 0; i < sideSize; i++)
        {
            int counter = 0;
            for (int j = 0; j < sideSize; j++)
                counter += (Integer) rows.get(j).get(i);

            if (counter == PlayerX * sideSize || counter == PlayerY * sideSize)
                return true;
        }
        return false;
    }

    private boolean validateDiagonal()
    {
        return validateDiagonal(rows) || validateDiagonal(transposeMatrix());
    }

    private ArrayList<ArrayList> transposeMatrix()
    {
        ArrayList<ArrayList> matrix = new ArrayList<>();
        for (int i = 0; i < sideSize; i++)
        {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = sideSize - 1; j >= 0; j++)
            {
                row.add((Integer) rows.get(i).get(j));
            }
            matrix.add(row);
        }
        return matrix;
    }

    private boolean validateDiagonal(ArrayList<ArrayList> matrix)
    {
        int counter = 0;
        for (int i = 0; i < sideSize; i++)
        {
            counter += (Integer) matrix.get(i).get(i);
        }
        return counter == PlayerX * sideSize || counter == PlayerY * sideSize;
    }

    private Player createPlayer(String playerName) {
        Player player = Player.getExistingPlayer(playerName);
        if (player == null)
            return new Player(playerName,0,0,0,0);
        else
            return player;
    }
    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }
    public Turn getTurn() {
        return turn;
    }

    public int getScorePlayer1() {
        return scorePlayer1;
    }

    public int getScorePlayer2() {
        return scorePlayer2;
    }

    public int getRound() {
        return round;
    }
    public void addListener(IGameListener listener){
        listeners.add(listener);
    }
    public void removeListener(IGameListener listener){
        listeners.remove(listener);
    }

}
