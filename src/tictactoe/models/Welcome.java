package tictactoe.models;

import tictactoe.interfaces.IWelcomeListener;

import java.util.ArrayList;

public class Welcome {


    private final ArrayList<IWelcomeListener> listeners;

    public Welcome(){
        listeners = new ArrayList<>();
    }
    public void addListener(IWelcomeListener listener){
        listeners.add(listener);
    }




}
