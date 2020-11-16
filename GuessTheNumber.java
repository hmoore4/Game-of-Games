//This class is responsible for the Guess the Number game.
import java.util.Random;

public class GuessTheNumber {
    private static int rangeLow = 0;        //Range of numbers to guess
    private static int rangeHigh = 0;
    private static int target = 0;          //Number to guess
    private static int currentGuess = 0;
    private static int totalGuesses = 0;

    /*
     * Print the rules at the start of the game.
     */
    public static void printRules(){
        System.out.println("Choose two numbers to represent the range of numbers for which you will be guessing in. Next, choose a number to represent the number of guesses you get, this number must be less than half the range. Finally, enter your numeric guesses until either the number is guessed or you run out of guesses.");
        System.out.println("");
    }

    /*
     * This funciton is where users are asked to enter the range of numbers
     * It checks to make sure the higher limit is a larger integer than the lower limit
     */
    public static void enterRanges(){
        boolean isValidInput = false;
        while(!isValidInput){                       //Won't procede until input is correct
            System.out.println("Enter a high range to guess:");
            rangeHigh = GetInput.numericInput();

            System.out.println("Enter a low range to guess:");
            rangeLow = GetInput.numericInput();
            if(rangeHigh > rangeLow){               //Input checking
                isValidInput = true;
            }
            else
                System.out.println("The upper boundary must be larger than the lower boundary!");   //Error message
        }
    }

    /*
     * This function is where the user inputs how many guesses are allowed for the game.
     * It checks to make sure the amount of guess is positive and less than half the allowed guesses
     */
    public static void enterGuesses(){
        boolean isValidInput = false;
        System.out.println("Enter an amount of guesses. It must be below half the range of possible numbers:");
        while(!isValidInput){
            totalGuesses = GetInput.numericInput();         //This function from GetInput class automatically checks to see if it's not an integer
            if(totalGuesses <= Math.ceil((rangeHigh - rangeLow)/2.0) && totalGuesses > 0)       //This is valid input. Above 0 and below half the range.
                isValidInput = true;
            else if(totalGuesses >= (int)Math.ceil((rangeHigh - rangeLow)/2.0))                 //If the amount of guesses is positive but over half the range, throw error message.
                System.out.println("The amount of guesses must be below half the range of possible numbers!");
            else if(totalGuesses <= 0){
                System.out.println("The amount of guesses must be above 0!");       //If the amount of guesses is negative, throw error message.
            }
        }

    }

    /*
     * This funciton checks to see if the most recent guess is correct
     * Returns a boolean. True if the guess is correcet and false if it is not.
     */ 
    public static boolean isCorrect(int guess){
        if(guess == target)
            return true;
        else
            return false;
    }

    /*
     * This function is responsible for handling the actual guesses.
     * It loops for the amount of guesses entered previously
     */
    public static void guess(){
        System.out.println("Enter your guesses:");
        int counter = totalGuesses;
        while(counter != 0){
            currentGuess = GetInput.numericInput();
            if(isCorrect(currentGuess)){
                System.out.println("You win!");         //Correct guess
                break;
            }
            else if(!GetInput.isInRange(rangeLow, rangeHigh, currentGuess)){                    //Function from GetInput to check fi the number is in the range. If not, error
                System.out.println("Make sure you guess is in the range of valid numbers!");    
            }
            else{
                counter--;
                System.out.println("Incorrect! Try again. You have " + counter + " guesses remaining"); //Valid guess means decrement amount of guesses left
            }
        }
        if(counter == 0 && !isCorrect(currentGuess))
            System.out.println("You lose! The correct number was " + target + ".");
    }

    /*
     * This function generates the target number.
     * It can make a random number within the range.
     */
    public static int generateTarget(int high, int low){
        Random rand = new Random();
        target = rand.nextInt(high - low + 1) + low;    //This calculates the range of the numbers
        return target;
    }


    /*
     * This function is the "main" function of the class. It is called from PlayGame
     * It uses all of the other methods to actually play the game.
     */
    public static void playGame(){
        printRules();
        enterRanges();
        enterGuesses();
        generateTarget(rangeHigh, rangeLow);
        System.out.println("TARGET: " + target);
        guess();
    }
}