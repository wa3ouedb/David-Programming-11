import java.sql.SQLOutput;
import java.util.Random;
import java.util.Scanner;

// Rock paper scissors game. Follow the instructions printed to play.

public class Main {
    public static void main(String[] args) {
        // Variables used
        char computerChoice; // This shows the computer's choice
        char playerChoice; // This shows the Player's choice
        String playerInput; // This contains the player's input
        char validSelections[] = {'r', 'p', 's', 'x'}; // This limits the valid choices to 'r', 'p', 's', and 'x'
        Scanner scan = new Scanner(System.in); // Creates the scanner
        Random rand = new Random(); // Creates the random object
        int playerWins;
        int computerWins;
        playerWins = 0;
        computerWins = 0;

        // Game begins
        // Display game rules
        do {
        System.out.println();
        System.out.println("****************************************************************************************************");
        System.out.println("Choose rock, paper, or scissors. 'r' for rock, 'p' for paper, or 's' for scissors. Press 'x' to quit");
        // Gets player input
            playerInput = scan.nextLine();
            // Check if player's selection is valid
            if ((playerInput.length() != 1) || (!(new String(validSelections).contains(playerInput)))) {
                System.out.println("Invalid selection. Please play again.");
            }
            playerChoice = playerInput.charAt(0);
            // Computer randomly chooses either 'r', 'p', or 's'
            computerChoice = validSelections[rand.nextInt(3)];

            if (playerChoice == 'r') {
                // Conditions if player selects 'r'
                System.out.println("Player choice: rock");
                // Prints out the player's selection
                if (computerChoice == 'r') {
                    // If computer selects 'r'
                    System.out.println("Computer choice: rock");
                    System.out.print("Draw!");
                } else if (computerChoice == 's') {
                    // if computer selects 's'
                    System.out.println("Computer choice: scissors");
                    System.out.println("You win!");
                } else {
                    // if computer selects 'p'
                    System.out.println("Computer choice: paper");
                    System.out.println("You lose!");
                }
            }
            if (playerChoice == 'p') {
                // Conditions if player selects 'p'
                System.out.println("Player choice: paper");
                // Prints out player's selection
                if (computerChoice == 'p') {
                    // If computer selects 'p'
                    System.out.println("Computer choice: paper");
                    System.out.print("Draw!");

                } else if (computerChoice == 'r') {
                    // If computer selects 'r'
                    System.out.println("Computer choice: rock");
                    System.out.println("You win!");

                } else {
                    // If computer selects 's'
                    System.out.println("Computer choice: scissors");
                    System.out.println("You lose!");
                }
            }
            if (playerChoice == 's') {
                // Conditions if player selects 's'
                System.out.println("Player choice: scissors");
                if (computerChoice == 's') {
                    // If computer selects 's'
                    System.out.println("Computer choice: scissors");
                    System.out.print("Draw!");
                } else if (computerChoice == 'p') {
                    // If computer selects 'p'
                    System.out.println("Computer choice: paper");
                    System.out.println("You win!");
                } else {
                    // if computer selects 'r'
                    System.out.println("Computer choice: rock");
                    System.out.println("You lose!");
                }
            }

            if (playerChoice == 'x') {
                scan.close();
                System.out.println("thanks for playing");
            }
            System.out.println("\t");


            System.out.println("Player wins: " + 'playerWins');
            System.out.println("Computer wins: " + 'computerWins');

        } while (playerChoice != 'x');
    }
}

