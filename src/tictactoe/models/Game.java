package tictactoe.models;

import tictactoe.interfaces.IGameListener;

import java.util.ArrayList;

public class Game
{
    private static int nextId = 1;
    private final int id;
    private final Turn turn;


    private final Player player1;
    private final Player player2;
    private int scorePlayer1;
    private int scorePlayer2;
    private int round;

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
        listeners = new ArrayList<>();
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
