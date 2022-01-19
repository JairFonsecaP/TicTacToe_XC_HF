package tictactoe.controllers;

import tictactoe.models.Welcome;
import tictactoe.views.WelcomePanel;

import java.awt.event.ActionEvent;

public class WelcomeController {
    private final Welcome welcome;//Model
    private final WelcomePanel view;

    public WelcomeController(Welcome welcome, WelcomePanel view){

        this.welcome = welcome;
        this.view = view;
        //TODO
       // initializeView(welcome, view);
        //TODO
        //welcome.addListener(view);
        //TODO
        //view.addExitListener((ActionEvent e) ->onExitClicked());
        //view.addPlayListener((ActionEvent e) ->onPlayClicked());
    }
}
