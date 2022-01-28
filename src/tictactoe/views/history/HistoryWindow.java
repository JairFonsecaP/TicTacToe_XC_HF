package tictactoe.views.history;

import javax.swing.*;
import java.awt.*;

public class HistoryWindow extends JFrame {

    public HistoryWindow(String title, Container contentPane){
        super(title);

        setContentPane(contentPane);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        pack();
    }
}
