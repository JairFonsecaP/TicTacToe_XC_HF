package tictactoe.views.history;

import tictactoe.models.History;
import tictactoe.models.Player;
import utility.PanelHelper;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class HistoryInformationPanel extends JPanel {
public static ArrayList<Player> players;
    public HistoryInformationPanel() throws IOException, ClassNotFoundException{
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(PanelHelper.createLargeEmptyBorder());
        setBackground(Color.WHITE);
        Player.getHistory();
        this.players = Player.getPlayers();
        if (players.size() == 0)
            add(createNoInformationPanel());
        else
            add(createHistoryPanel());
    }

    private JPanel createNoInformationPanel() {
        JPanel noHistoryPanel = new JPanel();
        noHistoryPanel.setLayout(new BoxLayout(noHistoryPanel, BoxLayout.X_AXIS));
        noHistoryPanel.add(new JLabel("There is no players created."));
        return noHistoryPanel;
    }

    private JPanel createHistoryPanel() {
        JPanel historyPanel = new JPanel();
        historyPanel.setLayout(new BoxLayout(historyPanel, BoxLayout.X_AXIS));
        add(createHistoryTiles());
        for (Player player: players ) {
            add(createHistoryPlayerPanel(player));
        }
        return historyPanel;
    }

    private JPanel createHistoryTiles() {
        JPanel titles = new JPanel();
        titles.setBackground(Color.WHITE);
        titles.setAlignmentX(Panel.CENTER_ALIGNMENT);
        titles.setLayout(new GridLayout(1,6));
        titles.add(new JLabel("Player Number"));
        titles.add(new JLabel("Name "));
        titles.add(new JLabel("Games Played "));
        titles.add(new JLabel("Games Won "));
        titles.add(new JLabel("Games Lost " ));
        titles.add(new JLabel("Games Drew " ));

        return  titles;
    }

    private JPanel createHistoryPlayerPanel(Player player) {
        JPanel playerInformation = new JPanel();
        playerInformation.setBackground(Color.WHITE);
        playerInformation.setAlignmentX(Panel.CENTER_ALIGNMENT);
        playerInformation.setLayout(new GridLayout(1,6));
        playerInformation.add(new JLabel(String.valueOf(player.getPlayerNumber())));
        playerInformation.add(new JLabel(player.getName()));
        playerInformation.add(new JLabel(String.valueOf(player.getNumberOfGames())));
        playerInformation.add(new JLabel(String.valueOf(player.getNumberOfGamesWon())));
        playerInformation.add(new JLabel(String.valueOf(player.getNumberOfGamesLost()) ));
        playerInformation.add(new JLabel(String.valueOf(player.getNumberOfGamesDrew())));
        Font font = playerInformation.getFont();
        playerInformation.setFont(new Font(font.getFontName(), Font.PLAIN, font.getSize()));
        return  playerInformation;
    }
}
