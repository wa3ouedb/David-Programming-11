package com.example.tictactoe;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class TestPlayer {
    Player player;
    @Before
    public void setup(){
        player = new Player("username", 1, 0);
    }
    @Test
    public void testGetUsername(){
        String name = player.getUsername();
        assertTrue(name.equals("username"));
    }

    @Test
    public void testGetWins(){
        //tests that getWins is true
        int wins = player.getWins();
        assertTrue(wins == 1);
    }

    @Test
    public void testGetLosses(){
        //tests that getLosses is true
        int losses = player.getLosses();
        assertTrue(losses == 0);
    }

    @Test
    public void testSetUsername(){
        //tests username sets properly
        assertTrue(player.getUsername().equals("username"));
        player.setUsername("new Username");
        assertTrue(player.getUsername().equals("new Username"));
    }

    @Test
    public void testSetWins() {
        //tests that setting wins works properly
        assertTrue(player.getWins() == 1);
        player.setWins(8);
        assertTrue(player.getWins() == 8);
    }

    @Test
    public void testIncrementWins(){
        //tests that player wins are incremented correctly
        assertTrue(player.getWins() == 1);
        player.incrementWins();
        assertTrue(player.getWins() == 2);
    }

    @Test
    public void testIncrementLosses(){
        //tests that player losses are also incremented correctly
        assertTrue(player.getLosses() == 0);
        player.incrementLosses();
        assertTrue(player.getLosses() == 1);
    }

    @Test
    public void testToString(){
        //tests the ToString
        assertTrue(player.toString().equals(player.getUsername() + "," + player.getWins() + "," + player.getLosses()));
    }


}
