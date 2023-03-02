//Controller Class

package com.example.tictactoe;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

import java.io.*;
import java.util.Random;

public class HelloController {
    //controller fields
    public TextField txtFldEnterUser;
    public Button btnSaveUser;
    public Button btnLoadUser;
    public Label lblPlayerName;
    public Label lblWins;
    public Label lblLosses;
    public Player player;
    public GridPane grid;
    public Label gameStateLabel;
    public Button btnStart;
    private Image xImage;

    private Image oImage;

    private Game game;

    private Random random;

    //function for clearing board
    public void clear(){
        game.resetGame();
        clearBoard();
        gameStateLabel.setText("");
    }

    //loads player data from Player file
    public void loadPlayerData(ActionEvent actionEvent) throws IOException {
        loadPlayerFile(new File("Player1.txt"));
        btnStart.setDisable(false);
        clear();
    }

    //function for loading player file and populating scoreboard with data
    public void loadPlayerFile(File f) throws IOException{
        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);
        String line;
        while ((line = br.readLine()) != null) {
            String playerParameters [] = line.split(",");
            this.player = new Player(playerParameters[0], Integer.parseInt(playerParameters[1]), Integer.parseInt(playerParameters[2]));
            populateScoreboard(this.player); //populates scoreboard with current player's data
        }
        br.close();
    }

    //function for populating scoreboard
    public void populateScoreboard (Player player){
        lblPlayerName.setText(player.getUsername());
        lblWins.setText("" + player.getWins());
        lblLosses.setText("" + player.getLosses());

    }

    //function for saving player data
    public void savePlayerData(ActionEvent actionEvent) throws IOException{
        if(this.player == null || !this.player.getUsername().equals(txtFldEnterUser.getText())) {
            //creates a new player with reset scores if username is null or new username is not the same as the current one
            this.player = new Player(txtFldEnterUser.getText(), 0, 0);
        }
        savePlayerFile(new File("Player1.txt"), player);
        populateScoreboard(player);
        btnStart.setDisable(false);
        btnLoadUser.setDisable(false);
        clear();
    }

    //function for saving the player file
    public void savePlayerFile (File f, Player player) throws IOException{
        FileWriter fw = new FileWriter(f);
        BufferedWriter Bw = new BufferedWriter(fw);
        Bw.write(player.toString());
        Bw.close();

    }

    //function for setting the "X" and "O" image/icon for the player or AI's move
    public void placeMoveOnBoard (int index, boolean isPlayerMove){
        ImageView imageView = (ImageView) grid.getChildren().get(index);
        if (isPlayerMove) {
            imageView.setImage(xImage);
        }
        else {
            imageView.setImage(oImage);
        }

    }

    //TicTacToe grid
    public void gridClicked(MouseEvent mouseEvent) throws IOException{
        Integer rowIndex = rowIndex(mouseEvent.getY());
        Integer columnIndex = columnIndex(mouseEvent.getX());
        //converts grid to 1D array representation and gets the index of the array using rowIndex and columnIndex
        int index = rowIndex*grid.getColumnCount() + columnIndex;
        if(!game.isValidMove(index)){ //returns the game if the index is not a valid move
            return;
        }

        game.setPlayerMove(index); //sets player move at the given index
        placeMoveOnBoard(index, true);
        //checks if player wins
        boolean hasPlayerWon = game.hasPlayerWon();
        if(hasPlayerWon){
            gameStateLabel.setText("player Has Won!");
            int wins = player.incrementWins();
            lblWins.setText("" + wins);
            grid.setDisable(true);
            savePlayerFile(new File("Player1.txt"), player);
            return;
        }

        //sets player move into the index of the array list for the game's state
        int aiBoardMoveIndex = game.AIMove();
        boolean hasAIWon = false;
        //makes sure the AI can move only when there is room on the board
        if (aiBoardMoveIndex != -1) {
            placeMoveOnBoard(aiBoardMoveIndex, false);
            hasAIWon = game.hasAIWon();
            if (hasAIWon){
                gameStateLabel.setText("AI has won!");
                int losses = player.incrementLosses();
                lblLosses.setText("" + losses);
                savePlayerFile(new File("Player1.txt"), player);
            }
        }
        //tie condition
        if(!hasPlayerWon && !hasAIWon && game.isGameOver()){
            gameStateLabel.setText("Tie!");
        }
        //disables grid after game
        if(game.isGameOver()){
            grid.setDisable(true);
        }
        //prevents board from being cleared mid-game
        btnStart.setDisable(false);
    }
    //gets row of mouse index
    public int rowIndex (double MouseY){
        return (int) (MouseY / (grid.getHeight() / grid.getRowCount()));
    }
    //gets column of mouse index
    public int columnIndex (double MouseX){
        return (int) (MouseX / (grid.getWidth() / grid.getColumnCount()));
    }
    public void gridPressed(MouseEvent mouseEvent) {
    }

    public void mouseClicked(MouseEvent mouseEvent) {
    }

    //HelloController constructor
    public HelloController (){
        xImage = new Image("file:Images/LetterX.png");
        oImage = new Image("file:Images/LetterO.png");
        game = new Game ();
        random = new Random();
        random.setSeed(System.currentTimeMillis());
    }

    //startButtonClicked function
    public void startButtonClicked(ActionEvent actionEvent) {
        btnStart.setDisable(true);
        grid.setDisable(false);
        game.resetGame();
        btnLoadUser.setDisable(true);
        clearBoard();
        //randomizes an integer to determine who goes first
        int firstMove = (int) random.nextInt() % 2;
        if (firstMove == 1){
            //ai goes first
            gameStateLabel.setText("AI goes first");
            int boardMoveIndex = game.AIMove();
            placeMoveOnBoard(boardMoveIndex, false);
        }
        else{
            //player goes first
            gameStateLabel.setText("Player goes first");
        }

    }

    //clear board function
    public void clearBoard(){
        int length = grid.getChildren().size();
        for(int i = 0; i < length; i ++){
           Node childNode = grid.getChildren().get(i);
           if(childNode instanceof ImageView ){
               ImageView emptyImage = (ImageView) childNode;
               emptyImage.setImage(null);
           }
        }
    }

    //disables certain buttons if keys are typed
    public void keyTyped(KeyEvent keyEvent) {
        if(txtFldEnterUser.getText().isEmpty()){
            btnSaveUser.setDisable(true);
            btnLoadUser.setDisable(false);
        }
        else {
            btnSaveUser.setDisable(false);
            btnLoadUser.setDisable(true);
            btnStart.setDisable(true);
            grid.setDisable(true);
        }
    }
}