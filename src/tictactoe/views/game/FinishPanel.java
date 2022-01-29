package tictactoe.views.game;

import utility.PanelHelper;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class FinishPanel extends JPanel
{

    public static JPanel createPopUpPanel(String winner, String namePlayerX, String namePlayerO, int scorePlayerX, int scorePlayerO)
    {
        JPanel popUp = new JPanel();
        popUp.setLayout(new GridLayout(5,1));
        popUp.add(createMessage(winner));
        popUp.add(PanelHelper.createSmallSeparator());
        popUp.add(createScorePanel(namePlayerX, namePlayerO, scorePlayerX, scorePlayerO));
        popUp.add(PanelHelper.createSmallSeparator());
        popUp.add(createQuestionPanel());
        return popUp;
    }


    private static JPanel createQuestionPanel()
    {
        JPanel questionPanel = new JPanel();
        JLabel questionLabel = new JLabel("Would you like to play again?");
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
            title = winner + " won!!";
            border = BorderFactory.createLineBorder(Color.GREEN,5);
        }
        else
        {
            title = "Tied Game";
            border = BorderFactory.createLineBorder(Color.RED,5);
        }

        JLabel titleLabel = new JLabel(title);
        messagePanel.setBorder(border);
        messagePanel.add(titleLabel);

        return messagePanel;
    }

    private static JPanel createScorePanel(String namePlayerX, String namePlayerO, int scorePlayerX, int scorePlayerO)
    {
        JPanel scorePanel = new JPanel();
        scorePanel.setLayout(new GridLayout(2,1,0,16));
        JLabel scorePlayerXLabel = new JLabel(namePlayerX+ "'s score: " + scorePlayerX);
        JLabel scorePlayerOLabel = new JLabel(namePlayerO + "'s score: " + scorePlayerO);
        scorePanel.add(scorePlayerXLabel);
        scorePanel.add(scorePlayerOLabel);
        return scorePanel;
    }
}
