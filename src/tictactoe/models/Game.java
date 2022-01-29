package tictactoe.models;

import tictactoe.interfaces.IGameListener;

import java.util.ArrayList;

public class Game {

    private static final int PlayerX = 1;
    private static final int PlayerY = 10;
    private static final int Empty = 0;
    private static int nextId = 1;
    private final int id;
    private final Turn turn;

    private final int scorePlayer1;
    private final int scorePlayer2;
    private int round;
    private final int size;
    private final ArrayList<ArrayList> rows;

    private transient ArrayList<IGameListener> listeners;


    private final Player playerX;
    private final Player playerY;
    private Player winner;

    public Game(int size, String namePlayerX, String namePlayerY) {
        playerX = new Player(namePlayerX, PlayerType.X);
        playerY = new Player(namePlayerY, PlayerType.O);
        this.id = nextId++;
        this.scorePlayer1 = 0;
        this.scorePlayer2 = 0;
        this.round = 1;
        turn = new Turn();
        this.size = size;

        rows = createRows(this.size);
        listeners = new ArrayList<>();
    }

    public Player getPlayerX() {
        return playerX;
    }

    public Player getPlayerY() {
        return playerY;
    }

    public int getSize() {
        return size;
    }

    private static final ArrayList createRows(int sizeSide) {
        ArrayList<ArrayList> toReturn = new ArrayList<>();
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
                counter += (Integer) rows.get(i).get(j);

            if (counter == PlayerX * size || counter == PlayerY * size)
                return true;
        }
        return false;
    }

    private boolean validateColumns() {
        for (int i = 0; i < size; i++) {
            int counter = 0;
            for (int j = 0; j < size; j++)
                counter += (Integer) rows.get(j).get(i);

            if (counter == PlayerX * size || counter == PlayerY * size) {
                return true;
            }

        }
        return false;
    }

    private boolean validateDiagonal() {
        return validateDiagonal(rows) || validateDiagonal(transposeMatrix());
    }

    private ArrayList<ArrayList> transposeMatrix() {
        ArrayList<ArrayList> matrix = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = size - 1; j >= 0; j--) {
                row.add((Integer) rows.get(i).get(j));
            }
            matrix.add(row);
        }
        return matrix;
    }

    private boolean validateDiagonal(ArrayList<ArrayList> matrix) {
        int counter = 0;
        for (int i = 0; i < size; i++) {
            counter += (Integer) matrix.get(i).get(i);
        }

        return counter == PlayerX * size || counter == PlayerY * size;
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

    public void addListener(IGameListener listener) {
        listeners.add(listener);
    }

    public void removeListener(IGameListener listener) {
        listeners.remove(listener);
    }

    public void setAPosition(int x, int y) {
        PlayerType playerType = turn.getTurnPlayer() ;
        if (canPlay(x, y))
            rows.get(x).set(y, playerType == PlayerType.X ? PlayerX : PlayerY);
        for (IGameListener listener : listeners) {
            listener.buttonClicked(x, y);
        }
        if (isThereWinner()) {
            System.out.println("Hay ganador");
            //TODO abrir la ventana de ganador
            //TODO llamar listener de playerChanged para actualizar archivo
            //TODO: esto es cuando se gana todo el juego, no la ronda:
            winner = (playerType == PlayerType.X ? getPlayerX() : getPlayerY());
            winner.setNumberOfGamesWon(winner.getNumberOfGamesWon()+1);
            playerY.setNumberOfGames(playerY.getNumberOfGames()+1);
            playerX.setNumberOfGames(playerY.getNumberOfGames()+1);
        }
        else
            turn.changeTurn();
    }

    private boolean canPlay(int x, int y) {
        return rows.get(x).get(y) == (Integer) Empty;
    }



}
