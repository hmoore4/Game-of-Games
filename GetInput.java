import java.util.Scanner;  // Import the Scanner class

public class GetInput {
    public static int numericInput(){
        Scanner scanner = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Please select a thread to choose.");
    
        int thread = scanner.nextInt();  
        return thread;
    }
}
