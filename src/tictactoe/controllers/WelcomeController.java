package tictactoe.controllers;

import tictactoe.models.Player;
import tictactoe.models.Welcome;
import tictactoe.views.GamePanel;
import tictactoe.views.GameWindow;
import tictactoe.views.WelcomePanel;
import tictactoe.views.Window;

import javax.swing.*;
import java.awt.event.ActionEvent;


public class WelcomeController {
    private final Welcome welcome;//Model
    private final WelcomePanel view;

    public WelcomeController(Welcome welcome, WelcomePanel view){

        this.welcome = welcome;
        this.view = view;

        initializeView(view);

        welcome.addListener(view);

        view.addExitListener((ActionEvent e) ->onExitClicked());
        view.addPlayListener((ActionEvent e) ->onPlayClicked());
    }

    private void onPlayClicked() {
        if(playersNamesAreValid()){
            //TODO extract function
            //Set players
            Player player1 = new Player(view.getPlayer1JTextField(),0,0);
            Player player2 = new Player(view.getPlayer2JTextField(),0,0);

            //Open new window
            GamePanel panel = new GamePanel(view.getBoardSize(), player1, player2);
            GameWindow window = new GameWindow("Tic Tac Toe Game", panel);
            window.setVisible(true);
            //TODO pasar por parametro el window y ocultarlo.
            //Close actual window
            view.getParent().setVisible(false);
        }else{
            JOptionPane.showMessageDialog( view.getParent(),"Error: Players names are invalid","Tic Tac Toe Game",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private boolean playersNamesAreValid() {
        return view.getPlayer1JTextField().length() >=1
                && view.getPlayer2JTextField().length() >=1
                && !view.getPlayer2JTextField().equals(view.getPlayer1JTextField());
    }

    private void onExitClicked() {
        if (JOptionPane.showConfirmDialog( view.getParent(),"Please, confirm if you Want to Exit","Tic Tac Toe Game",
                JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION)
            System.exit(0);
    }

    private void initializeView(WelcomePanel view) {
        view.player1NameChanged("");
        view.player2NameChanged("");
    }
}
