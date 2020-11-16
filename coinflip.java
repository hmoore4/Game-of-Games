/*
 *Coin Flip
 *Anna, Ziad, Hunter, William, Kevin
 */




import java.util.Scanner;
import java.util.*;

public class CoinFlip{

	private int setRounds; //stores the number of rounds the user wants to play
	private String userGuess; //the user's guess whether if it's heads or tails
	private int userCount; //the amount wins the user has
	private int programCount; //the amount of wins the computer has
	private String computerChoice; //the correct answer of which side the coin lands on
	private int numofSides = 1; //used to randomly determine which side the coins lands on

	//finding the side the coin lands on
	Random random = new Random();
	int computerguess = random.nextInt(numofSides) + 1;

	//Scanner for input 
	static Scanner input = new Scanner(System.in);

	
	//establishing the computer's guess
	public static void compGuess(computerguess){
   	   if(computerguess == 1){
      	     computerchoice = "heads";
           }else{
            computerchoice = "tails";
           }
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
  public static void userguess(){
  		System.out.print("Enter your Guess: ");
		userGuess = input.nextLine(); 
		System.out.println();
  }
  
  /**
  * Method to ask the user how many rounds they want to play
  * @return void
  */
  public static void rounds(int rounds){
  		System.out.print("Enter the amount of rounds you want to play: ");
  		setRounds = input.nextInt();
  		Systm.out.println();
  }
  	
  
  /**
  * Method that determines who is the winner of the game 
  * @return void
  */
  public static void coinFlip(String guess, int rounds){
  		for(int i= 0; i < Math.ceil(rounds/2); i++)
  			if(guess == computerChoice){
  				System.out.println("You won this round!");
  				userCount++; 

  			}else{
  				System.out.println("You lost this round :(");
  				programCount++;
  			}
  		scoreboard(userCount, programCount);
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
			Scoreboard.userTotalScore++;
  		}else{
  			System.out.println("Bummer! You lost. Try again next time.");
			Scoreboard.computerTotalScore++;
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

   /**
   * Start of the main function
   */
   public static void main(String[] args){
	displayGame(); 
	rounds();
	userguess();
	coinflip(userGuess,setRounds);
	scoreboard(userCount, programCount);
	printThankYou();
   }
}
