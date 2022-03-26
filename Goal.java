public class Goal {

    // Instantiating Variables
    static char emptySpace = 'O';
    static char ball = 'B';
    static char Keeper = 'K';
    static int CountofRows = 3;
    static int CountofColumns = 5;
    char[][] goalArray = new char[CountofRows][CountofColumns];

    // Constructing Goal / Game Board (3 x 5)
    public Goal() {
        for (int row = 0; row < goalArray.length; row++) {

            for (int col = 0; col < goalArray[0].length; col++) {
                goalArray[row][col] = emptySpace;
            }
        }
    }

    // toString Method for Proper String Output
    public String toString() {
        return "";
    }

    // called during every round; sets randomized place for "K"
    public void setGoalie() {
        
        int col =  (int)(Math.random()*(CountofColumns));
        int row =  (int)(Math.random()*(CountofColumns));  
        goalArray[row][col] = Keeper;
    }

    //sets the ball to position provided by the player
    public void kick(int row, int col) {
        goalArray[row][col] = ball;
         
    }

    public String getOutcome() {
        return "";
    }
}
