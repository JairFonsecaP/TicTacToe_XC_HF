package tictactoe.controllers;

import tictactoe.models.Player;
import tictactoe.views.history.HistoryInformationPanel;
import tictactoe.views.history.HistoryWindow;

import java.io.IOException;

public class HistoryController {
    private final HistoryInformationPanel view;
    private final HistoryWindow historyWindow;


    public HistoryController(HistoryWindow historyWindow , HistoryInformationPanel view){
        this.view = view;
        this.historyWindow = historyWindow;
        view.players = Player.getPlayers();
    }

}
