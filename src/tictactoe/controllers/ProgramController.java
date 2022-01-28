package tictactoe.controllers;


import tictactoe.models.Welcome;
import tictactoe.views.welcome.WelcomePanel;
import tictactoe.views.welcome.WelcomeWindow;

import java.awt.*;

public class ProgramController
{
    private final WelcomeWindow window;
    public ProgramController()
    {
        //Model
        Welcome welcome = new Welcome();
        //View
        WelcomePanel panel = new WelcomePanel();
        //SGamePanel gamePanel = new GamePanel(3);
        window = new WelcomeWindow("Welcome!", panel);
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
