package tictactoe.logs;

import tictactoe.models.Player;

import java.io.*;

public class PlayerObjectLogger {

    private static final String path = "Players/";

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

    public static void writePlayerLog(Player player){
        try(ObjectOutputStream out= new ObjectOutputStream(new FileOutputStream(path + player.getName() +  ".data"))){
            out.writeObject(player);
        }catch (IOException e ){
            e.printStackTrace();
        }
    }

}


