import java.util.Scanner;

public class WordLadders {
    public static void main(String[] args) {
        ladderGame();
    }

    private static void ladderGame() {
        Scanner scanner = new Scanner(System.in);
        LadderGame gamePriority = new LadderGamePriority("dictionary.txt");
        LadderGame gameExhaustive = new LadderGameExhaustive("dictionary.txt");

        try {
            System.out.println(" ");
            System.out.println("Welcome to Word Ladders!");
            System.out.println("Enter a word you would like to be changed");
            System.out.println("Then enter a second word");
            System.out.println("This program will change the first word one letter at a time until the second word is created");
            System.out.println("To exit the program, type Control+C");
            while (true) {
                System.out.println(" ");
                System.out.print("Enter the first word: ");
                String firstWord = scanner.nextLine();

                System.out.println(" ");

                System.out.print("Enter the second word: ");
                String secondWord = scanner.nextLine();

                System.out.println("");
                gameExhaustive.play(firstWord, secondWord);
                System.out.println(" ");
                gamePriority.play(firstWord, secondWord);
                System.out.println(" ");
            }
        } catch (Exception e) {
            System.out.println("Exiting program...");
        } finally {
            scanner.close();
        }
    }
}
