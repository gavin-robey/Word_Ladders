public class WordLadders {
    public static void main(String[] args) {
        ladderGame();
    }

    private static void ladderGame() {
        LadderGame gamePriority = new LadderGamePriority("dictionary.txt");
        LadderGame gameExhaustive = new LadderGameExhaustive("dictionary.txt");

        gameExhaustive.play("kiss", "woof");
        gamePriority.play("kiss", "woof");
        System.out.println();

        gameExhaustive.play("rock", "numb");
        gamePriority.play("rock", "numb");
        System.out.println();

        gameExhaustive.play("rums", "numb");
        gamePriority.play("rums", "numb");
        System.out.println();

        gameExhaustive.play("jura", "such");
        gamePriority.play("jura", "such");
        System.out.println();

        gameExhaustive.play("stet", "whey");
        gamePriority.play("stet", "whey");
        System.out.println();

        gameExhaustive.play("butter", "plates");
        gamePriority.play("butter", "plates");
        System.out.println();

        gameExhaustive.play("crafted", "mommies");
        gamePriority.play("crafted", "mommies");
        System.out.println();

        gameExhaustive.play("stone", "money");
        gamePriority.play("stone", "money");
    }
}
