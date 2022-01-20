package tictactoe.controllers;

import tictactoe.models.Welcome;
import tictactoe.views.WelcomePanel;

import javax.swing.*;
import java.awt.event.ActionEvent;


public class WelcomeController {
    private final Welcome welcome;//Model
    private final WelcomePanel view;

    public WelcomeController(Welcome welcome, WelcomePanel view){

        this.welcome = welcome;
        this.view = view;

        initializeView(welcome, view);

        welcome.addListener(view);

        view.addExitListener((ActionEvent e) ->onExitClicked());
        view.addPlayListener((ActionEvent e) ->onPlayClicked());
    }

    private void onPlayClicked() {
        if(playersNamesAreValid()){
            //TODO
            //Set names por players
            //Open new window
            //Close actual window
        }else{
            JOptionPane.showMessageDialog( view.getParent(),"Error: Players names are invalid","Tic Tac Toe Game",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private boolean playersNamesAreValid() {
        return view.getPlayer1JTextField().length() >=1 && view.getPlayer2JTextField().length() >=1;
    }

    private void onExitClicked() {
        if (JOptionPane.showConfirmDialog( view.getParent(),"Please, confirm if you Want to Exit","Tic Tac Toe Game",
                JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION)
            System.exit(0);
    }

    private void initializeView(Welcome welcome, WelcomePanel view) {
        view.player1NameChanged("");
        view.player2NameChanged("");
    }
}
