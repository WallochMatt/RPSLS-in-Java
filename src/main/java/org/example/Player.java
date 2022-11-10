package org.example;

import java.util.Scanner;

public abstract class Player implements Chooser{
    public String name;
    public int points;

    //public Player(String name, ArrayList<String> choice, int points)
    public Player(String name) {
        this.name = name;
    }

    public String Choose(){
        System.out.println("Choose your gesture: ");
        Scanner sc = new Scanner(System.in);
        String selectedChoice = sc.nextLine();
        return "Player -> Choose return" + selectedChoice;
    };

}
