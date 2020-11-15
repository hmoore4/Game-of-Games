import java.util.Random;
public class GuessTheNumber {
    private static int rangeLow = 0;
    private static int rangeHigh = 0;
    private static int target = 0;
    private static int currentGuess = 0;
    private static int remainingGuesses = 0;
    private static int totalGuesses = 0;

    public static void printRules(){
        System.out.println("Choose two numbers to represent the range of numbers for which you will be guessing in. Next, choose a number to represent the number of guesses you get, this number must be less than half the range. Finally, enter your numeric guesses until either the number is guessed or you run out of guesses.");
        System.out.println("");
    }

    public static void enterRanges(){
        System.out.println("Enter a high range to guess:");
        rangeHigh = GetInput.numericInput();

        System.out.println("Enter a low range to guess:");
        rangeLow = GetInput.numericInput();
    }

    public static void enterGuesses(){
        System.out.println("Enter an amount of guesses. It must be below half the range of possible numbers:");
        totalGuesses = GetInput.numericInput();

    }
    public static boolean hasGuesses(int guesses){
        if(guesses == totalGuesses)
            return false;
        else
            return true;
    }

    public static boolean isCorrect(int guess){
        if(guess == target)
            return true;
        else
            return false;
    }

    public static void guess(){
        System.out.println("Enter your guesses:");
        for(int i = 0; i < totalGuesses; i++){
            currentGuess = GetInput.numericInput();
            if(isCorrect(currentGuess)){
                System.out.print("You win!");
                break;
            }
            else{
                System.out.println("Incorrect! Try again");
            }
        }
        System.out.print("You lose!");
    }

    public static int generateTarget(int high, int low){
        Random rand = new Random();
        target = rand.nextInt(high - low + 1) + low;
        return target;

    }



    public static void playGame(){
        printRules();
        enterRanges();
        enterGuesses();
        generateTarget(rangeHigh, rangeLow);
        System.out.println(target);
        guess();

    }
}
