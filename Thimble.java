
/**
 * Write a description of class Thimble here.
 *
 * @author Kevin Klotz
 * @version (a version number or a date)
 */
import java.util.Random;
import java.util.Scanner;
public class Thimble
{
    // instance variables - replace the example below with your own
    Scanner userInput = new Scanner(System.in);
    private int bestOutNum;
    private int hiderHand;
    private int guessHand;
    private int guesserScore;
    private int hiderScore; 
    
    /**
     * Constructor for objects of class Thimble
     */
    public Thimble()
    {
        // initialise instance variables
        guesserScore = 0;
        hiderScore = 0;
    }
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void rules()
    {
        System.out.println("This game will be played in a 'best out of' fashion.");
        System.out.println("First enter an odd number to represent the maximum number of games to be played.");
        System.out.println("To play a single game, guess which hand your opponent is holding the thimble.");
        System.out.println("If you guess correctly you win the game, if you guess incorrectly you lose.");
    }
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void guesserError(){
        System.out.println("Error: Invalid submission. Please reread directions.");
    }
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void setBestOutNum(){
        System.out.println("Enter an odd number that is positive to represent the 'best out of number'.");
        bestOutNum = userInput.nextInt();
        if(bestOutNum % 2 == 0){
            guesserError();
            setBestOutNum();
        }
        System.out.println("Best out of number: " + bestOutNum);
    }
     /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void setHiderHand(){
        Random rand = new Random();
        //generate random values from 0-1
        hiderHand = rand.nextInt(2);
        hiderHand = hiderHand + 1; //updating the value of hiderHand so that it is either 1 or 2
        System.out.println("cpu hand: " + hiderHand);
    }
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void setGuess(){
        System.out.println("Please enter 1 to guess the left hand or 2 to guess the right hand.");
        guessHand = userInput.nextInt();
        if(guessHand != 1 && guessHand != 2){
            guesserError();
            setGuess();
        }
        System.out.println("Your guess: " + guessHand);
    }
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public boolean compareHand(int guessHand,int hiderHand){
        if(guessHand == hiderHand){
            return true;
        }
        else{
            return false;
        }
    }
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void updateScore(boolean n){
        if( n ==true){
            guesserScore++;
        }
        else{
            hiderScore++;
        }
    }
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public boolean winnerGuesser(int guesserScore){
        if(guesserScore == ((bestOutNum+1)/2)){
            return true;
        }
        else{
            return false;
        }
    }
     /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public boolean winnerHider(int hiderScore){
         if(hiderScore == ((bestOutNum+1)/2)){
            return true;
        }
        else{
            return false;
        }
    }
     /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void gameThimble(){
        rules();
        setBestOutNum();
        while(winnerGuesser(guesserScore) != true && winnerHider(hiderScore) != true){
            setHiderHand();
            setGuess();
            updateScore(compareHand(guessHand, hiderHand));
            winnerGuesser(guesserScore);
            winnerHider(hiderScore);
        }
        System.out.println("user score: " + guesserScore + "  cpu score: " + hiderScore);
    }
}
