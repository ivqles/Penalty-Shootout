import java.util.Scanner;

public class Main {
    public static void main(String args[]){
        Scanner x = new Scanner(System.in);
        Goal game = new Goal();

        //introduction
        System.out.println("Welcome to the ARENA!");
        System.out.println("Your task: shoot a goal! Choose the spot where the goalie can't reach! \n");
        game.introduction();
        game.setLevel(x.nextInt());
        int score = game.totalScore();

        while(score < 3) {
            System.out.println(game); //returns a 3 by 5 grid
            System.out.print("Enter the row number:");
            int r = x.nextInt() - 1;
                while(r<0 || r>2){
                    System.out.println("That is not a valid number. Try again!");
                    r = x.nextInt()-1;
                }
            System.out.print("\n" + "Enter the column number:");
            int c = x.nextInt() - 1;
                while(c<0 || c>4){
                    System.out.println("That is not a valid number. Try again!");
                    c = x.nextInt();
                }
        
            game.setGoalie(); //goalie position is placed randomly on the grid
            game.kick(r,c); //inputs client's position on the grid
            System.out.println(game); //returns grid positions
            game.getOutcome(); //returns a random statement depending on the results 
            score = game.totalScore();
            System.out.println("You have earned " + score + " points!"); //returns total score
            System.out.println("\n Next round!");
        } 
       x.close(); //closes Scanner

       //if there are four modes...     easy / med / hard / abstract (1, 2, 3, 4)
       //medium would have increasing goalie positions by 1 //hard would be the user can't choose the same spot twice //abstract would be a changing goal size
       /*
       Goal game2 = new Goal();
       System.out.println("Choose your mode:" + game2.introduction()); //return all the modes and their descriptions
       Scanner i =new Scanner(System.in);
       int diff = i.readInt();
       game2.setLevel(diff);
       */
    
    }
}
