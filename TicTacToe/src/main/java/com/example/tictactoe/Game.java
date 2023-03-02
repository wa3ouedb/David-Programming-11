//Game class
package com.example.tictactoe;
import java.util.ArrayList;
import java.util.Random;

public class Game {
    //Game Fields
    public static final int NUMBEROFSQUARES = 9;
    private char [] boardState = new char[NUMBEROFSQUARES];
    public static final char XMOVE = 'x'; //human player's move
    public static final char OMOVE = 'o'; // ai move
    public static final char NOMOVE = ' ';
    public static final char INVALIDMOVE = 'i';
    private Random random;

    private int [] [] winConditions;

    //Game constructor
    public Game (){
        setupWinConditions();
        resetGame();
        random = new Random();
        random.setSeed(System.currentTimeMillis());
    }

    //function for resetting the game
    public void resetGame(){
        //sets all indexes of the board to NOMOVE
        for(int i = 0; i < NUMBEROFSQUARES; i ++){
            boardState [i] = NOMOVE;
        }
    }

    //sets up values for testing
    public char getMoveAtIndex(int index){
        if(index >= 0 && index < NUMBEROFSQUARES){
            return boardState[index];
        }
        return INVALIDMOVE;
    }

    //function for setting a player's move
    public void setPlayerMove(int index){
        //sets player's move if it is valid
        if (isValidMove(index)){
            boardState [index] = XMOVE;
        }
    }

    //function for setting up AI's move
    public int AIMove(){
        //builds a list of empty spaces
        ArrayList<Integer> noMOVES = new ArrayList<>();
        for (int i= 0; i < boardState.length; i ++){
            if (boardState[i] == NOMOVE){
                noMOVES.add(i);
            }
        }
        if (noMOVES.isEmpty()){
            return -1;
        }
        //randomly places AI's move
        int moveIndex = (int) random.nextInt(noMOVES.size());
        int aiBoardMoveIndex = noMOVES.get(moveIndex);
        //gets value of the index in the noMOVES array
        setAiMove(aiBoardMoveIndex);
        return aiBoardMoveIndex;
    }

    //function for setting up win conditions
    private void setupWinConditions(){
        winConditions = new int[8] [3];
        //horizontal cross
        winConditions[0] = new int[]{0, 1, 2};
        winConditions[1] = new int[]{3, 4, 5};
        winConditions[2] = new int[]{6, 7, 8};
        //vertical cross
        winConditions[3] = new int[]{0, 3, 6};
        winConditions[4] = new int[]{1, 4, 7};
        winConditions[5] = new int[]{2, 5, 8};
        //diagonal cross
        winConditions[6] = new int[]{0, 4, 8};
        winConditions[7] = new int[]{2, 4, 6};
     }

     //private function for CheckWin
     private boolean checkWin(char move){
        //checks if the current win condition is met by the move
        for(int i = 0; i < winConditions.length; i ++){
            if (boardState[winConditions[i][0]]== move &&
                boardState[winConditions[i][1]]== move &&
                boardState[winConditions[i][2]]== move){
                return true;
            }
        }
        return false;
     }

     //checks if Player or AI has won or not
        public boolean hasPlayerWon(){
        return checkWin(XMOVE);
     }
        public boolean hasAIWon(){
        return checkWin(OMOVE);
     }

     //public boolean function to check if the game is over
     public boolean isGameOver(){
        //loops through the Board to check if it is full or not
        boolean isBoardFull = true;
        for(int i = 0; i < boardState.length; i ++){
            if(boardState[i] == NOMOVE){
                isBoardFull = false;
                break;
            }
        }
        //game is over if any of these conditions have been met
        return isBoardFull || hasPlayerWon() || hasAIWon();
     }

     //defines a valid move as an index that contains "NOMOVE"
     public boolean isValidMove(int index){
        return getMoveAtIndex(index) == NOMOVE;
     }

     //function for setting AI Move
     public void setAiMove(int index){
         if (isValidMove(index)){
             boardState [index] = OMOVE;
         }
     }


}
