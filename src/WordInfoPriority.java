public class WordInfoPriority implements Comparable<WordInfoPriority>{
    private final String word;
    private final int moves;
    private final String history;
    private final int priority;

    public WordInfoPriority(String word, int moves, int estimatedWork) {
        this.word = word;
        this.moves = moves;
        this.history = word;
        this.priority = (getHistoryLength()) + estimatedWork;
    }

    public WordInfoPriority(String word, int moves, int estimatedWork, String history) {
        this.word = word;
        this.moves = moves;
        this.history = history;
        this.priority = (getHistoryLength()) + estimatedWork;
    }

    public String getWord() { return this.word; }
    public int getMoves() { return this.moves; }
    public String getHistory() { return this.history; }
    public int getPriority(){ return this.priority; }

    // returns the length of the history of the word ladder
    public int getHistoryLength(){
        String trimmedString = this.history.trim();
        if(trimmedString.isEmpty()){
            return 0;
        }
        return (trimmedString.split("\\s+").length) - 1;
    }

    @Override
    public String toString() {
        return String.format("Word %s Moves %d Priority: %d : History[%s]",
                word, moves, priority ,history);
    }

    @Override
    public int compareTo(WordInfoPriority o) {
        int valueToReturn = 0;

        if(this.priority <= o.priority){
            valueToReturn -= 1;
        }
        if(this.priority > o.priority){
            valueToReturn += 1;
        }
        return valueToReturn;
    }
}
