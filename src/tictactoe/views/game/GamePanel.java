package tictactoe.views.game;

import tictactoe.controllers.GameController;
import tictactoe.models.Game;
import tictactoe.models.Player;
import utility.PanelHelper;

import javax.swing.*;

public class GamePanel extends JPanel  {
    //Model
    private final Game game;
    //views
    private final GameZonePanel gameZonePanel;
    private final InformationPanel informationPanel;
    public GamePanel(int sizeSide, String player1, String player2 )
    {
        this.game = new Game(player1, player2);
        gameZonePanel = new GameZonePanel(sizeSide, game);
        informationPanel = new InformationPanel(game);
        setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        setBorder(PanelHelper.createLargeEmptyBorder());
        add(informationPanel);
        add(gameZonePanel);
        GameController controller = new GameController(this,game);
    }
    public Game getGame() {
        return game;
    }

    public GameZonePanel getGameZonePanel() {
        return gameZonePanel;
    }

    public InformationPanel getInformationPanel() {
        return informationPanel;
    }

}
