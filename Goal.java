public class Goal {

    // Instantiating Variables
    static char emptySpace = 'O';
    static char ball = 'B';
    static char goalie = 'G';
    static int countRows = 3;
    static int countColumns = 5;
    char[][] goalArray = new char[countRows][countColumns];

    // Constructing Goal / Game Board (3 x 5)
    public Goal() {
        for (int row = 0; row < countRows; row++) {
            for (int col = 0; col < countColumns; col++) {
                goalArray[row][col] = emptySpace;
            }
        }
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
        int col =  (int)(Math.random()*(countColumns - 1));
        int row =  (int)(Math.random()*(countRows - 1));  
        goalArray[row][col] = goalie;
    }

    //sets the ball to position provided by the player
    public void kick(int row, int col) {
        goalArray[row][col] = ball;
         
    }

    public String getOutcome() {
        return "";
    }
}
