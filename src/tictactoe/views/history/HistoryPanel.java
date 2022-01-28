package tictactoe.views.history;

import tictactoe.controllers.HistoryController;
import tictactoe.controllers.WelcomeController;
import tictactoe.models.Welcome;
import tictactoe.views.welcome.WelcomePanel;
import tictactoe.views.welcome.WelcomeWindow;
import utility.PanelHelper;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class HistoryPanel extends JPanel {


    public HistoryInformationPanel historyInformation;
    public HistoryController controller;
    public HistoryPanel()throws IOException, ClassNotFoundException{

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(PanelHelper.createLargeEmptyBorder());


        historyInformation = new HistoryInformationPanel();

        add(createTitlePanel());
        add(PanelHelper.createSmallSeparator());
        add(historyInformation);

    }

    private JPanel createTitlePanel() {
        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(new BoxLayout(titlePanel, BoxLayout.X_AXIS));
        titlePanel.setAlignmentX(Panel.CENTER_ALIGNMENT);
        JLabel titleLabel = new JLabel("History");
        titleLabel.setFont(new Font(
                titlePanel.getFont().getFontName(),
                Font.BOLD,
                titlePanel.getFont().getSize()+4));
        titlePanel.add(titleLabel);
        return titlePanel;
    }
    public HistoryInformationPanel getHistoryInformation() {
        return historyInformation;
    }

}
