import java.util.Scanner;
public class Main {
    public static void main(String args[]){
        Goal game = new Goal();

        //introduction
       System.out.println("Welcome to the ARENA!");
       System.out.println("Your task: shoot a goal! Choose the spot where the goalie can't reach!");
    
       while(game.totalScore()<3) {

       game.reset(); //returns a 3 by 5 grid
        System.out.print("Enter the row number:");
        Scanner x = new Scanner(System.in);
        int r = x.nextInt();
        System.out.print("\n" + "Enter the column number:");
        int c = x.nextInt();

        game.setGoalie(); //goalie position is placed randomly on the grid
        game.kick(r,c); //inputs client's position on the grid
        game.result(); //returns grid positions
        game.outcome(); //returns a random statement depending on the results 
        System.out.println("You have earned " + game.totalScore() + " points!"); //returns total score
       } 
      
       //if there are four modes...     easy / med / hard / abstract (1, 2, 3, 4)
       //medium would have increasing goalie positions by 1 //hard would be the user can't choose the same spot twice //abstract would be a changing goal size
    }
}
