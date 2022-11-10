package org.example;

import java.util.Objects;
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

    public int chooseRounds() throws NumberFormatException{

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

    public void playGame() {
        int currentRounds = 0;
        int numberOfRounds = chooseRounds();
        System.out.println("numberOfRounds in playGame" + numberOfRounds);

        while (currentRounds < numberOfRounds) {
            currentRounds += 1;
            System.out.println("Round " + currentRounds);

            String playerOneChoice = user_1.choose();
            System.out.println("You chose: " + playerOneChoice);

            String playerTwoChoice = user_2.choose();
            System.out.println("You chose: " + playerTwoChoice);

            //////////////////////////////////////Above works

            if (Objects.equals(playerOneChoice, "Lizard") && (Objects.equals(playerTwoChoice, "Spock") || Objects.equals(playerTwoChoice, "Paper"))) {
                user_1.points += 1;
                System.out.println(user_1.name + " won the round!");
            }
            else if (Objects.equals(playerOneChoice, "Rock") && (Objects.equals(playerTwoChoice, "Scissors") || Objects.equals(playerTwoChoice, "Lizard"))) {
                user_1.points += 1;
                System.out.println(user_1.name + " won the round!");
            }
            else if (Objects.equals(playerOneChoice, "Scissors") && (Objects.equals(playerTwoChoice, "Paper") || Objects.equals(playerTwoChoice, "Lizard"))) {
                user_1.points += 1;
                System.out.println(user_1.name + " won the round!");
            }
            else if (Objects.equals(playerOneChoice, "Spock") && (Objects.equals(playerTwoChoice, "Scissors") || Objects.equals(playerTwoChoice, "Rock"))) {
                user_1.points += 1;
                System.out.println(user_1.name + " won the round!");
            }
            else if (Objects.equals(playerOneChoice, "Paper") && (Objects.equals(playerTwoChoice, "Rock") || Objects.equals(playerTwoChoice, "Spock"))) {
                user_1.points += 1;
                System.out.println(user_1.name + " won the round!");
            }
            else if (Objects.equals(playerOneChoice, playerTwoChoice)) {
                currentRounds -= 1;
                System.out.println("Tie");
            }
            else {
                user_2.points += 1;
                System.out.println(user_2.name + " won the round!");
            }
            checkForWinner(numberOfRounds, currentRounds);
        }
        ;
    }

    public void checkForWinner(int numberOfRounds, int currentRound){
        int majority = (numberOfRounds / 2) + 1;
        if (user_1.points >= majority) {
            gameOver(user_1, currentRound);
        }
        else if (user_2.points >= majority) {
            gameOver(user_2, currentRound);
//            System.out.println(user_2.name + " WINS!");

        }

    }

    public void gameOver(Player player, int currentRound){
        System.out.println("GAME OVER");
        System.out.println(player.name + " WINS!");
        currentRound += 100;
    }

}
