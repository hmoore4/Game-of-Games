
/**
 * Write a description of class Thimble here.
 *
 * @author Kevin Klotz
 * @version (a version number or a date)
 */
import java.util.Random;
import java.util.Scanner;
import java.util.InputMismatchException;
public class Thimble 
{
    // instance variables - replace the example below with your own
    static Scanner userInput = new Scanner(System.in);
    static Scanner secUserInput = new Scanner(System.in);
    static Scoreboard score = new Scoreboard();
    private static int bestOutNum;
    private static int hiderHand;
    private static int guessHand;
    private static int guesserScore;
    private static int hiderScore; 

    /**
     * Constructor for objects of class Thimble
     */
    public Thimble()
    {
        // initialise instance variables
        guesserScore = 0;
        hiderScore = 0;
        bestOutNum = 0;
    }

    /**
     * Print out the rules of the find the Thimble game
     *
     */
    public static void rules()
    {
        System.out.println("This game will be played in a 'best out of' fashion.");
        System.out.println("First enter an odd number to represent the maximum number of games to be played.");
        System.out.println("To play a single game, guess which hand your opponent is holding the thimble.");
        System.out.println("If you guess correctly you win the game, if you guess incorrectly you lose.");
    }

    /**
     * Printing an error message that can be used for all incorrect user inputs
     *
     */
    public static void guesserError(){
        System.out.println("Error: Invalid submission. Please reread directions.");
    }

    /**
     * Getting the user to input the “best out of number” to know how many rounds the game will go for
     *
     */
    public static void setBestOutNum(){
        do{
            System.out.println("Enter an odd number that is positive to represent the 'best out of number'.");
            try{
                bestOutNum = userInput.nextInt();
                if(bestOutNum % 2 == 0){
                    throw new InputMismatchException();
                }
                System.out.println("Best out of number: " + bestOutNum);
            }
            catch(InputMismatchException e){
                guesserError();
                userInput.next();
                System.out.println("Best out of number error: " + bestOutNum);
            }
        } while(bestOutNum % 2 != 1);
    }

    /**
     * This method will decide which hand the computer is hiding the thimble in and set the hiderHand variable
     *
     */
    public static void setHiderHand(){
        Random rand = new Random();
        //generate random values from 0-1
        hiderHand = rand.nextInt(2);
        hiderHand = hiderHand + 1; //updating the value of hiderHand so that it is either 1 or 2
        System.out.println("cpu hand: " + hiderHand);
    }

    /**
     * This method will accept the user input and set the guessHand variable
     *
     */
    public static void setGuess(){
        do{
            System.out.println("Please enter 1 to guess the left hand or 2 to guess the right hand.");
            try{
                guessHand = secUserInput.nextInt();
                if(guessHand != 1 && guessHand != 2){
                    guesserError();
                    setGuess();
                }
                System.out.println("Your guess: " + guessHand);
            }
            catch(InputMismatchException e){
                guesserError();
                secUserInput.next();
            }
        }while(guessHand == 0);
    }

    /**
     * this method is meant to find out if the user correctly guessed the thimble.
     *
     * @param  int guessHand, this variable is representative of the hand the user is guessing
     * @param  int hiderHand, this variable is representative of the hand the cpu is hiding the thimble in
     * @return    Boolean, if the variables are equal this method will return true, otherwise it will return false
     */
    public static boolean compareHand(int guessHand,int hiderHand){
        if(guessHand == hiderHand){
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * this method will update the score of either guesserScore or hiderScore depending on if the boolean is true or false. 
     *
     * @param  Boolean n, this will be the boolean from compareHand()
     */
    public static void updateScore(boolean n){
        if( n ==true){
            guesserScore++;
        }
        else{
            hiderScore++;
        }
    }

    /**
     * To identify if find the thimble is over based off the user’s score
     *
     * @param  guesserScore  this will be the score that the user has
     * @return    Boolean, this will return true if the guesserScore has reached the parameters of the bestOutNum

     */
    public static boolean winnerGuesser(int guesserScore){
        if(guesserScore == ((bestOutNum+1)/2)){
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * To identify if find the thimble is over based off the cpu’s score
     *
     * @param  hiderScore  this will be the score that the cpu has
     * @return Boolean, this will return true if the hiderScore has reached the parameters of the bestOutNum
     */
    public static boolean winnerHider(int hiderScore){
        if(hiderScore == ((bestOutNum+1)/2)){
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * This method is a compolation of all the methods properly arranged so that the game can be quickly implemented
     *
     */
    public static void gameThimble(){
        rules();
        setBestOutNum();
        while(winnerGuesser(guesserScore) != true && winnerHider(hiderScore) != true){
            setHiderHand();
            setGuess();
            updateScore(compareHand(guessHand, hiderHand));
            winnerGuesser(guesserScore);
            winnerHider(hiderScore);
            System.out.println("FIND THE THIMBLE: user score: " + guesserScore + "  cpu score: " + hiderScore);
        }
        if(winnerGuesser(guesserScore) == true){
            System.out.println("You won!");
            score.userTotalScore++;
        }
        else{
            System.out.println("The Computer won");
            score.computerTotalScore++;
        }
        score.printScoreboard();
    }
}
