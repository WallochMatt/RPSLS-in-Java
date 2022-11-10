package org.example;

import java.util.Scanner;

public abstract class Player {
    public String name;
    public String[] choice;
    public int points;
    public String selectedChoice;

    //public Player(String name, ArrayList<String> choice, int points)
    public Player(String name) {
        this.name = name;
        this.choice = new String[5];
        choice[0] = "Rock";
        choice[1] = "Paper";
        choice[2] = "Scissors";
        choice[3] = "Lizard";
        choice[4] = "Spock";
        this.points = 0;
    }

    public void chooseGesture(){
        System.out.println("Choose your gesture: ");
        Scanner sc = new Scanner(System.in);
        selectedChoice = sc.nextLine();
    }

}
