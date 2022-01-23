package tictactoe.views.game;

import tictactoe.models.Player;
import utility.PanelHelper;

import javax.swing.*;

public class GamePanel extends JPanel {
    private final Player player1;
    private final Player player2;

    private final GameZonePanel gameZonePanel;
    private final InformationPanel informationPanel;
    public GamePanel(int sizeSide, Player player1, Player player2 )
    {
        this.player1 = player1;
        this.player2 = player2;
        gameZonePanel = new GameZonePanel(sizeSide);
        informationPanel = new InformationPanel();
        setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        setBorder(PanelHelper.createLargeEmptyBorder());
        add(informationPanel);
        add(gameZonePanel);
    }

}
