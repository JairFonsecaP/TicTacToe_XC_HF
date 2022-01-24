import tictactoe.controllers.WelcomeController;
import tictactoe.models.Welcome;
import tictactoe.views.WelcomePanel;
import tictactoe.views.Window;

public class Program {

    public static void main(String[] args) {
        //Model
        Welcome welcome = new Welcome();
        //View
        WelcomePanel panel = new WelcomePanel();
        //SGamePanel gamePanel = new GamePanel(3);
        Window window = new Window("Welcome!", panel);
        //Controller
        WelcomeController controller = new WelcomeController(welcome, panel, window);

        window.setVisible(true);
    }

}
