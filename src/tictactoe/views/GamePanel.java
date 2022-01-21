package tictactoe.views;

import tictactoe.models.Player;
import utility.PanelHelper;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GamePanel extends JPanel {
    private final ArrayList<SingleSquareGame> fields;
    private final int size;
    private final Player player1;
    private final Player player2;

public class GamePanel extends JPanel
{
    private final GameZonePanel gameZonePanel;
    private final InformationPanel informationPanel;
    public GamePanel(int sizeSide, Player player1, Player player2 )
    {
        gameZonePanel = new GameZonePanel(sizeSide);
        informationPanel = new InformationPanel();
        setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        setBorder(PanelHelper.createLargeEmptyBorder());
        add(informationPanel);
        add(gameZonePanel);
    }

}
