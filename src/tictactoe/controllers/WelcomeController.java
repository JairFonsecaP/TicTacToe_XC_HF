package tictactoe.controllers;

import tictactoe.models.Player;
import tictactoe.models.Welcome;
import tictactoe.views.Window;
import tictactoe.views.game.GamePanel;
import tictactoe.views.game.GameWindow;
import tictactoe.views.WelcomePanel;

import javax.swing.*;
import java.awt.event.ActionEvent;


public class WelcomeController {
    private final Welcome welcome;//Model
    private final WelcomePanel view;
    private final Window windowWelcome;

    public WelcomeController(Welcome welcome, WelcomePanel view, Window window){

        this.welcome = welcome;
        this.view = view;
        this.windowWelcome = window;

        initializeView(view);

        welcome.addListener(view);

        view.addExitListener((ActionEvent e) ->onExitClicked());
        view.addPlayListener((ActionEvent e) ->onPlayClicked());
    }

    private void onPlayClicked() {
        if(playersNamesAreValid()){

            //Set players
            Player player1 = new Player(view.getPlayer1JTextField(),0,0);
            Player player2 = new Player(view.getPlayer2JTextField(),0,0);

            //Open new window
            GamePanel panel = new GamePanel(view.getBoardSize(), player1, player2);
            GameWindow window = new GameWindow("Tic Tac Toe Game", panel);
            window.setVisible(true);

            //Close actual window
            //view.getParent().setVisible(false);
            /*
            Line for closing the welcome window
             */
            windowWelcome.dispose();
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
