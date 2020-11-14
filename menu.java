import java.util.Scanner;  // Import the Scanner class

public class menu {
    private static boolean isWinnerInCurrentGame = false;
    public static void main(String args[]){
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Enter username");
    
        String userName = myObj.nextLine();  // Read user input
        if(userName.equals("1")){
            FindTheRedThread.setThreadArray();
            FindTheRedThread.chooseRedThread(20);
            while(isWinnerInCurrentGame == false){
                FindTheRedThread.printThreads();
                FindTheRedThread.guessThreads(3);
                if(FindTheRedThread.hasWinner)
                    isWinnerInCurrentGame = true;
            }
        }
        Scoreboard.printScoreboard();
    }
}
