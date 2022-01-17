package tictactoe.views;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {
    public Window(String title, Container contentPane){
        super(title);

        setContentPane(contentPane);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pack();
    }
}
