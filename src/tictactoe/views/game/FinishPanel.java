package tictactoe.views.game;

import utility.PanelHelper;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class FinishPanel extends JPanel
{

    public static JPanel createEndRoundPopupPanel(String winner, String namePlayerX, String namePlayerO, int scorePlayerX, int scorePlayerO)
    {
        JPanel popUp = new JPanel();
        popUp.setLayout(new GridLayout(5,1));
        popUp.add(createMessage(winner));
        popUp.add(PanelHelper.createCustomSeparator(1));
        popUp.add(createScorePanel(namePlayerX, namePlayerO, scorePlayerX, scorePlayerO));
        popUp.add(PanelHelper.createCustomSeparator(2));
        popUp.add(createQuestionPanel());
        return popUp;
    }


    private static JPanel createQuestionPanel()
    {
        JPanel questionPanel = new JPanel();
        JLabel questionLabel = new JLabel("Would you like to play again?");
        questionLabel.setHorizontalAlignment(SwingConstants.CENTER);
        questionPanel.add(questionLabel);
        return questionPanel;
    }

    private static JPanel createMessage(String winner)
    {
        JPanel messagePanel = new JPanel();
        String title;
        Border border;
        if (winner != null)
        {
            title = winner + " won this round!";
            border = BorderFactory.createLineBorder(Color.GREEN,3);
        }
        else
        {
            title = "Drew Round. There's not winner.";
            border = BorderFactory.createLineBorder(Color.RED,3);
        }

        JLabel titleLabel = new JLabel(title);
        messagePanel.setBorder(border);
        messagePanel.add(titleLabel);

        return messagePanel;
    }

    private static JPanel createScorePanel(String namePlayerX, String namePlayerO, int scorePlayerX, int scorePlayerO)
    {
        JLabel scorePlayerXLabel = new JLabel(namePlayerX+ "'s score: " + scorePlayerX);
        scorePlayerXLabel.setForeground(Color.RED);
        scorePlayerXLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel scorePlayerOLabel = new JLabel(namePlayerO + "'s score: " + scorePlayerO);
        scorePlayerOLabel.setForeground(Color.BLUE);
        scorePlayerOLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JPanel scorePanel = new JPanel();
        scorePanel.setLayout(new GridLayout(2,1,0,5));
        scorePanel.add(scorePlayerXLabel);
        scorePanel.add(scorePlayerOLabel);
        return scorePanel;
    }

    public static JPanel createEndGamePopupPanel(String winner, String namePlayerX, String namePlayerO, int scorePlayerX, int scorePlayerO) {
        JPanel popUp = new JPanel();
        popUp.setLayout(new GridLayout(5,1));
        popUp.add(createGameOverMessage(winner));
        popUp.add(PanelHelper.createCustomSeparator(1));
        popUp.add(createScorePanel(namePlayerX, namePlayerO, scorePlayerX, scorePlayerO));
        return popUp;
    }

    private static JPanel createGameOverMessage(String winner)
    {
        JPanel messagePanel = new JPanel();
        String title;
        Border border;
        if (winner != null)
        {
            title = winner + " won this Game!";
            border = BorderFactory.createLineBorder(Color.GREEN,3);
        }
        else
        {
            title = "Drew Game. There's not winner.";
            border = BorderFactory.createLineBorder(Color.RED,3);
        }

        JLabel titleLabel = new JLabel(title);
        messagePanel.setBorder(border);
        messagePanel.add(titleLabel);

        return messagePanel;
    }
}
