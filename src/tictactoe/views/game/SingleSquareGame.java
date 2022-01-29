package tictactoe.views.game;

import javax.swing.*;
import java.awt.*;

public class SingleSquareGame extends JButton {
    public SingleSquareGame(){
        Dimension dimension = new Dimension(50,50);
        setMinimumSize(dimension);
        setMaximumSize(dimension);
        setPreferredSize(dimension);
    }
}
