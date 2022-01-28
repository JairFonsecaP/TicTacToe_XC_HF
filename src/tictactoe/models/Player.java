package tictactoe.models;

import tictactoe.logs.PlayerObjectLogger;

import java.io.Serializable;

public class Player implements Serializable {
    private static transient long nextPlayerNumber = 1000001;
    private static transient PlayerObjectLogger playerObjectLogger;
    private final long playerNumber;
    private String name;
    private int numberOfGames;
    private int numberOfGamesWon;
    private int numberOfGamesLost;
    private int numberOfGamesDrew;

    public Player(String name,int numberOfGames, int numberOfGamesWon, int numberOfGamesLost, int numberOfGamesDrew){
        playerNumber = nextPlayerNumber++;
        setName(name);
        setNumberOfGames(numberOfGames);
        setNumberOfGamesWon(numberOfGamesWon);
        setNumberOfGamesLost(numberOfGamesLost);
        setNumberOfGamesDrew(numberOfGamesDrew);
        playerObjectLogger = new PlayerObjectLogger(this);
        playerObjectLogger.writePlayerLog();
    }



    private boolean isScoreValid(int score) {
        return score >= 0;
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

    public static Player getExistingPlayer(String name){
        PlayerObjectLogger playerObjectLogger = new PlayerObjectLogger();
        if(playerObjectLogger.playerExist(name))
            return playerObjectLogger.getPlayerObject(name);
        return null;
    }
}
