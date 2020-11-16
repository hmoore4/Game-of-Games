/*
 * This class is responsible for general functions where the user is asked for input
 * It handles some general error checking cases. But it doesn't check errors that are specific to a certain game.
 */

import java.util.Scanner;  // Import the Scanner class

public class GetInput {

    /*
     * This function is used each time a number is asked for
     *  return: int. Return the integer that is being asked for
     */
    public static int numericInput(){
        boolean validInput = false;
        int numericInput = 0;
        while(!validInput){     //Will ask for input until a number is given
            try{
                Scanner scanner = new Scanner(System.in);     
                numericInput = scanner.nextInt(); 
                validInput = true;
            }
            catch(Exception inputMismatchException){                    //If the value isn't a number, throw error and loop to ask again
                System.out.println("The input must be an integer!");
            }
        }
        return numericInput;   
    }
    
    /*
     * This function checks to see if a number is in a range
     * param lowBoundary: The lower bound of the range
     * param highBoundary: The upper bound of the range
     * param input: the number in question
     * return boolean true if in range, false otherwise
     */
    public static boolean isInRange(int lowBoundary, int highBoundary, int input){
        if(input >= lowBoundary && input <= highBoundary){
            return true;
        }
        else{
            System.out.println("Please enter an integer between " + lowBoundary + " and " + highBoundary + ".");
            
            return false;
        }
    } 

    /*
     * This function tells if something is an odd number
     * return boolean: true if odd, false otherwise
     */
    public static boolean isOdd(int input){
        if(input % 2 == 0)
            return true;
        else
            return false;
    }

    public static int playAgain(){
        int playAgainInput = 0;
        boolean validInput = false;
        while(!validInput){
            try{
                Scanner scanner = new Scanner(System.in);
                System.out.println("Want to play again? Enter 1 to play again and 2 to quit.");
                playAgainInput = scanner.nextInt();
                if(playAgainInput == 1 || playAgainInput == 2){
                    validInput = true;
                }
                    
            
                else
                    System.out.println("The input must be 1 or 2.");
            }
            catch(Exception inputMismatchException){
                System.out.println("The input must be an integer!");
            }
        }
        
        return playAgainInput;
    }
}
