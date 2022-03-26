import java.util.Scanner;
public class Main {

    public static void main(String args[]){
        Scanner x = new Scanner(System.in);

        //introduction
        System.out.println("Welcome to the ARENA!");
        System.out.println("Your task: shoot a goal! Choose the spot where the goalie can't reach!");

        
        int totalScore = 0;
        while(totalScore < 3) {
            Goal game = new Goal();
            System.out.println(game); //returns a 3 by 5 grid
            System.out.print("Enter the row number:");
            int r = x.nextInt() - 1;
            // MAKE IF STATEMENT TO MAKE SURE ROW AND COL ARE WITHIN BOUNDS, ELSE RETURN "try again?"
            System.out.print("\n" + "Enter the column number:");
            int c = x.nextInt() - 1;
            // MAKE IF STATEMENT TO MAKE SURE ROW AND COL ARE WITHIN BOUNDS, ELSE RETURN "try again?"

        

            game.setGoalie(); //goalie position is placed randomly on the grid
            game.kick(r,c); //inputs client's position on the grid
            System.out.println(game); //returns grid positions
            game.getOutcome(); //returns a random statement depending on the results 
            System.out.println("You have earned " + totalScore + " points!"); //returns total score
            if (totalScore != 3) {
                System.out.println("\nTry Again!");
            }
        } 
       x.close(); //closes Scanner
      
       //if there are four modes...     easy / med / hard / abstract (1, 2, 3, 4)
       //medium would have increasing goalie positions by 1 //hard would be the user can't choose the same spot twice //abstract would be a changing goal size
    }
}
