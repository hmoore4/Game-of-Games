import java.util.Random;

public class FindTheRedThread {
    private static final int numberOfThreads = 20;    
    private static int[] remainingThreads = new int[20];        //Threads are represented in an array of integers.
    private static boolean validInput = false;

    private static int redThread = 0;
    private static boolean userTurn = true;
    public static boolean hasWinner = false;

    /*
     * Print rules at the start of the game
     */
    public static void printRules(){
        System.out.println("Place 20 threads in a box, choose a number 1 - 10 inclusive to represent thread pulls per-turn. While alternating turns, select previously declared number of threads to be pulled by using a corresponding number(s) 1-20. Winner is declared once the red thread is found.");
        System.out.println("");
    }

    /*
     * This function sets up the thread array
     */
    public static void setThreadArray(){
        for(int i = 1 ; i < numberOfThreads + 1; i++){
            remainingThreads[i-1] = i;
        }
    }

    /*
     * This function prints all of the threads that are remaining.
     */
    public static void printThreads(){
        for(int i = 1 ; i < numberOfThreads + 1; i++){
            if(remainingThreads[i-1] != 0){         //Value of index of thread array is changed to 0 when guessed. So if it is 0, it has been guess and should not be printed
                System.out.print(i + "   ");
            }
        }
        System.out.print("\n");
    }

    /*
     * This function randomly picks a thread to be red from 1 to the amount of threads (20 in this game)
     */
    public static void chooseRedThread(int numberOfThreads){
        Random rand = new Random();
        redThread = rand.nextInt(numberOfThreads) + 1;
        System.out.println("   " + redThread);
    }

    /*
     * This function is what allows the computer to randomly guess the thread. 
     * param: threadsPerTurn this param is to tell the function how many threads it should take each turn
     */
    public static void computerGuessThreads(int threadsPerTurn){
        userTurn = false;
        int counter = threadsPerTurn;
        while(counter != 0){
            Random rand = new Random();
            int guessedThread = rand.nextInt(numberOfThreads) + 1;          //Generate a random thread to guess
            if(checkGuess(guessedThread)){
                System.out.println("The computer guessed thread " + guessedThread + ". That is the red thread!");       //Correct guess
                break;
            }
            else if(remainingThreads[guessedThread-1] == 0){        //If it guesses a number that has been chosen, just repeat.
                
            }
            else{
                System.out.println("The computer guessed thread " + guessedThread + ".");   //If it guesses a number that has not been chose
                remainingThreads[guessedThread-1] = 0;                                      //Subtract a guess and set that index to 0 in the thread array
                counter--;
            }
        }
        System.out.println("The computer didn't guess it! Your turn! Select more threads!");
    }

    /*
     * This function is used when the user is guessing. 
     * param: threadsPerTurn has the same function as the previous function. Keeps track of total threads to guess per turn
     */
    public static void userGuessThreads(int threadsPerTurn){
        userTurn = true;
        int counter = threadsPerTurn;
        int guessedThread = 0;

        while(counter != 0){
            System.out.println("Please select a thread to choose. You have " +  counter + " guesses left.");

           guessedThread = GetInput.numericInput();     //This function automatically checks to make sure it is an int. Throws error otherwise.
           if(GetInput.isInRange(1, numberOfThreads, guessedThread)){   //Checks if thread guessed is between 1-20
                if(checkGuess(guessedThread)){      //If correct
                    break;
                }
                else if(remainingThreads[guessedThread-1] == 0){
                    System.out.print("Please choose a thread that hasn't been selected yet.");      //If the thread was already chosen
                }
                else{
                    remainingThreads[guessedThread-1] = 0;      //If first time thread is chosen
                    counter--;
                }
            }
            else{
                continue;
            }
        }
        if(counter == 0 && !checkGuess(guessedThread)){
            System.out.println("Sorry you ran out of guesses! It's the computer's turn now.");  //End of turn
        }
    }

    /*
     * This function checks to see if the guess is correct.
     * param guess: the current thread # that was guessed
     * return boolean: if correct guess, return true. Return false otherwise
     */
    public static boolean checkGuess(int guess){
        if(guess == redThread){
            System.out.println("Correct guess! Thread " + redThread + " is the red thread!");
            updateScoreboard(); //Update scoreboard if the game is won
            hasWinner = true;
            return true;
        }
        else{
            return false;
        }
    }

    public static void updateScoreboard(){
        if(userTurn){
            Scoreboard.userFindTheRedThreadScore++;
            Scoreboard.userTotalScore++;
        }
        else if (!userTurn){
            Scoreboard.computerFindTheRedThreadScore++;
            Scoreboard.computerTotalScore++;
        }

    }


    /*
     * This function is the "main" function of the class. It is called from PlayGame
     * It uses all of the other methods to actually play the game.
     */
    public static void playGame(){
        validInput = false;
        hasWinner = false;
        int userInput = 0;
        printRules();
        System.out.println("Enter a positive number less than or equal to 10 to represent number of threads taken per turn");

        while(!validInput){
            try{
            userInput = GetInput.numericInput();
            if(userInput >= 1 && userInput <= 10)
                validInput = true;
            else
                 System.out.println("The input must be between 1-10.");
            }
            catch(Exception inputMismatchException){
                System.out.println("The input must be an integer! ");
            }
        }
        setThreadArray();
        chooseRedThread(20);
        while(hasWinner == false){      //This keeps the turns switching until the red thread is found
            printThreads();
            userGuessThreads(userInput);
            if(!hasWinner){
                computerGuessThreads(userInput);
            }
            if(hasWinner)
                hasWinner = true;

        //scanner.close();
        }
    }
}