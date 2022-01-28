package tictactoe.models;

public enum PlayerType {
    X, O;


    public char getPlayerTypeStatChar()
    {
        if (isPlayerX())
            return 'X';
        else
            return 'O';
    }

    private boolean isPlayerX() {
        return this == PlayerType.X;
    }


}
