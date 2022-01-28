package tictactoe.controllers;


import tictactoe.models.Welcome;
import tictactoe.views.Window;
import tictactoe.views.welcome.WelcomePanel;

public class ProgramController
{
    private final Window window;
    public ProgramController()
    {
        //Model
        Welcome welcome = new Welcome();
        //View
        WelcomePanel panel = new WelcomePanel();

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
