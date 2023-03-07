import java.util.HashMap;
import java.util.Map;

public class LadderGamePriority extends LadderGame{
    public LadderGamePriority(String dictionaryFile) {
        super(dictionaryFile);
    }

    @Override
    public void play(String start, String end) {
        AVLTree<WordInfoPriority> priorityQueue = new AVLTree<>();
        Map<String, Integer> previouslyUsed = new HashMap<>();
        System.out.println("Seeking A* solution from " + start + " -> " + end);

        if(isValid(start, end)){
            WordInfoPriority startWord = new WordInfoPriority(start, 1, estimatedWork(start, end));
            priorityQueue.insert(startWord);
            previouslyUsed.put(start, 0);

            boolean complete = false;
            int enqueues = 0;
            while (!complete && !priorityQueue.isEmpty()) {
                WordInfoPriority info = priorityQueue.deleteMin();
                if (info.getWord().equals(end)) {
                    complete = true;
                    System.out.println("[" + info.getHistory() + "] total enqueues " + enqueues);
                }
                else{
                    for (String word : oneAway(info.getWord(), false)) {
                        WordInfoPriority newWord = new WordInfoPriority(word, info.getMoves() + 1, estimatedWork(word, end), info.getHistory() + " " + word);
                        if(!previouslyUsed.containsKey(newWord.getWord())){
                            previouslyUsed.put(newWord.getWord(), newWord.getHistoryLength());
                            priorityQueue.insert(newWord);
                            enqueues++;
                        }
                        if(previouslyUsed.containsKey(newWord.getWord()) && previouslyUsed.get(newWord.getWord()) > newWord.getHistoryLength()){
                            priorityQueue.insert(newWord);
                            previouslyUsed.remove(word);
                            previouslyUsed.put(newWord.getWord(), newWord.getHistoryLength());
                            enqueues++;
                        }
                    }
                }
            }
        }
    }

    // calculates how different a given word is from the end word
    private int estimatedWork(String currentWord, String end){
        int totalDifferentChars = 0;
        for (int i = 0; i < currentWord.length(); i++) {
            if (currentWord.charAt(i) != end.charAt(i)) {
                totalDifferentChars++;
            }
        }
        return totalDifferentChars;
    }
}
