package tictactoe.models;

import tictactoe.interfaces.IWelcomeListener;

import java.util.ArrayList;

public class Welcome {

    private Player player1;
    private Player player2;
    private final ArrayList<IWelcomeListener> listeners;

    public Welcome(){
        listeners = new ArrayList<>();
    }
    public void addListener(IWelcomeListener listener){
        listeners.add(listener);
    }
    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public void setPlayer1(String name){
        if (name == null)
            throw new IllegalArgumentException("Name must not be null");
        this.player1.setName(name);

        for (IWelcomeListener listener: listeners)
            listener.player1NameChanged(name);
    }

    public void setPlayer2Name(String name){
        if (name == null)
            throw new IllegalArgumentException("Name must not be null");
        this.player2.setName(name);

        for (IWelcomeListener listener: listeners)
            listener.player2NameChanged(name);
    }
}
