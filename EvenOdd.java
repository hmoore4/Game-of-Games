/**
* Class for Game of Games 
* implemeintg the Even Odd Game
* @author Ziad Sakr
* Group 4 (Ziad, Hunter, Anna, Kevin, Willaim)
* Professor: Dr.S
* @Start date: November 14th.
* @Modified date: Novemeber 16th.
*/
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
public class EvenOdd {

    private static int user;//store the choice of Even or odd for the user
    private static int computer;//store the choice of Even or odd for the computer

    private static int min = 1;//min number in random genearator
    private static int max = 5;//max number in random genearator

    private static int totalScoreEven; //Track the even score
    private static int totalScoreOdd; //Track the odd score

    private static int NumberOfRounds; //variable for the total Number of rounds
    private static int throw1; //store the first throw
    private static int throw2; //store the second throw
    private static int sumOfThrows; //The sum of throw1+throw2 to determine who win
    private static int choice; //choice to choose to continue or break


    //Scanner for input
    static Scanner keyboard = new Scanner(System.in);
    //Random number generator
    static Random random = new Random();


    /**
    * Method to get the first user user choice of Even or odd
    * check if it is a valid input or not
    * @return user choice of even or odd
    */
    public static int user(){

      //keep looping uitl a valid input
      while(true){
          if(keyboard.hasNextInt()){
              user = keyboard.nextInt();
            //input has to be within this range
              if(1<=user && user <= 2)
                  break;
              System.out.println("\t| Invalid Input. \n\t| Please Enter 1 for Even or 2 for Odd");
              System.out.print("\t| ");
          } else{
            continue;
          }
        }
    return user;
  }

  /**
  * Method to get the computer choice of Even or odd. The choice will depend on the user
  * check if it is a valid input or not
  * @return computer choice of even or odd
  **/
    public static int computerChoice(){
      //choice will depend on the user choice
      if(user == 1){
          computer = 2;
          System.out.println("\t| You choose Even and Computer choose Odd.");
      }else{
          computer = 1;
          user = 2;
          System.out.println("\t| You choose Odd and Computer choose Even.");
      }
      System.out.println(" ");
      return computer;
    }

    /**
    * Method to ask the user for the desired number of rounds
    * @return NumberOfRounds
    */
    public static int getNumberOfRounds(){
      //keep looping uitl a valid input
      while(true){
        if(NumberOfRounds % 2 != 0){
          break;
          //if the input is not a valid Input such as not integer
      } else if(!keyboard.hasNextInt()) {

         System.out.println("\t|Invalid Input.");
         //call the error function to display message
         Error();
         System.out.print("\t| ");
         keyboard.next();
        } else{
          //ask user if it is not the right input
          System.out.print("\t| ");
          NumberOfRounds = keyboard.nextInt();

        }
      }
      System.out.println(" ");
      return NumberOfRounds;
    }

    /**
    * Method to ask the user to throw a number between 1 and 5
    * @return throw1 first throw of the user
    */
    public static int userThrow(){
      System.out.println("\t| Now it is your turn.");
      System.out.println("\t| Throw a number from 1 - 5");
      System.out.print("\t| ");
      throw1 = keyboard.nextInt();
      //check stateement to check if throw is not within the range
      while(throw1 > 5 || throw1 < 1){
        System.out.println("\t| Please throw a number from 1 - 5");
        System.out.print("\t| ");
        //ask user for input
        throw1 = keyboard.nextInt();
        System.out.println(" ");
      }
      return throw1;
    }

    /**
    * Method that will randomly throw on behalf of the computer
    * Random number between 1 and 5
    * @return throw2 second throw of the computer
    */
    public static int computerThrow(){

      //using the ThreadLocalRandom geneartor
      System.out.println("\t| Computer just throw a number");
      throw2 = ThreadLocalRandom.current().nextInt(min, max + 1);
      System.out.println(" ");
      return throw2;


    }
    /**
    * Method to add the number of the throws in order to determine winner
    * @return sumOfThrows
    */
    public static int sumOfThrows(){
      System.out.println("\t| ");
      sumOfThrows = throw1 + throw2;
      return sumOfThrows;
    }

    /**
    * Method to print the error message
    * @return void
    */
    public static void Error(){
      System.out.println("\t| Please Enter a valid input. Number of rounds must be Odd. e.g(1,3,5...)");
    }


    /**
    * Method that will call the other functions and start playing the game
    */
    public static void PlayGame(){

      //Call the rules method to start displaying instruction
      rules();

      //Number of rounds
      System.out.println("\t| Please Enter a valid number of rounds. Rounds must be an Odd number. e.g(1,3,5...)");
      System.out.print("\t| ");
      getNumberOfRounds();

      //call the user function to get the first choice of Even or odd
      System.out.println("\t| To start please choose Even or Odd: 1 for Even or 2 for Odd");
      System.out.print("\t| ");
      user();
      //determine the computer choice based on the user
      computerChoice();

      //do-while loop to enter the game. this loop to at least play it one round
      do {
            //Computer Turn to throw throw
            computerThrow();
            //user turn to throw
            userThrow();

            //check if the sum is even or odd to announce winner
            if(sumOfThrows() % 2 == 0){
              System.out.println("\t| Even Wins this round");
              totalScoreEven++;

            }else{
              System.out.println("\t| Odd wins this round");
              totalScoreOdd++;
            }


            //detuct number of rounds after each round played
            NumberOfRounds--;
            //print how many rounds left
            System.out.println("\t|"+NumberOfRounds+" Rounds left");
            //ask user to quit the game after each round
            if(NumberOfRounds > 0){
                  System.out.println("\t|Want to continue playing ?\n\t|Enter 1 to continue 2 to quit. ");
                  System.out.print("\t| ");
                  choice = keyboard.nextInt();
                  //choice == 1 means continue
                  if(choice == 1){
                    continue;
                    //choice == 2 means break and quit the game
                  } else if(choice == 2){
                      System.out.println("\t|Thank you for playing the Game.");
                      break;
                }else{
                  //otherwise ask user for an invalid input
                  System.out.println("\t|Please Enter a valid input. Want to continue playing ?\n\t|Enter 1 to continue 2 to quit. ");
                  System.out.print("\t| ");
                  choice = keyboard.nextInt();
                  continue;
                }
              }
            }
            //Print winner and loser
            while (NumberOfRounds != 0);
            System.out.println();
            System.out.println();
            System.out.println();
            //check if the user is winning to display winner
            if(totalScoreEven > totalScoreOdd && user == 1){
                System.out.println("\t|Congratulations you won! Your choice w Even wins!|");
                System.out.println("\t|Your total score is: "+totalScoreEven+" Computer total score is "+totalScoreOdd );
                //update the score to the Game of Games score
                Scoreboard.userEvenOrOddScore = totalScoreEven;
                Scoreboard.userTotalScore++;
            //check if the computer is winning to display winner
            } else if(totalScoreEven > totalScoreOdd && computer == 1){
                System.out.println("\t|Sorry:( Good luck next time. Computer wins this round with choice of Even!");
                System.out.println("\t|Computer total score is: "+totalScoreEven +" User total score is: "+totalScoreOdd);
                //update the score to the Game of Games score
                Scoreboard.computerEvenOrOddScore = totalScoreEven;
                Scoreboard.computerTotalScore++;
            //check if the user is winning to display winner
            } else if(totalScoreEven < totalScoreOdd && user == 2){
                System.out.println("\t|Congratulations You won! Your choice of Odd wins!");
                System.out.println("\t|Your total score is: "+totalScoreOdd+" Computer total score is "+totalScoreEven );
                //update the score to the Game of Games score
                Scoreboard.userEvenOrOddScore = totalScoreOdd;
                Scoreboard.userTotalScore++;
            //check if the computer is winning to display winner
            } else if(totalScoreEven < totalScoreOdd && computer == 2){
                System.out.println("\t|Sorry:( Good luck next time. Computer wins this round with choice of Odd!");
                System.out.println("\t|Computer total score is: "+totalScoreOdd +" User total score is: "+totalScoreEven);
                //update the score to the Game of Games score
                Scoreboard.computerEvenOrOddScore = totalScoreOdd;
                Scoreboard.computerTotalScore++;
              }
              //call the printThankYou function as a last step for the game to end
              printThankYou();
          }
  /**
  * Method to display the rules of the game
  */
  public static void rules(){
    System.out.println("\t|-------------------------------------------------------------------------------------------|");
    System.out.println("\t|             Welcome to Even or Odd game                                                   |");
    System.out.println("\t|                                                                                           |");
    System.out.println("\t|           Please read the description of the game here:                                   |");
    System.out.println("\t|           1-Even odd game have to be played between two users (User and computer)         |");
    System.out.println("\t|                                                                                           |");
    System.out.println("\t|         2-You will need to enter the number of rounds to start the game                   |");
    System.out.println("\t|3- you will be asked to choose either Even or Odd. Please Enter 1 for Even or 2 for Odd.   |");
    System.out.println("\t|                                                                                           |");
    System.out.println("\t|4-         After each round you can quit the game with 'q' or keep going with 'y'          |");
    System.out.println("\t|                                                                                           |");
    System.out.println("\t|5-  In the End of the game we will announce the winner by adding both of the throws.       |");
    System.out.println("\t|  if the sum is Even then Even will win. if the sum is odd then Odd will win               |");
    System.out.println("\t|6-                After the we announe the winnner and the game ends                       |");
    System.out.println("\t| You will be asked if you wanna play again or not. Enter 1 to play again or 2 to quit'     |");
    System.out.println("\t|                                   Enjoy the Game:)                                        |");
    System.out.println("\t|                                                                                           |");
    System.out.println("\t|-------------------------------------------------------------------------------------------|");
    System.out.println();
    System.out.println();
  }
  /**
  * Method to display thank you at the end of the game
  */
  public static void printThankYou(){
    System.out.println();
    System.out.println();
    System.out.println("\t|-------------------------------------------------------------------------------------------|");
    System.out.println("\t|           Thank you for Playing Even odd game. I hope you enjoyed it :)                   |");
    System.out.println("\t|                                                                                           |");
    System.out.println("\t|-------------------------------------------------------------------------------------------|");
  }

   /**
   * The application's entry point
   *
   * @param args an array of command-line arguments for the application
   */
  public static void main(String[] args){
    //Call the game function to start
    PlayGame();
  }
}

/*
* END OF THE EVEN ODD PROGRAM
*/
