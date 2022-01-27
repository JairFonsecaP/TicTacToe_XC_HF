package tictactoe.views.game;

import tictactoe.controllers.GameController;
import tictactoe.models.Game;
import tictactoe.models.Player;
import tictactoe.models.PlayerType;
import utility.PanelHelper;

import javax.swing.*;

public class GamePanel extends JPanel  {

    //views
    private final GameZonePanel gameZonePanel;
    private final InformationPanel informationPanel;
    public GamePanel(Game game)
    {
        gameZonePanel = new GameZonePanel(game.getSize(), game);
        informationPanel = new InformationPanel(game);
        setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        setBorder(PanelHelper.createLargeEmptyBorder());
        add(informationPanel);
        add(gameZonePanel);
    }

    public GameZonePanel getGameZonePanel() {
        return gameZonePanel;
    }

    public InformationPanel getInformationPanel() {
        return informationPanel;
    }

}
