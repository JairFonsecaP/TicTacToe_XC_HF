package tictactoe.models;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class History {


    private static ArrayList<Player> players;
    public History(){
        players = new ArrayList<>();
        getHistory();
    }

    private static ArrayList<Player> getHistory() {
        File folder = new File("Players/");
        for (File file : folder.listFiles()) {
            if (file.isFile()){
                try(ObjectInputStream in =  new ObjectInputStream(new FileInputStream(file))){
                    players.add((Player) in.readObject());
                } catch (IOException | ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
        return players;
    }

    public static ArrayList<Player> getPlayers() {
        return players;
    }

}
