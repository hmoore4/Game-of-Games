import java.util.Scanner;  // Import the Scanner class

public class PlayGames {
    private static boolean isWinnerInCurrentGame = false;
    public static void main(String args[]){
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Enter the game you want to play");
    
        String gameChosen = myObj.nextLine();  // Read user input
        if(gameChosen.equals("1")){
            FindTheRedThread.playGame();
            /*FindTheRedThread.setThreadArray();
            FindTheRedThread.chooseRedThread(20);
            while(isWinnerInCurrentGame == false){
                FindTheRedThread.printThreads();
                FindTheRedThread.guessThreads(3);
                if(FindTheRedThread.hasWinner)
                    isWinnerInCurrentGame = true;*/
            //}
        }
        //if(gameChosen.equals("2")){
        //    CoinFlip.playGame();
        //}
        Scoreboard.printScoreboard();
    }
}
