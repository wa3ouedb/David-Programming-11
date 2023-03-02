package com.example.tictactoe;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestGame {
    Game game;
    @Before
    public void setup(){ game = new Game ();}

    @Test
    public void testResetGame(){
        //tests that game resets properly
        //first clears the board
        for(int i = 0; i < Game.NUMBEROFSQUARES; i++) {
            assertTrue(game.getMoveAtIndex(i) == Game.NOMOVE);
        }
        //then sets player's moves to all positions on the board
        for(int i = 0; i < Game.NUMBEROFSQUARES; i++){
            game.setPlayerMove(i);
        }
        //ensures the board is filled
        for(int i = 0; i < Game.NUMBEROFSQUARES; i++) {
            assertTrue(game.getMoveAtIndex(i) == Game.XMOVE);
        }
        //calls the resetGame() function
        game.resetGame();
        //tests that all positions on the board are empty
        for(int i = 0; i < Game.NUMBEROFSQUARES; i++) {
            assertTrue(game.getMoveAtIndex(i) == Game.NOMOVE);
        }
    }

    @Test
    public void testSetPlayerMove(){
        //tests if player can set a move
        //makes sure the index is first clear
        assertTrue(game.getMoveAtIndex(0) == Game.NOMOVE);
        //player sets a move
        game.setPlayerMove(0);
        //tests that the player move is a "XMOVE"
        assertTrue(game.getMoveAtIndex(0) == Game.XMOVE);
    }

    @Test
    public void testAIMove(){
        //tests AI's move
        //AI sets a move
        int aIMove = game.AIMove();
        //tests that the AI move is an "OMOVE"
        assertTrue(game.getMoveAtIndex(aIMove) == Game.OMOVE);
    }

    @Test
    public void testCheckPlayerWin(){
        //tests player's win conditions
        //check win condition 1
        game.setPlayerMove(0);
        game.setPlayerMove(1);
        game.setPlayerMove(2);
        assertTrue(game.hasPlayerWon());
        assertTrue(game.isGameOver());
        game.resetGame();

        //check win condition 2
        game.setPlayerMove(3);
        game.setPlayerMove(4);
        game.setPlayerMove(5);
        assertTrue(game.hasPlayerWon());
        assertTrue(game.isGameOver());
        game.resetGame();

        //check win condition 3
        game.setPlayerMove(6);
        game.setPlayerMove(7);
        game.setPlayerMove(8);
        assertTrue(game.hasPlayerWon());
        assertTrue(game.isGameOver());
        game.resetGame();

        //check win condition 4
        game.setPlayerMove(0);
        game.setPlayerMove(3);
        game.setPlayerMove(6);
        assertTrue(game.hasPlayerWon());
        assertTrue(game.isGameOver());
        game.resetGame();

        //check win condition 5
        game.setPlayerMove(1);
        game.setPlayerMove(4);
        game.setPlayerMove(7);
        assertTrue(game.hasPlayerWon());
        assertTrue(game.isGameOver());
        game.resetGame();

        //check win condition 6
        game.setPlayerMove(2);
        game.setPlayerMove(5);
        game.setPlayerMove(8);
        assertTrue(game.hasPlayerWon());
        assertTrue(game.isGameOver());
        game.resetGame();

        //check win condition 7
        game.setPlayerMove(0);
        game.setPlayerMove(4);
        game.setPlayerMove(8);
        assertTrue(game.hasPlayerWon());
        assertTrue(game.isGameOver());
        game.resetGame();

        //check win condition 8
        game.setPlayerMove(2);
        game.setPlayerMove(4);
        game.setPlayerMove(6);
        assertTrue(game.hasPlayerWon());
        assertTrue(game.isGameOver());
        game.resetGame();
    }

    @Test
    public void testCheckAiWin(){
        //tests AI's win conditions
        //check win condition 1
        game.setAiMove(0);
        game.setAiMove(1);
        game.setAiMove(2);
        assertTrue(game.hasAIWon());
        assertTrue(game.isGameOver());
        game.resetGame();

        //check win condition 2
        game.setAiMove(3);
        game.setAiMove(4);
        game.setAiMove(5);
        assertTrue(game.hasAIWon());
        assertTrue(game.isGameOver());
        game.resetGame();

        //check win condition 3
        game.setAiMove(6);
        game.setAiMove(7);
        game.setAiMove(8);
        assertTrue(game.hasAIWon());
        assertTrue(game.isGameOver());
        game.resetGame();

        //check win condition 4
        game.setAiMove(0);
        game.setAiMove(3);
        game.setAiMove(6);
        assertTrue(game.hasAIWon());
        assertTrue(game.isGameOver());
        game.resetGame();

        //check win condition 5
        game.setAiMove(1);
        game.setAiMove(4);
        game.setAiMove(7);
        assertTrue(game.hasAIWon());
        assertTrue(game.isGameOver());
        game.resetGame();

        //check win condition 6
        game.setAiMove(2);
        game.setAiMove(5);
        game.setAiMove(8);
        assertTrue(game.hasAIWon());
        assertTrue(game.isGameOver());
        game.resetGame();

        //check win condition 7
        game.setAiMove(0);
        game.setAiMove(4);
        game.setAiMove(8);
        assertTrue(game.hasAIWon());
        assertTrue(game.isGameOver());
        game.resetGame();

        //check win condition 8
        game.setAiMove(2);
        game.setAiMove(4);
        game.setAiMove(6);
        assertTrue(game.hasAIWon());
        assertTrue(game.isGameOver());
        game.resetGame();
    }

    @Test
    public void testRandomAIMove(){
        //tests that AI always has chance to win
        //6 moves is the maximum amount of moves an AI can make to guarantee a win
        for(int i = 0; i < 6; i ++){
            game.AIMove();
        }
        assertTrue(game.hasAIWon());
        assertTrue(game.isGameOver());
    }

}
