package tictactoe.views.game;

import tictactoe.models.Player;
import utility.PanelHelper;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class InformationPanel extends JPanel
{
    private final JLabel roundLabel;
    private final Player player1;
    private final Player player2;
    public InformationPanel(Player player1, Player player2)
    {
        this.player1 = player1;
        this.player2 = player2;
        roundLabel = new JLabel("ROUND X");
        add(createUpperPanel());
    }

    private JPanel createUpperPanel(){
        JPanel panel = new JPanel();
        JPanel upperPanel = new JPanel();
        JPanel lowerPanel = new JPanel();
        LocalDate now = LocalDate.now();
        DateTimeFormatter formatDate = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        JLabel dateLabel = new JLabel(now.format(formatDate));
        upperPanel.add(roundLabel);
        add(PanelHelper.createLargeSeparator());
        setLayout(new GridLayout(2,1));
        upperPanel.add(dateLabel);

        JLabel playerXLabel = new JLabel(player1.getName());
        JLabel playerYLabel = new JLabel(player2.getName());

        lowerPanel.add(playerXLabel);
        lowerPanel.add(playerYLabel);

        panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
        panel.add(upperPanel);
        panel.add(lowerPanel);
        return panel;
    }
}
