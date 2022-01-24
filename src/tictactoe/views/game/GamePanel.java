package tictactoe.views.game;

import tictactoe.models.Game;
import tictactoe.models.Player;
import utility.PanelHelper;

import javax.swing.*;

public class GamePanel extends JPanel {
    //Model
    private final Game game;

    private final GameZonePanel gameZonePanel;
    private final InformationPanel informationPanel;
    public GamePanel(int sizeSide, String player1, String player2 )
    {
        this.game = new Game(player1, player2);
        gameZonePanel = new GameZonePanel(sizeSide);
        informationPanel = new InformationPanel(game);
        setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        setBorder(PanelHelper.createLargeEmptyBorder());
        add(informationPanel);
        add(gameZonePanel);
    }

}
