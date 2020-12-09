package io.emma;

import java.util.Random;
import java.util.Scanner;
import static java.lang.Integer.parseInt;

public class Main {

    // Variables
    static int playerOne;
    static int playerTwo;
    static String playerOneName;
    static String playerTwoName;

    // Method for converting text input to numbers
    static int inputConverter(Scanner reader) {
        String stringAnswer = reader.nextLine();
        int numAnswer = 0;
        if(stringAnswer.equals("sten")) {
            numAnswer = 1;
        }
        else if(stringAnswer.equals("sax")) {
            numAnswer = 2;
        }
        else if(stringAnswer.equals("påse")) {
            numAnswer = 3;
        }
        else {
            numAnswer = parseInt(stringAnswer);
        }
        return numAnswer;
    }

    // Method for randomizing and printing a response for the AI opponent
    static void computerAnswer() {
        playerTwoName = "Datorn";
        Random random = new Random();
        playerTwo = random.nextInt(3) + 1;

        if(playerTwo == 1) {
            System.out.println(playerTwoName + ": sten");
        }
        else if(playerTwo == 2) {
            System.out.println(playerTwoName + ": sax");
        }
        else {
            System.out.println(playerTwoName + ": påse");
        }
    }

    // Method for printing who won the game
    static void gameReviewer() {
        if(playerOne == 1) {
            if (playerTwo == 1) {
                System.out.println("Det blev oavgjort");
            }
            else if(playerTwo == 2) {
                System.out.println(playerOneName + " vann!");
            }
            else if(playerTwo == 3) {
                System.out.println(playerTwoName + " vann!");
            }
            else {
                System.out.println("Du skrev nog något konstigt, börja om");
            }
        }

        else if(playerOne == 2) {
            if (playerTwo == 1) {
                System.out.println(playerTwoName + " vann!");
            }
            else if(playerTwo == 2) {
                System.out.println("Det blev oavgjort");
            }
            else if(playerTwo == 3) {
                System.out.println(playerOneName + " vann!");
            }
            else {
                System.out.println("Du skrev nog något konstigt, börja om");
            }
        }

        else if(playerOne == 3) {
            if (playerTwo == 1) {
                System.out.println(playerOneName + " vann!");
            }
            else if(playerTwo == 2) {
                System.out.println(playerTwoName + " vann!");
            }
            else if(playerTwo == 3) {
                System.out.println("Det blev oavgjort");
            }
            else {
                System.out.println("Du skrev nog något konstigt, börja om");
            }
        }
        else {
            System.out.println("Du skrev nog något konstigt, börja om");
        }
    }


    public static void main(String[] args) {

        Scanner reader = new Scanner(System.in);

        // Game instructions and set up
        System.out.println("Välkommen till spelet Sten, Sax, Påse");
        System.out.print("Välj singel player(s) eller multi player(m): ");
        String gameSelection = reader.nextLine();

        // Single player game code
        if(gameSelection.equals("s")) {
            System.out.println("Ditt namn:");
            playerOneName = reader.nextLine();

            System.out.println("Välj ditt alternativ genom att skriva sten, sax eller påse");
            System.out.println("du kan också skriva 1, 2 eller 3 där 1 motsvarar sten osv.");

            System.out.print(playerOneName + ": ");
            playerOne = inputConverter(reader);
            computerAnswer();
            gameReviewer();
        }

        // Multi player (AI) game code
        else if(gameSelection.equals("m")) {
            System.out.println("Ditt namn:");
            playerOneName = reader.nextLine();
            System.out.println("Din kompis namn:");
            playerTwoName = reader.nextLine();

            System.out.println("Välj alternativ genom att skriva sten, sax eller påse");
            System.out.println("ni kan också skriva 1, 2 eller 3 där 1 motsvarar sten osv.");

            System.out.println(playerOneName + ": ");
            playerOne = inputConverter(reader);
            System.out.println(playerTwoName + ": ");
            playerTwo = inputConverter(reader);
            gameReviewer();
        }
        reader.close();
    }
}
