//Player Class

package com.example.tictactoe;


public class Player {
    //public Player fields
    private String username;
    private int wins;
    private int losses;

    //Player constructor
    public Player(String username, int wins, int losses){
        this.username = username;
        this.wins = wins;
        this.losses = losses;
    }

    //accessors
    public String getUsername(){
        return username;
    }
    public int getWins () { return wins; }
    public int getLosses() { return losses; }

    //mutators
    public void setUsername(String username){
        this.username = username;
    }
    public void setWins (int wins){
        this.wins = wins;
    }
    public void setLosses (int losses){
        this.losses = losses;
    }

    //increment wins function
    public int incrementWins(){
        wins ++;
        return wins;
    }

    //increment losses function
    public int incrementLosses(){
        losses ++;
        return losses;
    }

    //Combines all data into a string
    public String toString (){
        return username + "," + wins + "," + losses;
    }


}

