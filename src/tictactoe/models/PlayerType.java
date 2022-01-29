package tictactoe.models;

import java.awt.*;

public enum PlayerType {
    X, O;


    public char getPlayerTypeChar()
    {
        if (isPlayerX())
            return 'X';
        else
            return 'O';
    }

    public Color getPlayerTypeColor()
    {
        if (isPlayerX())
            return Color.BLUE;

        else
            return Color.RED;
    }

    private boolean isPlayerX() {
        return this == PlayerType.X;
    }


}
