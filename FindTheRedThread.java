import java.util.Random;
import java.util.Scanner;
public class FindTheRedThread {
    private static final int numberOfThreads = 20;
    private static final int numberOfRedThreads = 1;
    private static int[] remainingThreads = new int[20];
    private static boolean validInput = false;

    private static int redThread = 0;
    private static boolean userTurn = true;
    public static boolean hasWinner = false;

    public static void setThreadArray(){
        for(int i = 1 ; i < numberOfThreads + 1; i++){
            remainingThreads[i-1] = i;

        }
    }
    public static void printThreads(){
        for(int i = 1 ; i < numberOfThreads + 1; i++){
            if(remainingThreads[i-1] != 0){
                System.out.print(i + "   ");

            }
        }
        System.out.print("\n");
    }

    public static void chooseRedThread(int numberOfThreads){
        Random rand = new Random();
        redThread = rand.nextInt(numberOfThreads) + 1;
        System.out.println("   " + redThread);
    }

    public static void computerGuessThreads(int threadsPerTurn){
        int counter = threadsPerTurn;
        while(counter != 0){
            Random rand = new Random();
            int guessedThread = rand.nextInt(numberOfThreads) + 1;
            if(checkGuess(guessedThread)){
                System.out.println("The computer guessed thread " + guessedThread + ". That is the red thread!");
                break;
            }
            else if(remainingThreads[guessedThread-1] == 0){
                
            }
            else{
                System.out.println("The computer guessed thread " + guessedThread + ".");
                remainingThreads[guessedThread-1] = 0;
                counter--;
            }
        }
        userTurn = !userTurn;
    }

    public static void userGuessThreads(int threadsPerTurn){
        int counter = threadsPerTurn;
        int guessedThread = GetInput.numericInput();

        while(counter != 0){
            System.out.println("Please select a thread to choose. You have " +  counter + " guesses left.");

           guessedThread = GetInput.numericInput();
           //if(GetInput.isInRange(1, numberOfThreads, guessedThread)){
                if(checkGuess(guessedThread)){
                    break;
                }
                else if(remainingThreads[guessedThread-1] == 0){
                    System.out.print("Please choose a thread that hasn't been selected yet.");
                }
                else{
                    remainingThreads[guessedThread-1] = 0;
                    counter--;
                }
           // }
        }
        System.out.println("Sorry you ran out of guesses! It's the computer's turn now.");
        
    }

    public static boolean checkGuess(int guess){

        if(guess == redThread){
            System.out.print("WINNER");
            updateScoreboard();
            hasWinner = true;
            return true;
        }
        else{
            //updateScoreboard();
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

    public static void printRules(){
        System.out.println("Place 20 threads in a box, choose a number 1 - 10 inclusive to represent thread pulls per-turn. While alternating turns, select previously declared number of threads to be pulled by using a corresponding number(s) 1-20. Winner is declared once the red thread is found.");
        System.out.println("");
    }

    public static void playGame(){
        int userInput = 0;
        printRules();
        System.out.println("Enter a positive number less than or equal to 10 to represent number of threads taken per turn");

        while(!validInput){
            try{
            Scanner scanner = new Scanner(System.in);
            userInput = scanner.nextInt();//Integer.parseInt(scanner.nextLine());
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
        while(hasWinner == false){
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
