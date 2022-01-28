package tictactoe.controllers;

import tictactoe.models.Game;
import tictactoe.models.Welcome;
import tictactoe.views.WelcomePanel;
import tictactoe.views.Window;
import tictactoe.views.game.GamePanel;
import tictactoe.views.game.GameWindow;

public class ProgramController
{
    private final Window window;
    public ProgramController()
    {
        //Model
        Welcome welcome = new Welcome();
        //View
        WelcomePanel panel = new WelcomePanel();
        //SGamePanel gamePanel = new GamePanel(3);
        window = new Window("Welcome!", panel);
        //Controller
        WelcomeController controller = new WelcomeController(welcome, panel, this);


        window.setVisible(true);
    }

    public void closeWelcomeWindow()
    {
        window.dispose();
    }

    public static void playGame(int size, String namePlayerX,String namePlayerO)
    {
        GameController game = new GameController(size,namePlayerX,namePlayerO);
    }
}
