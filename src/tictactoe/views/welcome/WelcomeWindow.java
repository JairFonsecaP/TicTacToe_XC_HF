package tictactoe.views.welcome;

import javax.swing.*;
import java.awt.*;

public class WelcomeWindow extends JFrame {
    public WelcomeWindow(String title, Container contentPane){
        super(title);

        setContentPane(contentPane);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        pack();
    }
}
