package tictactoe.models;

import tictactoe.interfaces.IGameListener;

import java.util.ArrayList;
//TODO The game saves each move to a log file.
//TODO Cerrar el juego: cuando el juego termine escribir en los archivos .data de cada jugador
public class Game {

    private static final int PlayerX = 1;
    private static final int PlayerY = 10;
    private static final int Empty = 0;
    private static int nextId = 1;
    private final int id;
    private final Turn turn;

    private int scorePlayerX;
    private int scorePlayerO;
    private int round;
    private final int size;
    private ArrayList<ArrayList<Integer>> rows;
    private transient final ArrayList<IGameListener> listeners;

    private final Player playerX;
    private final Player playerO;

    private Player winner;
    private int elapsedTurns;

    public Game(int size, String namePlayerX, String namePlayerY) {
        playerX = new Player(namePlayerX, PlayerType.X);
        playerO = new Player(namePlayerY, PlayerType.O);
        this.id = nextId++;
        this.scorePlayerX = 0;
        this.scorePlayerO = 0;
        this.round = 1;
        turn = new Turn();
        this.size = size;
        winner = null;
        elapsedTurns = 0;
        rows = createRows(this.size);
        listeners = new ArrayList<>();
    }
    public int getId()
    {
        return id;
    }
    public Player getWinner() { return winner; }

    public Player getPlayerX() { return playerX; }

    public Player getPlayerO() { return playerO; }

    public int getSize() { return size; }

    private static  ArrayList<ArrayList<Integer>> createRows(int sizeSide) {
        ArrayList<ArrayList<Integer>> toReturn = new ArrayList<>();
        for (int i = 0; i < sizeSide; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j < sizeSide; j++) {
                row.add(Empty);
            }
            toReturn.add(row);

        }
        return toReturn;
    }

    public boolean isThereWinner() {
        return validateRows() || validateColumns() || validateDiagonal();
    }

    private boolean validateRows() {
        for (int i = 0; i < size; i++) {
            int counter = 0;
            for (int j = 0; j < size; j++)
                counter += rows.get(i).get(j);

            if (counter == PlayerX * size || counter == PlayerY * size)
                return true;
        }
        return false;
    }

    private boolean validateColumns() {
        for (int i = 0; i < size; i++) {
            int counter = 0;
            for (int j = 0; j < size; j++)
                counter += rows.get(j).get(i);

            if (counter == PlayerX * size || counter == PlayerY * size) {
                return true;
            }

        }
        return false;
    }

    private boolean validateDiagonal() {
        return validateDiagonal(rows) || validateDiagonal(transposeMatrix());
    }

    private ArrayList<ArrayList<Integer>> transposeMatrix() {
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = size - 1; j >= 0; j--) {
                row.add( rows.get(i).get(j));
            }
            matrix.add(row);
        }
        return matrix;
    }

    private boolean validateDiagonal(ArrayList<ArrayList<Integer>> matrix) {
        int counter = 0;
        for (int i = 0; i < size; i++) {
            counter += matrix.get(i).get(i);
        }
        return counter == PlayerX * size || counter == PlayerY * size;
    }

    public boolean isATieGame()
    {
        return elapsedTurns == (size*size);
    }

    public Turn getTurn() {
        return turn;
    }

    public int getScorePlayerX() {
        return scorePlayerX;
    }

    public int getScorePlayerO() {
        return scorePlayerO;
    }

    private void setScorePlayerX(int scorePlayerX) {
        this.scorePlayerX = scorePlayerX;
    }

    private void setScorePlayerO(int scorePlayerO) {
        this.scorePlayerO = scorePlayerO;
    }

    public int getRound() {
        return round;
    }

    public void addListener(IGameListener listener) {
        listeners.add(listener);
    }

    public void removeListener(IGameListener listener) {
        listeners.remove(listener);
    }
    public int getElapsedTurns()
    {
        return elapsedTurns;
    }

    public void setElapsedTurns(int elapsedTurns)
    {
        this.elapsedTurns = elapsedTurns;
    }

    public void play(int x, int y, Player player)
    {
        if (canPlay(x, y))
            rows.get(x).set(y, player.getPlayerType() == PlayerType.X ? PlayerX : PlayerY);
        turn.changeTurn();
        incrementRound();
        for (IGameListener listener : listeners) {
            listener.buttonClicked(x, y, player);
            listener.setTurn(turn);
        }
    }

    private void incrementRound()
    {
        setRound(round + 1);
    }

    private void setRound(int round)
    {
        this.round = round;
        for (IGameListener listener: listeners)
        {
            listener.setRound(round);
        }
    }

    private void increaseScorePlayerX()
    {
        int score = scorePlayerX + 1;
        setScorePlayerX(score);
    }

    private void increaseScorePlayerO()
    {
        int score = scorePlayerO + 1;
        setScorePlayerO(score);
    }
    private boolean canPlay(int x, int y) {
        return rows.get(x).get(y).equals(Empty);
    }

    public void thereIsWinner(Player player)
    {
        setWinner(player);
        if (player.getPlayerType() == PlayerType.X)
        {
            increaseScorePlayerX();
        }
        else
        {
            increaseScorePlayerO();
        }
    }

    private void setWinner(Player winner)
    {
        this.winner = winner;

    }

    public void restart()
    {
        incrementRound();
        turn.restart();
        rows = createRows(size);
        elapsedTurns=0;
        winner = null;
        for (IGameListener listener: listeners)
        {
            listener.restart();
            listener.setTurn(turn);
        }
    }

}
