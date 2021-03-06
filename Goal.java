import java.io.File;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.awt.Graphics2D;
import javax.swing.JFrame;
import pkg.*;

public class Goal {
     // Instantiating Variables
    static char emptySpace = 'O';
    static char ball = 'B';
    static char goalie = 'G';
    static char caught = 'X';
    int gRow;
    int gCol;
    int bRow;
    int bCol;
    static int countRows = 3;
    static int countColumns = 5;
    static int score = 0;
    public int playerPos = 0;
    public int goaliePos = 0;
    public static String levelString;
    public boolean win;
    public Rectangle net = new Rectangle();
	public Ellipse[] positions = new Ellipse [15];
    public Text playerB;
    public Text goalieO;
    public Color positionsCol = new Color (196, 188, 185);


    String[] winDialogue = {"You made the goal! Your mom is very proud!", "The crowd in the stands cheer as you make the perfect kick!", "Congratulations! You made it!", "Nice! The goalie completely missed!", "Wow! That kick is so great that the scouts in the stands are writing down your number!"}; // ADD MORE DIALOGUE LATER
    String[] loseDialogue = {"A person in the stands is mad that the goalie blocked your goal! They flip a table in outburst. (╯°□°）╯︵ ┻━┻", "You missed! Try again once you get more practice in.", "Missed. That's Disappointing."}; // ADD MORE DIALOGUE LATER

    char[][] goalArray = new char[countRows][countColumns];
 
     // Constructing Goal / Game Board (3 x 5)
     public Goal() {
        String myPicture = "https://ak.picdn.net/shutterstock/videos/1024013435/thumb/1.jpg";
		Picture test = new Picture();
		test.load(myPicture);
		test.draw();
		test.grow(250,250);
        test.translate(100,0);
		net = new Rectangle (230,140,620,380);
		net.setColor(Color.WHITE);
		net.fill();
         for (int row = 0; row < countRows; row++) {
             for (int col = 0; col < countColumns; col++) {
                positions[col] = new Ellipse (250+col*120,160+row*120,100,100);
				positions[col].setColor(positionsCol);
				positions[col].fill();
                 goalArray[row][col] = emptySpace;
             }
         }
     }
 
     public static void gameModes() {
        System.out.println("Choose your game mode!");
        System.out.println("EASY: it's easy. basic. what else would you expect.");
        System.out.println("MEDIUM: ooh... looking for a challenge are you? Well, now the goalie can block an increasing amount of spaces per turn, muahaha.");
        // System.out.println("HARD: say good-bye to your previous choices! One click and there's no going back.");
        // System.out.println("ABSTRACT: ever wanted a changing goal? no? well here's one anyway.");

        System.out.print("Level: ");
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

    public void setGoalie(int roundNum) {
        if (levelString.equals("EASY")) {
            gCol =  (int)(Math.random() * (countColumns - 1));
            gRow =  (int)(Math.random() * (countRows - 1));  
            goalArray[gRow][gCol] = goalie;
        }
        else if (levelString.equals("MEDIUM")) {
            for (int i = 1; i <= roundNum && i <= 15; i++){
                gCol =  (int)(Math.random() * (countColumns - 1));
                gRow =  (int)(Math.random() * (countRows - 1));  
                while (goalArray[gRow][gCol] != emptySpace) {
                    gCol =  (int)(Math.random() * (countColumns - 1));
                    gRow =  (int)(Math.random() * (countRows - 1));      
                }
                goalArray[gRow][gCol] = goalie;
                goalieO = new Text (295+gCol*120,195+gRow*120,"O");
                goalieO.draw();
                goalieO.grow(33.0,50.0);
            }
        }

    }
 
    //sets the ball to position provided by the player
    public void kick(int row, int col) {
        bRow = row;
        bCol = col;
        playerB = new Text (295+col*120,195+row*120,"B");
        playerB.draw();
        playerB.grow(33.0,50.0);
        if (goalArray[row][col] == emptySpace) {
            goalArray[row][col] = ball;
        }
        else {
            goalArray[row][col] = caught;
        }
    }

     public static void setLevel(String l){
        levelString = l.toUpperCase();
        // switch (levelString) {
        //     case "EASY":
        //         break;
        //     case "MEDIUM":
        //         break;
        //     case "HARD":
        //         break;
        //     case "ABSTRACT":
        //         break;
        // }
    }

     static void PlayGoalSound(File sound) {

        try {
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(sound));
            clip.start();

            Thread.sleep(clip.getMicrosecondLength()/1000);
        } catch (Exception e) {
            System.out.println("failed to play audio");
        }

     }
    public int totalScore(){
        if(goalArray[bRow][bCol] == ball){
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
        File goalSound  = new File("goalSound.WAV");
        if (win) {
            int n = (int)(Math.random() * (winDialogue.length - 1));
            dialogueReaction = winDialogue[n];
            PlayGoalSound(goalSound);
        }
        else {
            int n = (int)(Math.random() * (loseDialogue.length - 1));
            dialogueReaction = loseDialogue[n];
        }

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 5; col++) {
               positions[col] = new Ellipse (250+col*120,160+row*120,100,100);
               positions[col].setColor(positionsCol);
               positions[col].fill();
                goalArray[row][col] = emptySpace;
            }
        }

        System.out.println(dialogueReaction); //returns a random statement depending on the results 
        System.out.println("You have earned " + score + " points!"); //returns total score
    }
}
