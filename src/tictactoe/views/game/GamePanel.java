package tictactoe.views.game;

import tictactoe.interfaces.IGameListener;
import tictactoe.models.Player;
import utility.PanelHelper;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class GamePanel extends JPanel  implements IGameListener {

    private JLabel roundLabel;
    private final int size;
    private final ArrayList<ArrayList<SingleSquareGame>> matrix;
    public GamePanel(int size, int round,String namePlayerX, String namePlayerO)
    {
        this.size = size;
        matrix = new ArrayList<>();

        roundLabel = new JLabel("Round: " + round);
        JPanel gameZonePanel = createGameZonePanel();

        setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        setBorder(PanelHelper.createLargeEmptyBorder());
        add(createUpperPanel(namePlayerX,namePlayerO));
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
        Dimension dimension = new Dimension((size * 10) + (size* 3),(size * 10) + (size* 3));
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
        JPanel panel = new JPanel();
        JPanel upperPanel = new JPanel();
        JPanel lowerPanel = new JPanel();
        LocalDate now = LocalDate.now();
        DateTimeFormatter formatDate = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        JLabel dateLabel = new JLabel(now.format(formatDate));
        upperPanel.add(roundLabel);
        add(PanelHelper.createLargeSeparator());
        setLayout(new GridLayout(2,1));
        upperPanel.add(dateLabel);

        JLabel playerXLabel = new JLabel(namePlayerX);
        JLabel playerOLabel = new JLabel(namePlayerO);

        lowerPanel.add(playerXLabel);
        lowerPanel.add(playerOLabel);

        panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
        panel.add(upperPanel);
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
        roundLabel.setText("Round: " + round);
    }
}
