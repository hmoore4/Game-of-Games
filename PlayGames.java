import java.util.Scanner;  // Import the Scanner class

public class PlayGames {
    private static boolean playAgain = true;
    public static void main(String args[]){
        System.out.println("Welcome to the Game of Games! Please enter the number of the corresponding game you wish to play:\n 1 - Find the red thread;\n 2 - Guess the number;\n 3 - Find the thimble;\n 4 - Even or Odd;\n 5 - Coin flip");
        System.out.println("\n");

        while(playAgain == true){
            Scanner scanner = new Scanner(System.in);  // Create a Scanner object
        
            String gameChosen = scanner.nextLine();  // Read user input
            if(gameChosen.equals("1")){
                FindTheRedThread.playGame(); 
            }
            if(gameChosen.equals("4")){
                EvenOdd.rules();
                EvenOdd.PlayGame();
            }

            Scoreboard.printScoreboard();
            String input = scanner.nextLine();
            if(input.equals("1")){
                playAgain = true;
            }
            if(input.equals("2")){
                playAgain = false;
            }
            scanner.close();
        }
        if(Scoreboard.userTotalScore > Scoreboard.computerTotalScore){
            System.out.println("Congrats! You win!");
        }
        else if(Scoreboard.userTotalScore < Scoreboard.computerTotalScore){
            System.out.println("Sorry! The computer wins! Try again soon!");

        }
        else{
            System.out.println("It was a tie!");
        }
        System.out.println("You scored " + Scoreboard.userTotalScore + " points and the computer scored " + Scoreboard.computerTotalScore + " points!");
        System.out.println("Here's the final scoreboard!");
        Scoreboard.printScoreboard();
    }
}
