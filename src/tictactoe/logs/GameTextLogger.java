package tictactoe.logs;

import tictactoe.models.Game;
import utility.CurrencyHelper;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class GameTextLogger  {
    private static String path;
    private static Game game;

    public GameTextLogger(Game game){
        path = "Game/Log.txt";
        this.game = game;
    }

    public void writeLogFile(String message){
        try(FileWriter writer = new FileWriter(path,true)){

            LocalDateTime now = LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS);
            writer.write("\n");
            writer.write(now.toString());
            writer.write(" | Game ID: " + game.getId());
            writer.write(" | PlayerX: " + game.getPlayerX().getName());
            writer.write(" – PlayerX Score: " + game.getScorePlayerX());
            writer.write(" | PlayerO: " + game.getPlayerO().getName());
            writer.write(" – PlayerO Score: " + game.getScorePlayerO());
            writer.write(" | Round: "+ game.getRound() );
            writer.write(" | Turn: "+ game.getTurn().getTurnPlayer());
            writer.write(message.length() >= 1 ?  " | " + message : "");
            writer.flush();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
