package tictactoe.views.game;

import tictactoe.interfaces.IGameListener;
import tictactoe.models.Player;
import tictactoe.models.PlayerType;
import tictactoe.models.Turn;
import utility.PanelHelper;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class GamePanel extends JPanel  implements IGameListener {

    private JLabel roundLabel;
    private JLabel turnLabel;
    private JLabel turnPlayerLabel;
    private JLabel playerXScoreLabel;
    private JLabel playerOScoreLabel;
    private final int size;
    private final ArrayList<ArrayList<SingleSquareGame>> matrix;
    public GamePanel(int size, int round,String namePlayerX, String namePlayerO)
    {
        this.size = size;
        matrix = new ArrayList<>();
        roundLabel = new JLabel(String.valueOf(round));
        turnLabel = new JLabel();
        turnPlayerLabel = new JLabel();
        playerXScoreLabel = new JLabel("0");
        playerOScoreLabel = new JLabel("0");
        JPanel gameZonePanel = createGameZonePanel();
        JPanel informationPanel = createUpperPanel(namePlayerX,namePlayerO);

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(PanelHelper.createLargeEmptyBorder());
        add(informationPanel);
        add(PanelHelper.createLargeSeparator());
        add(gameZonePanel);
    }

    private JPanel createGameZonePanel()
    {
        JPanel gameZonePanel = new JPanel();
        for (int i = 0; i < size; i++)
        {
            matrix.add(createFields());
        }
        gameZonePanel.setLayout(new GridLayout(size,size,3,3));

        for (ArrayList<SingleSquareGame> row: matrix) {
            for (SingleSquareGame field: row )
                gameZonePanel.add(field);
        }
        int singleSize = (size * 10) + (size* 3);
        Dimension dimension = new Dimension(singleSize,singleSize);
        gameZonePanel.setSize(dimension);

        return gameZonePanel;
    }

    private ArrayList<SingleSquareGame> createFields(){
        ArrayList<SingleSquareGame> row = new ArrayList<>();
        for (int i = 0;i<size;i++){
            SingleSquareGame field = new SingleSquareGame();
            row.add(field);
        }
        return row;
    }

    private JPanel createUpperPanel(String namePlayerX, String namePlayerO){

        JPanel upperPanel = new JPanel();
        upperPanel.setLayout(new GridLayout(1,3));
        upperPanel.add(new JLabel("ROUND:"));
        roundLabel.setHorizontalAlignment(SwingConstants.LEFT);
        upperPanel.add(roundLabel);
        DateTimeFormatter formatDate = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate now = LocalDate.now();
        JLabel dateLabel = new JLabel(now.format(formatDate));
        dateLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        upperPanel.add(dateLabel);

        JPanel playerXPanel = new JPanel(new GridLayout(2,1));
        JLabel playerXLabel = new JLabel(namePlayerX+ " [" + PlayerType.X + "]");
        playerXLabel.setHorizontalAlignment(SwingConstants.CENTER);
        playerXLabel.setForeground(Color.RED);
        JPanel scorePlayerXPanel = new JPanel();
        scorePlayerXPanel.add(new JLabel("Score: "));
        scorePlayerXPanel.add(playerXScoreLabel);
        playerXPanel.add(playerXLabel);
        playerXPanel.add(scorePlayerXPanel);
        playerXPanel.setBackground(Color.white);
        playerXPanel.setBorder(BorderFactory.createLineBorder(Color.black));

        JPanel playerOPanel = new JPanel(new GridLayout(2,1));
        JLabel playerOLabel = new JLabel(namePlayerO+ " [" + PlayerType.O + "]");
        playerOLabel.setHorizontalAlignment(SwingConstants.CENTER);
        playerOLabel.setForeground(Color.blue);
        JPanel scorePlayerOPanel = new JPanel();
        scorePlayerOPanel.add(new JLabel("Score: "));
        scorePlayerOPanel.add(playerOScoreLabel);
        playerOPanel.add(playerOLabel);
        playerOPanel.add(scorePlayerOPanel);
        playerOPanel.setBackground(Color.white);
        playerOPanel.setBorder(BorderFactory.createLineBorder(Color.black));

        JPanel turnPanel = new JPanel();
        turnPanel.setLayout(new GridLayout(2,1));
        turnPlayerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        turnPanel.add(turnPlayerLabel);
        turnLabel.setHorizontalAlignment(SwingConstants.CENTER);
        turnPanel.add(turnLabel);

        JPanel lowerPanel = new JPanel();
        lowerPanel.setLayout(new BoxLayout(lowerPanel, BoxLayout.X_AXIS));
        lowerPanel.add(playerXPanel);
        lowerPanel.add(turnPanel);
        lowerPanel.add(playerOPanel);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
        panel.add(upperPanel);
        panel.add(PanelHelper.createLargeSeparator());
        panel.add(lowerPanel);
        return panel;
    }

    public ArrayList<ArrayList<SingleSquareGame>> getMatrix()
    {
        return matrix;
    }

    public void addButtonsListener(ActionListener listener){

        for (ArrayList<SingleSquareGame> row: matrix) {
            for (SingleSquareGame list: row ) {
                list.addActionListener(listener);
            }
        }
    }
    @Override
    public void buttonClicked(int x,int y, Player player) {
        SingleSquareGame button = matrix.get(x).get(y);
        button.setText(String.valueOf(player.getPlayerType().getPlayerTypeChar()));
        button.setEnabled(false);

    }


    @Override
    public void restart() {
        for (ArrayList<SingleSquareGame> row: matrix) {
            for (SingleSquareGame field: row ) {
                field.setText("");
                field.setEnabled(true);
            }
        }
    }

    @Override
    public void setRound(int round) {
        roundLabel.setText(String.valueOf(round));
    }

    @Override
    public void setTurn(Turn turn)
    {
        if(turn.getTurnPlayer() == PlayerType.X) {
            turnPlayerLabel.setText("Turn of [" + PlayerType.X + "]");
            turnLabel.setText("<=======");
            turnLabel.setForeground(Color.RED);
        }
        else {
            turnPlayerLabel.setText("Turn of [" + PlayerType.O + "]");
            turnLabel.setText("=======>");
            turnLabel.setForeground(Color.BLUE);
        }
    }

    @Override
    public void scoreOPlayerChanged(int score) {
        playerOScoreLabel.setText(String.valueOf(score));
    }

    @Override
    public void scoreXPlayerChanged(int score) {
        playerXScoreLabel.setText(String.valueOf(score));

    }
}
