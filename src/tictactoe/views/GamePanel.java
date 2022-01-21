package tictactoe.views;

import utility.PanelHelper;

import javax.swing.*;

public class GamePanel extends JPanel
{
    private final GameZonePanel gameZonePanel;
    private final InformationPanel informationPanel;
    public GamePanel(int sizeSide)
    {
        gameZonePanel = new GameZonePanel(sizeSide);
        informationPanel = new InformationPanel();
        setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        setBorder(PanelHelper.createLargeEmptyBorder());
        add(informationPanel);
        add(gameZonePanel);
    }

}
