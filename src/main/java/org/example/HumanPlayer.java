package org.example;

import java.util.Scanner;

public class HumanPlayer extends Player{
    public HumanPlayer(String name) {
        super(name);
    }

    @Override
    public String choose(){
        System.out.println(name +
                """
                , choose a gesture: \s
                1: Rock \s
                2: Paper \s
                3: Scissors \s
                4: Lizard \s
                5: Spock
                """);
        Scanner scanner = new Scanner(System.in);
        int playerOneChoice = Integer.parseInt(scanner.nextLine());

        return switch (playerOneChoice) {
            case 1 -> "Rock";
            case 2 -> "Paper";
            case 3 -> "Scissors";
            case 4 -> "Lizard";
            case 5 -> "Spock";
            default -> "error";
        };

    }
}
