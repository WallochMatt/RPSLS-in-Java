package org.example;

public class AiPlayer extends Player{
    public AiPlayer() {
        super("Player 2");
    }


    @Override
    public String choose(){
        return "AiPlayer choose";
    }
}
