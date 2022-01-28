package tictactoe.views.welcome;

import tictactoe.interfaces.IWelcomeListener;
import utility.PanelHelper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

public class WelcomePanel extends JPanel implements IWelcomeListener {


    private final JTextField player1JTextField;
    private final JTextField player2JTextField;
    private final JLabel historyLabel;
    private final JComboBox boardSizeList;
    String[] boardSizes = {"3x3", "4x4", "5x5"};
    private final JButton btnExit;
    private final JButton btnPlay;
    public WelcomePanel (){

        player1JTextField = createPlayerJTextField();
        player2JTextField = createPlayerJTextField();
        boardSizeList = new JComboBox(boardSizes);
        btnExit = new JButton("Exit");
        btnPlay = new JButton("Play");
        historyLabel = new JLabel("History");

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(PanelHelper.createLargeEmptyBorder());

        add(createTitlePanel());
        add(PanelHelper.createSmallSeparator());
        add(createPlayer1Panel());
        add(PanelHelper.createSmallSeparator());
        add(createPlayer2Panel());
        add(PanelHelper.createSmallSeparator());
        add(createSelectBoardSizePanel());
        add(PanelHelper.createSmallSeparator());
        add(createButtonPanel());
        add(PanelHelper.createLargeSeparator());
        add(createHistoryLinkPanel());

    }

    private JPanel createHistoryLinkPanel() {
        JPanel historyPanel = new JPanel();
        historyPanel.setLayout(new BoxLayout(historyPanel, BoxLayout.X_AXIS));
        historyLabel.setForeground(Color.BLUE.darker());
        historyLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        historyPanel.add(historyLabel);
        return historyPanel;
    }

    private JPanel createSelectBoardSizePanel() {
        JPanel boardSizePanel = new JPanel();
        boardSizePanel.setLayout(new BoxLayout(boardSizePanel, BoxLayout.X_AXIS));
        boardSizePanel.add(new JLabel("Board size: "));
        boardSizePanel.add(PanelHelper.createSmallSeparator());
        boardSizePanel.add(boardSizeList);
        return boardSizePanel;
    }

    private JPanel createButtonPanel() {
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
        buttonPanel.add(btnExit);
        buttonPanel.add(PanelHelper.createSmallSeparator());
        buttonPanel.add(btnPlay);
        return buttonPanel;
    }

    private JPanel createPlayer1Panel() {
        JPanel player1Panel = new JPanel();
        player1Panel.setLayout(new BoxLayout(player1Panel, BoxLayout.X_AXIS));
        JLabel player1Label = new JLabel("Player1 (X):");
        player1Panel.add(player1Label);
        player1Panel.add(PanelHelper.createSmallSeparator());
        player1Panel.add(player1JTextField);
        return player1Panel;
    }
    private JPanel createPlayer2Panel() {
        JPanel player2Panel = new JPanel();
        player2Panel.setLayout(new BoxLayout(player2Panel, BoxLayout.X_AXIS));
        JLabel player1Label = new JLabel("Player2 (O):");
        player2Panel.add(player1Label);
        player2Panel.add(PanelHelper.createSmallSeparator());
        player2Panel.add(player2JTextField);
        return player2Panel;
    }

    private JPanel createTitlePanel() {
        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(new BoxLayout(titlePanel, BoxLayout.X_AXIS));
        titlePanel.setAlignmentX(Panel.CENTER_ALIGNMENT);
        JLabel titleLabel = new JLabel("Tic Tac Toe Game");
        titleLabel.setFont(new Font(
                titlePanel.getFont().getFontName(),
                Font.BOLD,
                titlePanel.getFont().getSize()+4));
        titlePanel.add(titleLabel);
        return titlePanel;
    }

    private JTextField createPlayerJTextField(){

        JTextField text =  new JTextField("",5);
        Dimension dimension = new Dimension(100,20);
        text.setMaximumSize(dimension);
        text.setPreferredSize(dimension);

        return text;
    }

    @Override
    public void player1NameChanged(String name) {
        if (name == null)
            throw new IllegalArgumentException("Name must not be null");
        this.player1JTextField.setText(name);
    }

    @Override
    public void player2NameChanged(String name) {
        if (name == null)
            throw new IllegalArgumentException("Name must not be null");
        this.player2JTextField.setText(name);
    }

    public void addExitListener(ActionListener listener){

        btnExit.addActionListener(listener);
    }
    public void addPlayListener(ActionListener listener){
        btnPlay.addActionListener(listener);
    }
    public void addHistoryListener(MouseListener listener){
        historyLabel.addMouseListener(listener);
    }

    public String getPlayer1JTextField() {
        return player1JTextField.getText();
    }

    public String getPlayer2JTextField() {
        return player2JTextField.getText();
    }
    public int getBoardSize(){
        switch (boardSizeList.getSelectedIndex()){
            case 0: return 3;
            case 1: return 4;
            case 2: return 5;
            default: return 0;
        }

    }
}
