package com.example.guilesson;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class Controller {
    //public controller fields

    public Label labelBalance;
    public TextField textfieldBet;
    public Button btnBegin;
    public Label labelDiceOne;
    public Button btnHigher;
    public Button btnLower;
    public Label labelOutcome;
    public int bet;
    public int currentBalance;

    public int diceOne;
    public int diceTwo;


    //controller constructor
    public Controller(){
        currentBalance = 1000;
        bet = 0;
    }


    //Button function for when player guesses "higher"
    public void playerInputHigher(ActionEvent actionEvent) {
        diceTwo = rollDice();
        String outcome = "Second dice: " + diceTwo;
        //condition where player is correct
        if (diceTwo > diceOne) {
            currentBalance += bet;
           outcome = outcome + " You Win!";
        }
        //condition where player guess is incorrect
        else {
            currentBalance -= bet;
            outcome = outcome + " You Lose";
        }
        labelOutcome.setText(outcome);
        labelBalance.setText("" + currentBalance);
        //disables both betting buttons
        btnLower.setDisable(true);
        btnHigher.setDisable(true);
        //re-enables begin button to play again
        btnBegin.setDisable(false);
    }


    //Button function for when player guesses "lower"
    public void playerInputLower(ActionEvent actionEvent) {
        diceTwo = rollDice();
        String outcome = "Second dice: " + diceTwo;
        //condition where player is correct
        if (diceTwo < diceOne) {
            currentBalance += bet;
            outcome = outcome + " You Win!";
        }
        //condition where player guess is incorrect
        else {
            currentBalance -= bet;
            outcome = outcome + " You Lose";
        }
        labelOutcome.setText(outcome);
        labelBalance.setText("" + currentBalance);
        //disables both betting buttons
        btnLower.setDisable(true);
        btnHigher.setDisable(true);
        //re-enables begin button to play again
        btnBegin.setDisable(false);
    }


    //Button function for when player pressed "Begin"
    public void playerInputBegin(ActionEvent actionEvent) {
        //recieves bet made by player
        bet = Integer.parseInt(textfieldBet.getText());
        //If player's bet is within their balance
        if  (bet <= currentBalance){
            btnBegin.setText("Begin");
            diceOne = rollDice();
            labelDiceOne.setText(""+ diceOne);
            //enables betting buttons & disables "Begin" button
            btnHigher.setDisable(false);
            btnLower.setDisable(false);
            btnBegin.setDisable(true);
        }
        else {
            btnBegin.setText("Bet is higher than balance");
        }
    }

    //selects random integer from 1 to 6
    private int rollDice() {
        return (int) ((Math.random() * 6)+1);
    }

}