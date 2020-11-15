import java.util.Scanner;  // Import the Scanner class

public class GetInput {

    public static int numericInput(){
        Scanner scanner = new Scanner(System.in);  // Create a Scanner object    
        int numericInput = scanner.nextInt(); 
        return numericInput;     
    }
    public static int playAgain(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Want to play again? Enter 1 to play again and 2 to quit.");
        int playAgainInput = scanner.nextInt();
        return playAgainInput;
    }
}
