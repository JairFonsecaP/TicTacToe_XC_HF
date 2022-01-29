package tictactoe.views.game;

import javax.swing.*;
import java.awt.*;

public class SingleSquareGame extends JButton {
    public SingleSquareGame(){
        Dimension dimension = new Dimension(80,70);
        setMinimumSize(dimension);
        setMaximumSize(dimension);
        setPreferredSize(dimension);
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }
}
