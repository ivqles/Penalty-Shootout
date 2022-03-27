import java.util.Scanner;

public class Main {

    public static void main(String args[]){
        Scanner x = new Scanner(System.in);
        int roundNum = 0;
        // Introduction
        System.out.println("Welcome to the ARENA!");
        System.out.println("Your task is to shoot a goal! Choose the spot where the goalie can't reach! \n");
        System.out.println("Pick a spot carefully!\nLEGEND:\nX represents a catch from the goalie\nB represents where your ball lands\nG represents the goalie's position");
        Goal.gameModes();
        String mode = x.nextLine();
        while (mode.compareToIgnoreCase("EASY") != 0 && mode.compareToIgnoreCase("MEDIUM") != 0 && mode.compareToIgnoreCase("HARD") != 0 && mode.compareToIgnoreCase("ABSTRACT") != 0) { // Checks that inputted level is a real case
            System.out.print("This is not a valid game mode! Try Again!\nLevel: ");
            mode = x.nextLine();
        }
        Goal.setLevel(mode);
        

        int score = 0;
        while (score < 3) {
            Goal game = new Goal();
            roundNum++;
            System.out.println("ROUND " + roundNum);
            System.out.println(game); //returns a 3 by 5 grid
            System.out.print("Enter the row number: ");
            int r = x.nextInt() - 1;
            while (r < 0 || r > 2){
                System.out.print("That is not a valid number. Try again!\nEnter a row number: ");
                r = x.nextInt()-1;
            }
            System.out.print("\n" + "Enter the column number: ");
            int c = x.nextInt() - 1;
            while (c < 0 || c > 4){
                System.out.print("That is not a valid number. Try again!\nEnter a column number: ");
                c = x.nextInt() - 1;
            }
        
            game.setGoalie(roundNum); //goalie position is placed randomly on the grid
            game.kick(r,c); //inputs client's position on the grid
            System.out.println(game); // prints grid positions
            score = game.totalScore();
            game.Outcome(); // prints dialogue and score
            if (score != 3) {
                System.out.println("\nNext round!");
            }
        } 
        // MAKE + ADD "ENDGAME" METHOD HERE!
        System.out.println("Thanks for Playing!");
        x.close(); //closes Scanner

        //if we had more time: 
        //there would be four modes...     easy / med / hard / abstract (1, 2, 3, 4)
        //hard would be the user can't choose the same spot twice 
        //abstract would be a changing goal size
        //also would make a goalie/player graphic on the side
        //add more sound effects such as crowd cheering
    
    }
}
