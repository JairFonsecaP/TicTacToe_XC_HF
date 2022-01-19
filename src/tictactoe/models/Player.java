package tictactoe.models;

public class Player {
    private static long nextPlayerNumber = 1000001;
    private final long playerNumber;
    String name;
    int numberOfGames;
    int score;


    public Player(String name,int numberOfGames, int score){
        setName(name);
        setNumberOfGames(numberOfGames);
        setScore(score);
        playerNumber = nextPlayerNumber++;
    }

    private void setScore(int score) {
        if (isScoreValid(score))
            this.score = score;
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
        if (isNumberOfGamesValid(numberOfGames))
            this.numberOfGames = numberOfGames;
        throw new IllegalArgumentException("Number of Games invalid");
    }
    private boolean isNumberOfGamesValid(int numberOfGames) {
        return numberOfGames >= 0;
    }
}
