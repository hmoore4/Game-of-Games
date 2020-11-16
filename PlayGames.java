import java.util.Scanner;  // Import the Scanner class

public class PlayGames {
    private static boolean playAgain = true;
    public static void main(String args[]){
        System.out.println("Welcome to the Game of Games! Please enter the number of the corresponding game you wish to play:");
        System.out.println("\n");

        while(playAgain == true){
            System.out.println("\n 1 - Find the red thread;\n 2 - Guess the number;\n 3 - Find the thimble;\n 4 - Even or Odd;\n 5 - Coin flip");
            Scanner scanner = new Scanner(System.in);  // Create a Scanner object
            int gameChosen = scanner.nextInt();  // Read user input
            if(gameChosen == 1){
                FindTheRedThread.playGame();
            }
            if(gameChosen == 2){
                GuessTheNumber.playGame();
            }
            if(gameChosen == 3){
                Thimble.gameThimble();
            }

            if(gameChosen == 4){
                EvenOdd.PlayGame();
            }
            if(gameChosen == 5){
                coinflip.playGame();
            }

            Scoreboard.printScoreboard();
            int playAgainInput = GetInput.playAgain();
            if(playAgainInput == 1){
                playAgain = true;
            }
            if(playAgainInput == 2){
                playAgain = false;
            }
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
