import java.util.Scanner;  // Import the Scanner class

public class PlayGames {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Enter the game you want to play");
    
        String gameChosen = scanner.nextLine();  // Read user input
        if(gameChosen.equals("1")){
            FindTheRedThread.playGame(); 
        }
        if(gameChosen.equals("2")){
            EvenOdd.rules();
            EvenOdd.PlayGame();
        }
        Scoreboard.printScoreboard();
        scanner.close();
    }
}
