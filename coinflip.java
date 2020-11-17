/*
 *Coin Flip
 *Anna, Ziad, Hunter, William, Kevin
 */
import java.util.Scanner;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.InputMismatchException;

public class coinflip{

	private static int setRounds; //stores the number of rounds the user wants to play
	private static String userGuess; //the user's guess whether if it's heads or tails
	private static int userGuessAsInt;
	private static int userCount; //the amount wins the user has
	private static int programCount; //the amount of wins the computer has
	private static String computerChoice; //the correct answer of which side the coin lands on
	private static int numofSides = 1; //used to randomly determine which side the coins lands on
	//finding the side the coin lands on
	private static Random random = new Random();
	private static int computerguess = ThreadLocalRandom.current().nextInt(numofSides) +1;
	private static boolean hasWinner = false;
	private static int flipResult = 0;
	private static int userRoundScore = 0;
	private static int computerRoundScore = 0;






	//Scanner for input
	private static Scanner input = new Scanner(System.in);


	//establishing the computer's guess
	public static int flipResult(){
		flipResult = random.nextInt(2);
		return flipResult;
        }

	/**
	* method that will display the rules of the game
	* @return: void
	*/
   public static void displayGame(){
	    System.out.println("\t|---------------------------------------------------------------------------------------------------------|");
	    System.out.println("\t|                                        Welcome to Coin Flip                                             |");
	    System.out.println("\t|                                                                                                         |");
	    System.out.println("\t|                           Please read the description of the game here:                                 |");
	    System.out.println("\t|             The Coin Flip game will be played between two users (User and computer)                     |");
	    System.out.println("\t|                                                                                                         |");
	    System.out.println("\t|                  1-You will need to enter the number of rounds to start the game                        |");
	    System.out.println("\t|2- you will be asked to choose either Heads or Tails. Please Enter 'heads' for Heads or 'tails' for Tails|");
	    System.out.println("\t|                                                                                                         |");
	    System.out.println("\t|                                                                                                         |");
	    System.out.println("\t|3-                      In the end of the game we will announce the winner.                              |");
	    System.out.println("\t|---------------------------------------------------------------------------------------------------------|");
	    System.out.println();
	    System.out.println();
  }

  /**
  * Method to ask the user for their desired guess
  * @return void
  */
  public static String userguess(){
	boolean validInput = false;
	Scanner scanner =  new Scanner(System.in);
	while(!validInput){
    	System.out.println("Remember to type 'heads' for Heads and 'tails' for Tails");
        
    	userGuess = scanner.nextLine();		//Convert heads to = 1
        if(userGuess.equals("heads")){
			userGuessAsInt = 1;
			validInput = true;
		}
		else if(userGuess.equals("tails")){
			userGuessAsInt = 2;
			validInput = true;
		}
		else{
			System.out.println("Invalid input!");
		}

	}
	System.out.println("Your Guess: " + userGuess);

            return userGuess;
		}
      
  

  /**
  * Method to ask the user how many rounds they want to play
  * @return void
  */
  public static void rounds(){
	  boolean validInput = false;
	  System.out.println("Enter an odd number that is positive to represent the best out of number.");
	  while(!validInput){
	  
    
        
          setRounds = GetInput.numericInput();
            if(GetInput.isOdd(setRounds)){
                System.out.println("It must be odd. Try again");	//Input checking
			}
			else if(setRounds <= 0){
				System.out.println("input must be above 0!");
			}
			else{
				validInput = true;
			}
		}
            System.out.println("Best out of number: " + setRounds);
            
           
  }


  /**
  * Method that determines who is the winner of the game
  * @return void
  */
  public static void coinFlip(String guess, int rounds){
		int counter = setRounds;
		int result;
		while(counter != 0 && !hasWinner){
			result = flipResult();
			String userChoice = userguess();
		if(userChoice.equals("heads")){
			userGuessAsInt = 1;
		}
		else if(userChoice.equals("tails")){
			userGuessAsInt = 2;
		}
     		 if(userGuessAsInt == flipResult){			//Convert guess to integer for comparison
  				System.out.println("You won this round!");
  				userCount++;
					counter--;
  			}else{
  				System.out.println("You lost this round :(");
  				programCount++;
					counter--;

				}
				if(userCount == setRounds + 1 / 2){			//Checks for winner before last round
					Scoreboard.userTotalScore++;
					hasWinner = true;
				}
				else if(programCount == setRounds + 1 /2){
					Scoreboard.computerTotalScore++;
					hasWinner = true;
				}
				else if(counter == 0 && userGuessAsInt == flipResult){	//Checks if final round is the determinant round
					Scoreboard.userTotalScore++;
				}
				else if(counter == 0 && userGuessAsInt != flipResult){
					Scoreboard.computerTotalScore++;
				}
			scoreboard(userCount, programCount);		
		}


}
  /**
  * Method that prints the score and which player has won the game.
  * @return void
  */
  public static void scoreboard(int userCount, int programCount){
  		System.out.println("User's Score: " + userCount);
  		System.out.println("Computer's Score: " + programCount);
  		if(userCount > programCount){
  			System.out.println("Congrats! You won the game!");
			userRoundScore++;
  		}else{
  			System.out.println("Bummer! You lost. Try again next time.");
			computerRoundScore++;
  		}
  }

  /**
  * Method that tells the user thank you for playing the game
  * @return void
  */
  public static void printThankYou(){
    System.out.println();
    System.out.println();
    System.out.println("\t|-------------------------------------------------------------------------------------------|");
    System.out.println("\t|           Thank you for Playing the Coin Flip Game. I hope you enjoyed it :)              |");
    System.out.println("\t|                                                                                           |");
    System.out.println("\t|-------------------------------------------------------------------------------------------|");
  }
	public static void playGame(){
		userCount = 0;
		programCount = 0;
		hasWinner = false;
		displayGame();
		rounds();

		userguess();
		coinFlip(userGuess,setRounds);
		scoreboard(userCount, programCount);
		printThankYou();
	}


}
