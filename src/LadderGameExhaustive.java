import java.util.ArrayList;

public class LadderGameExhaustive extends LadderGame {
    private final ArrayList<ArrayList<String>> sortedWords = getSortedWords();

    public LadderGameExhaustive(String dictionaryFile) {
        super(dictionaryFile);
    }

    @Override
    public void play(String start, String end) {
        Queue<WordInfo> q = new Queue<>();
        System.out.println("Seeking exhaustive solution from " + start + " -> " + end);

        if(isValid(start, end)) {
            ArrayList<String> tempDictionary = new ArrayList<>(sortedWords.get(start.length() - 1));
            q.enqueue(new WordInfo(start, 1, start));

            boolean complete = false;
            int enqueues = 0;
            while (!q.isEmpty() || !complete) {
                WordInfo info = q.dequeue();
                oneAway(start, true);
                if (info == null) {
                    System.out.println(start + " -> " + end + " : No ladder was found");
                    break;
                }
                for (String word : oneAway(info.getWord(), false)) {
                    if (word.equals(end)) {
                        complete = true;
                        System.out.println("[" + info.getHistory() + " " + word + "] total enqueues " + enqueues);
                    }
                    q.enqueue(new WordInfo(word, info.getMoves() + 1, info.getHistory() + " " + word));
                    enqueues++;
                    oneAway(word, true);
                }
            }
            sortedWords.get(start.length() - 1).clear();
            sortedWords.get(start.length() - 1).addAll(tempDictionary);
        }
    }

    public void listWords(int length, int howMany) {
        System.out.println("--- First " + howMany  + " words of length  " + length + " ---");
        for(int i = 0; i < howMany; i++){
            System.out.println(sortedWords.get(length - 1).get(i));
        }
    }
}