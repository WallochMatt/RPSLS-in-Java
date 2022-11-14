package org.example;

import java.util.Random;

public class AiPlayer extends Player{
    public AiPlayer() {
        super("BOT");
    }


    @Override
    public String choose(){
        Random ai = new Random();
        int choice = ai.nextInt(5) + 1;

        return switch (choice) {
            case 1 -> "Rock";
            case 2 -> "Paper";
            case 3 -> "Scissors";
            case 4 -> "Lizard";
            case 5 -> "Spock";
            default -> "error";
        };
    }
}
