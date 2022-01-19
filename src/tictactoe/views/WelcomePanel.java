package tictactoe.views;

import tictactoe.interfaces.IWelcomeListener;
import utility.PanelHelper;

import javax.swing.*;
import java.awt.*;

public class WelcomePanel extends JPanel implements IWelcomeListener {
    private final JTextField player1JTextField;
    private final JTextField player2JTextField;
    private final JButton btnExit;
    private final JButton btnPlay;
    public WelcomePanel (){

        player1JTextField = createPlayerJTextField();
        player2JTextField = createPlayerJTextField();
        btnExit = new JButton("Exit");
        btnPlay = new JButton("Play");

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(PanelHelper.createLargeEmptyBorder());

        add(createTitlePanel());
        add(PanelHelper.createSmallSeparator());
        add(createPlayer1Panel());
        add(PanelHelper.createSmallSeparator());
        add(createPlayer2Panel());
        add(PanelHelper.createSmallSeparator());
        add(createButtonPanel());

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
}
