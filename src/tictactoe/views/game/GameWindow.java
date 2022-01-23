package tictactoe.views.game;

import javax.swing.*;
import java.awt.*;

public class GameWindow extends JFrame {
    public GameWindow(String title, Container contentPane){
        super(title);

        setContentPane(contentPane);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pack();
    }
}
