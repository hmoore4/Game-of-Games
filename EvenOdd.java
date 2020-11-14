/*
* Even Odd
*/
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
public class EvenOdd {

    private static String user;//store the choice of Even or odd for the first user
    private static String computer;//store the choice of Even or odd for the second user

    private static int min = 1;//store the choice of Even or odd for the first user
    private static int max = 5;//store the choice of Even or odd for the second user

    private static int totalScoreEven; //Track the even score
    private static int totalScoreOdd; //Track the odd score

    private static int NumberOfRounds; //variable for the total Number of rounds
    private static int throw1; //store the first throw
    private static int throw2; //store the second throw
    private static int sumOfThrows; //The sum of throw1+throw2 to determine who win
    private static String choice = "N"; //choice to contineu the game or break


    //Scanner for input
    static Scanner keyboard = new Scanner(System.in);
    //Random number generator
    static Random random = new Random();


    /**
    * Method to get the first user user choice of Even or odd
    * @return user1choice
    */
    public static String User1Choice(){
      System.out.print("\t| ");
      user = keyboard.next();
      return user;
    }

    /**
    * Method to get the second user user choice of Even or odd
    * @return user2choice
    */
    public static String computerChoice(){
      System.out.print("\t| ");
      computer = keyboard.next();
      return computer;
    }

    /**
    * Method to ask the user for the desired number of rounds
    * @return NumberOfRounds
    */
    public static int getNumberOfRounds(){
      System.out.print("\t| ");
      NumberOfRounds = keyboard.nextInt();
      return NumberOfRounds;
    }

    /**
    * Method to ask the user for the desired number of rounds
    * @return NumberOfRounds
    */
    public static int userThrow(){
      System.out.println("\t|Throw a number from 1 - 5");
      System.out.print("\t| ");
      throw1 = keyboard.nextInt();

      while(throw1 > 5 || throw1 < 1){
        System.out.println("\t|Please throw a number from 1 - 5");
        System.out.print("\t| ");
        throw1 = keyboard.nextInt();

      }
      return throw1;
    }

    /**
    * Method to ask the user for the desired number of rounds
    * @return NumberOfRounds
    */
    public static int computerThrow(){
      System.out.print("\t| ");
      throw2 = ThreadLocalRandom.current().nextInt(min, max + 1);
      return throw2;


    }
    /**
    * Method to ask the user for the desired number of rounds
    * @return NumberOfRounds
    */
    public static int sumOfThrows(){
      System.out.print("\t| ");
      sumOfThrows = throw1 + throw2;
      return sumOfThrows;
    }

    /**
    * function that will call the other functions and play the game
    * @return: void
    */
    public static void PlayGame(){

      System.out.println("\t|Total number of rounds: ");
      getNumberOfRounds();

      //call the user1 function to get the first choice of Even or odd
      System.out.println("\t|User1 Choose Even or Odd: E or O");
      User1Choice();

      System.out.println("\t|Computer to Choose Even or Odd: E or O");
      computerChoice();



      do {
            userThrow();
            computerThrow();

            if(sumOfThrows() % 2 == 0){
              System.out.println("\t|Even Wins this round");
              totalScoreEven++;
            }else{
              System.out.println("\t|Odd wins this round");
              totalScoreOdd++;
            }

      NumberOfRounds--;
      System.out.println("\t|"+NumberOfRounds+" Rounds left");

      if(NumberOfRounds > 0){
          System.out.println("\t|Want to continue");
          System.out.println("\t| ");
          choice = keyboard.next();
          if(choice.equals("Y")){
            continue;
          } else{
          System.out.println("\t|Thank you for playing the Game.");
          break;
        }
    }




    }
    while (NumberOfRounds != 0);
    if(totalScoreEven > totalScoreOdd && user.equals("E")){
        System.out.println("\t|Congratulations user1 your choice of Even wins!|");
        System.out.println("\t|Total score is: "+totalScoreEven);

    } else if(totalScoreEven > totalScoreOdd && computer.equals("E")){
        System.out.println("\t|Congratulations computer your choice of Even wins!");
        System.out.println("\t|Total score is: "+totalScoreEven);

    } else if(totalScoreEven < totalScoreOdd && user.equals("O")){
        System.out.println("\t|Congratulations user1 your choice of Odd wins!");
        System.out.println("\t|Total score is: "+totalScoreOdd);

    } else if(totalScoreEven < totalScoreOdd && computer.equals("O")){
        System.out.println("\t|Congratulations computer your choice of Odd wins!");
        System.out.println("\t|Total score is: "+totalScoreOdd);
      }

  }

  public static void rules(){
    System.out.println("\t|-------------------------------------------------------------------------------------------|");
    System.out.println("\t|             Welcome to Even or Odd game                                                   |");
    System.out.println("\t|                                                                                           |");
    System.out.println("\t|           Please read the description of the game here:                                   |");
    System.out.println("\t|           1-Even odd game have to be played between two users (User and computer)         |");
    System.out.println("\t|                                                                                           |");
    System.out.println("\t|         2-You will need to enter the number of rounds to start the game                   |");
    System.out.println("\t|3- you will be asked to choose either Even or Odd. Please Enter 'E' for even or 'O' for Odd|");
    System.out.println("\t|                                                                                           |");
    System.out.println("\t|4-         After each round you can quit the game with 'q' or keep going with 'c'          |");
    System.out.println("\t|                                                                                           |");
    System.out.println("\t|5-  In the End of the game we will announce the winner by adding both of the throws.       |");
    System.out.println("\t|  if the sum is Even then Even will win. if the sum is odd then Odd will win               |");
    System.out.println("\t|6-                After the we announe the winnner and the game ends                       |");
    System.out.println("\t| You will be asked if you wanna play another round or not.  'Y' to play again 'q to quit'  |");
    System.out.println("\t|                                   Enjoy the Game:)                                        |");
    System.out.println("\t|                                                                                           |");
    System.out.println("\t|-------------------------------------------------------------------------------------------|");
  }

  public static void printThankYou(){
    System.out.println("\t|-------------------------------------------------------------------------------------------|");
    System.out.println("\t|           Thank you for Playing Even odd game. I hope you enjoyed it :)                   |");
    System.out.println("\t|                                                                                           |");
    System.out.println("\t|-------------------------------------------------------------------------------------------|");
  }

/**
* Start of the main function
*/
  public static void main(String[] args){
    //Call the print method to start displaying instruction
    rules();
    //Call the game function to start
    PlayGame();
    //call the printThankYou function as a last step for the game to end
    printThankYou();




  }
}
