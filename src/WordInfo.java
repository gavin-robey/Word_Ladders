public class WordInfo {
    private final String word;
    private final int moves;
    private final String history;

    public WordInfo(String word, int moves) {
        this.word = word;
        this.moves = moves;
        this.history = word;
    }

    public WordInfo(String word, int moves, String history) {
        this.word = word;
        this.moves = moves;
        this.history = history;
    }

    public String getWord() { return this.word; }
    public int getMoves() { return this.moves; }
    public String getHistory() { return this.history; }

    @Override
    public String toString() {
        return String.format("Word %s Moves %d : History[%s]",
                word, moves, history);
    }
}