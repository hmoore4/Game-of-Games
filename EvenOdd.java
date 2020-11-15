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
    private static Boolean flag = true; //choice to contineu the game or break


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
      System.out.println(" ");
      return user;
    }

    /**
    * Method to get the second user user choice of Even or odd
    * @return user2choice
    */
    public static String computerChoice(){

      if(user.equals("E")){
          computer = "O";
          System.out.println("\t| You choose Even and Computer choose Odd.");
      }else{
          computer = "E";
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

      //NumberOfRounds = keyboard.nextInt();
      while(true){
        if(NumberOfRounds % 2 != 0){
          break;

        }else{
          System.out.print("\t| ");
          NumberOfRounds = keyboard.nextInt();

      }
      }
      System.out.println(" ");
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
        System.out.println(" ");

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
      System.out.println(" ");
      return throw2;


    }
    /**
    * Method to ask the user for the desired number of rounds
    * @return NumberOfRounds
    */
    public static int sumOfThrows(){
      System.out.println("\t| ");
      sumOfThrows = throw1 + throw2;
      return sumOfThrows;
    }

    /**
    * Method to ask the user for the desired number of rounds
    * @return NumberOfRounds
    */
    public static void Error(){
      System.out.println("\t| Please Enter a valid input. Number of rounds must be Odd. e.g(1,3,5...)");
    }


    /**
    * function that will call the other functions and play the game
    * @return: void
    */
    public static void PlayGame(){

      System.out.println("\t| Please Enter a valid number of rounds. Rounds must be an Odd number. e.g(1,3,5...)");
      getNumberOfRounds();

      //call the user1 function to get the first choice of Even or odd
      System.out.println("\t|User1 Choose Even or Odd: E or O");
      User1Choice();

      computerChoice();



      do {
            userThrow();
            computerThrow();

            if(sumOfThrows() % 2 == 0){
              System.out.println("\t| Even Wins this round");
              totalScoreEven++;
            }else{
              System.out.println("\t| Odd wins this round");
              totalScoreOdd++;
            }

      NumberOfRounds--;
      System.out.println("\t|"+NumberOfRounds+" Rounds left");

      if(NumberOfRounds > 0){
            System.out.println("\t|Want to continue playing ?\n\t|Enter 'y' to continue 'q' to quit. ");
            System.out.print("\t| ");
            choice = keyboard.next();
            if(choice.equals("Y") || choice.equals("y")){
              continue;
            } else if(choice.equals("Q") || choice.equals("q")){
                System.out.println("\t|Thank you for playing the Game.");
                break;
          } else{
            System.out.println("\t|Please Enter 'y' to continue 'q' to quit. ");
          }
        }


  }
    while (NumberOfRounds != 0);
    System.out.println();
    System.out.println();
    System.out.println();
    if(totalScoreEven > totalScoreOdd && user.equals("E")){

        System.out.println("\t|Congratulations you won! Your choice of Even wins!|");
        System.out.println("\t|Your total score is: "+totalScoreEven+"Computer total score is "+totalScoreOdd );

    } else if(totalScoreEven > totalScoreOdd && computer.equals("E")){
        System.out.println("\t|Sorry:( Good luck next time. Computer wins this round of Even choice!");
        System.out.println("\t|Computer total score is: "+totalScoreEven +"User total score is: "+totalScoreOdd);

    } else if(totalScoreEven < totalScoreOdd && user.equals("O")){
        System.out.println("\t|Congratulations You won! Your choice of Odd wins!");
        System.out.println("\t|Your total score is: "+totalScoreOdd+"Computer total score is "+totalScoreEven );

    } else if(totalScoreEven < totalScoreOdd && computer.equals("O")){
        System.out.println("\t|Sorry:( Good luck next time. Computer wins this round of Even choice!");
        System.out.println("\t|Computer total score is: "+totalScoreOdd +"User total score is: "+totalScoreEven);
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
    System.out.println();
    System.out.println();
  }

  public static void printThankYou(){
    System.out.println();
    System.out.println();
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
