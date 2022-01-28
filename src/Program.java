import tictactoe.controllers.WelcomeController;
import tictactoe.models.Welcome;
import tictactoe.views.welcome.WelcomePanel;
import tictactoe.views.welcome.WelcomeWindow;

public class Program {

    public static void main(String[] args) {
        //Model
        Welcome welcome = new Welcome();
        //View
        WelcomePanel panel = new WelcomePanel();
        //SGamePanel gamePanel = new GamePanel(3);
        WelcomeWindow window = new WelcomeWindow("Welcome!", panel);
        //Controller
        WelcomeController controller = new WelcomeController(welcome, panel, window);

        window.setVisible(true);
    }

}
