package tictactoe.controllers;

import tictactoe.models.Game;
import tictactoe.views.game.GamePanel;

import java.awt.event.ActionEvent;

public class GameController {

    private final GamePanel view;
    private final Game model;

    public GameController(GamePanel view, Game model ){
        this.view = view;
        this.model = model;
        model.addListener(view.getGameZonePanel());

        view.getGameZonePanel().addButtonsListener((ActionEvent e) -> onButtonClicked(e));

    }

    private void onButtonClicked(ActionEvent e) {
        view.getGameZonePanel().buttonClicked(e.getSource());
    }
}
