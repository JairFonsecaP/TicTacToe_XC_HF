package tictactoe.controllers;

import tictactoe.models.Game;
import tictactoe.models.Player;
import tictactoe.models.Welcome;
import tictactoe.views.history.HistoryInformationPanel;
import tictactoe.views.history.HistoryPanel;
import tictactoe.views.history.HistoryWindow;
import tictactoe.views.welcome.WelcomePanel;

import java.util.ArrayList;

public class HistoryController {
    private final HistoryInformationPanel view;
    private final HistoryWindow historyWindow;


    public HistoryController(HistoryWindow historyWindow , HistoryInformationPanel view){
        this.view = view;
        this.historyWindow = historyWindow;

    }
    public static ArrayList<Player> getHistory() {
        return null;
    }
}
