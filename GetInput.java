import java.util.Scanner;  // Import the Scanner class

public class GetInput {
    public static int numericInput(){
        /*boolean validInput = false;
        int numericInput = 0;
        Scanner scanner = new Scanner(System.in);  // Create a Scanner object    
        numericInput = scanner.nextInt(); 
        return numericInput;   */ 
        boolean validInput = false;
        int numericInput = 0;
        while(!validInput){
            try{
                Scanner scanner = new Scanner(System.in);  // Create a Scanner object    
                numericInput = scanner.nextInt(); 
                validInput = true;
            }
            catch(Exception inputMismatchException){
                System.out.println("The input must be an integer!");
            }
        }
        return numericInput;   
    }
    
    public static boolean isInRange(int lowBoundary, int highBoundary, int input){
        System.out.println("TEST");
        if(input >= lowBoundary && input <= highBoundary){
            return true;
        }
        else{
            System.out.print("Please enter an integer between " + lowBoundary + " and " + highBoundary + ".");
            numericInput();
            return false;
        }
    } 

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
