package tictactoe.logs;

import tictactoe.models.Player;

import java.io.*;

public class PlayerObjectLogger {

    private final String path;
    private final Player player;

    public PlayerObjectLogger(Player player){
        path = "Players/" + player.getName() + ".data";
        this.player = player;
    }

    public PlayerObjectLogger(){
        path = "Players/";
        this.player = null;
    }

    public boolean playerExist(String name){
        File file = new File(path + name + ".data");
        return file.exists();
    }

    public Player getPlayerObject(String name){
        String path = "Players/" + name + ".data";
        if (name != null) {
            try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(path))) {
                return (Player) in.readObject();
            } catch (IOException | ClassNotFoundException |ClassCastException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public void writePlayerLog(){
        try(ObjectOutputStream out= new ObjectOutputStream(new FileOutputStream(path))){
            out.writeObject(player);
        }catch (IOException e ){
            e.printStackTrace();
        }
    }

}


