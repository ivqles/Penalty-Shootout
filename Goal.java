public class Goal {
     // Instantiating Variables
    static char emptySpace = 'O';
    static char ball = 'B';
    static char goalie = 'G';
    static int countRows = 3;
    static int countColumns = 5;
    static int score = 0;
    public int playerPos = 0;
    public int goaliePos = 0;
    public static String levelString;
    public boolean win;

    String[] winDialogue = {"ex: you made a goal"}; // ADD MORE DIALOGUE LATER
    String[] loseDialogue = {"ex: you did not make a goal lol"}; // ADD MORE DIALOGUE LATER

    char[][] goalArray = new char[countRows][countColumns];
 
    // Constructing Goal / Game Board (3 x 5)
    public Goal() {
        for (int row = 0; row < countRows; row++) {
            for (int col = 0; col < countColumns; col++) {
                goalArray[row][col] = emptySpace;
            }
        }
    }
 
    public static void gameModes() {
        // System.out.println("Choose your game mode!");
        // System.out.println("EASY: it's easy. basic. what else would you expect.");
        // System.out.println("MEDIUM: ooh... looking for a challenge are you? Well, now the goalie can block an increasing amount of spaces per turn, muahaha.");
        // System.out.println("HARD: say good-bye to your previous choices! One click and there's no going back.");
        // System.out.println("ABSTRACT: ever wanted a changing goal? no? well here's one anyway.");
    }

    public static void setLevel(String l){
        // levelString = l.toUpperCase();
    }

    // toString Method for Proper String Output
    public String toString() {
        String goalArrayString = "";
        for (char[] row : goalArray) {
            for (char placeholder : row) {
                goalArrayString += placeholder + " ";
            }
            goalArrayString += "\n";
        }
        return goalArrayString;
    }
 
    // called during every round; sets randomized place for "K"
    public void setGoalie() {
        int col =  (int)(Math.random() * (countColumns - 1));
        int row =  (int)(Math.random() * (countRows - 1));  
        goalArray[row][col] = goalie;
        goaliePos = row * 3 + col * 5;
    }
 
    //sets the ball to position provided by the player
    public void kick(int row, int col) {
        goalArray[row][col] = ball;
        playerPos = row * 3 + col * 5;
          
    }

    public int totalScore(){
        if(goaliePos != playerPos){
            win = true;
            score++;
        }
        else {
            win = false;
        }
        return score;
    }
 
    public void Outcome() {
        String dialogueReaction;
        if (win) {
            int n = (int)(Math.random() * (winDialogue.length - 1));
            dialogueReaction = winDialogue[n];
        }
        else {
            int n = (int)(Math.random() * (loseDialogue.length - 1));
            dialogueReaction = loseDialogue[n];
        }
        System.out.println(dialogueReaction); //returns a random statement depending on the results 
        System.out.println("You have earned " + score + " points!"); //returns total score
    }
}
