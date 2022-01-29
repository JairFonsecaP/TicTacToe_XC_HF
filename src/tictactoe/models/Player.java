package tictactoe.models;

import tictactoe.logs.PlayerObjectLogger;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Player implements Serializable {
    private static transient long nextPlayerNumber = 1000001;
    private static transient PlayerObjectLogger playerObjectLogger;
    private static transient History history;
    private static transient ArrayList<Player> players;
    private static transient long finalId;
    private final PlayerType playerType;
    private final long playerNumber;
    private String name;
    private int numberOfGames;
    private int numberOfGamesWon;
    private int numberOfGamesLost;
    private int numberOfGamesDrew;

    public Player(String name,PlayerType playerType){

        finalId = nextPlayerNumber;
        getHistory();


        if (players.size() != 0) {
            Player existing  = getPlayerByName(name);
            if ( existing != null) {
                this.equals(existing);
                finalId = existing.getPlayerNumber();
            }else{
                nextPlayerNumber = getMaximumId() + 1;
                finalId = nextPlayerNumber;
            }
        }else{
            finalId = nextPlayerNumber++;
        }

        setNewPlayer(name);
        playerNumber = finalId;
        this.playerType = playerType;

        playerObjectLogger = new PlayerObjectLogger(this);
        playerObjectLogger.writePlayerLog();

    }

    public static void getHistory() {
        History history = new History();
        players = history.getPlayers();
    }

    private void setNewPlayer(String name) {

        setName(name);
        setNumberOfGames(0);
        setNumberOfGamesWon(0);
        setNumberOfGamesLost(0);
        setNumberOfGamesDrew(0);
    }

    private long getMaximumId() {
        ArrayList<Long> ids = new ArrayList<>();
        for (Player player: players) {
            ids.add(player.getPlayerNumber());
        }
        return  Collections.max(ids);
    }


    public void setName(String name) {
        if (name == null)
            throw new IllegalArgumentException("Name must not be null");
        if (!name.equals(""))
            this.name = name;
    }
    public void setNumberOfGames(int numberOfGames) {
        if (!isNumberOfGamesValid(numberOfGames))
            throw new IllegalArgumentException("Number of Games invalid");
        this.numberOfGames = numberOfGames;
    }
    public void setNumberOfGamesWon(int numberOfGamesWon) {
        if (!isNumberOfGamesValid(numberOfGamesWon))
            throw new IllegalArgumentException("Number of Games Won invalid");
        this.numberOfGamesWon = numberOfGamesWon;
    }
    public void setNumberOfGamesLost(int numberOfGamesLost) {
        if (!isNumberOfGamesValid(numberOfGamesLost))
            throw new IllegalArgumentException("Number of Games Lost invalid");
        this.numberOfGamesLost = numberOfGamesLost;
    }
    public void setNumberOfGamesDrew(int numberOfGamesDrew) {
        if (!isNumberOfGamesValid(numberOfGamesDrew))
            throw new IllegalArgumentException("Number of Games Drew invalid");
        this.numberOfGamesDrew = numberOfGamesDrew;
    }
    private boolean isNumberOfGamesValid(int numberOfGames) {
        return numberOfGames >= 0;
    }
    public String getName() {
        return name;
    }

    public int getNumberOfGames() {
        return numberOfGames;
    }

    public long getPlayerNumber() {
        return playerNumber;
    }
    public int getNumberOfGamesWon() {
        return numberOfGamesWon;
    }

    public int getNumberOfGamesLost() {
        return numberOfGamesLost;
    }

    public int getNumberOfGamesDrew() {
        return numberOfGamesDrew;
    }

    private static Player getPlayerByName(String name){
        for (Player player: players) {
            if (player.getName().equals(name))
                return player;
        }
        return null;
    }

    public static ArrayList<Player> getPlayers(){
        return players;
    }




}