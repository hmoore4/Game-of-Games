public class Scoreboard {
    public static int userTotalScore = 0;
    public static int computerTotalScore = 0;
    public static int userEvenOrOddScore = 0; 
    public static int computerEvenOrOddScore = 0;
    public static int userFindTheRedThreadScore = 0; 
    public static int computerFindTheRedThreadScore = 0;
    public static void printScoreboard(){
        System.out.println("COMPUTER TOTAL SCORE: " + computerTotalScore);
        System.out.println("USER TOTAL SCORE: " + userTotalScore);

        System.out.println("USER FTRT SCORE: " + userFindTheRedThreadScore);
        System.out.println("COMPUTER FTRT SCORE: " + computerFindTheRedThreadScore);

    }
}
