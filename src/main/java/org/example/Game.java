package org.example;

import java.util.Scanner;
import static java.lang.Integer.parseInt;

public class Game {
    //Instance Variables (HAS A)
    public Player user_1;
    public Player user_2;


    public Game() {
        this.user_1 =  new HumanPlayer("Player 1");
        this.user_2 = chooseOpponent();
    }

    public Player chooseOpponent(){
        System.out.println("""
                Choose your opponent:\s
                AI or Multiplayer\s
                1: Ai\s
                2: Multiplayer""");
        Scanner sc = new Scanner(System.in);
        String who_you_chose = sc.nextLine();
        int convertedChoice = parseInt(who_you_chose);

        if(convertedChoice == 1){
            return new AiPlayer();
        }
        else if(convertedChoice == 2){
            return new HumanPlayer("n00bMaster");
        }
        else{
            System.out.println("Error");
        }

        return null;
    }

    public void run_game(){
        displayWelcome();
        playGame();

    }

    public static void displayWelcome(){
        System.out.println("\n Wanna play Rock, Paper, Scissors, Lizard, Spock? \n");
        System.out.println("""
                Remember the rules:\s
                Scissors cuts Paper, Scissors decapitates Lizard,\s
                Paper covers Rock, Paper disproves Spock, \s
                Rock crushes Lizard, Rock crushes Scissors,\s
                Lizard poisons Spock, Lizard eats Paper \s
                Spock smashes Scissors, Spock vaporizes Rock \s
                
                Ready to play?
                """);
    }

    public int chooseRounds(){

        System.out.println("""
                Choose the number of rounds to play: \s
                Enter: 3 5 7 9
                """);
        Scanner scanner = new Scanner(System.in);
        int selectedOption = Integer.parseInt(scanner.nextLine());

        return switch (selectedOption) {
            case 3 -> 3;
            case 5 -> 5;
            case 7 -> 7;
            case 9 -> 9;
            default -> 0; //recurse?
        };

    }

    public void playGame(){
        int currentRounds = 0;
        int numberOfRounds = chooseRounds();
        System.out.println("numberOfRounds in playGame" + numberOfRounds);

        while(currentRounds < numberOfRounds){
            currentRounds += 1;
        }

        System.out.println("Player one, choose a gesture: ");

        Scanner scanner = new Scanner(System.in);
        String selectedChoice = scanner.nextLine();

//        playerOneChoice = switch (selectedChoice){
//
//        }
    }
}
