package org.example;

import java.util.Scanner;

public abstract class Player{
    public String name;
    public int points;

    //public Player(String name, ArrayList<String> choice, int points)
    public Player(String name) {
        this.name = name;
    }

    public abstract String choose();

}
