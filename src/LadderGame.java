import java.io.File;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public abstract class LadderGame {
    private final ArrayList<ArrayList<String>> sortedWords = new ArrayList<>();
    private final ArrayList<String> allWords = new ArrayList<>();

    public LadderGame(String dictionaryFile){
        readDictionary(dictionaryFile);
    }

    public abstract void play(String start, String end);

    public ArrayList<ArrayList<String>> getSortedWords() {
        return sortedWords;
    }


    /**
     * 
     * @param word input word to find all one-away words
     * @param withRemoval gives the method the ability to remove a word from the sorted words array
     * @return ArrayList<String> of all one away words
     */
    public ArrayList<String> oneAway(String word, boolean withRemoval) {
        ArrayList<String> words = new ArrayList<>();
        if(!withRemoval) {
            for (int i = 0; i < sortedWords.get(word.length() - 1).size(); i++) {
                String currentWord = sortedWords.get(word.length() - 1).get(i);
                int totalDifferentChars = 0;
                for (int j = 0; j < word.length(); j++) {
                    if (currentWord.charAt(j) != word.charAt(j)) {
                        totalDifferentChars++;
                    }
                }
                if (totalDifferentChars == 1) {
                    words.add(currentWord);
                }
            }
        }else{
            sortedWords.get(word.length() - 1).remove(word);
        }
        return words;
    }

    /* Reads a list of words from a file, putting all words of the same length into the same array. */
    private void readDictionary(String dictionaryFile) {
        File file = new File(dictionaryFile);
        int longestWord = 0;
        try (Scanner input = new Scanner(file)) {

            while (input.hasNextLine()) {
                String word = input.nextLine().toLowerCase();
                allWords.add(word);
                longestWord = Math.max(longestWord, word.length());
            }

            for(int i = 0; i < longestWord; i++) {
                sortedWords.add(new ArrayList<>());
            }

            for (String word : allWords) {
                sortedWords.get(word.length() - 1).add(word);
            }
        }
        catch (java.io.IOException ex) {
            System.out.println("An error occurred trying to read the dictionary: " + ex);
        }
    }

    // checks to ensure all inputs are valid
    public boolean isValid(String start, String end){
        boolean valid = true;
        if(Objects.equals(start, "") || Objects.equals(end, "")){
            System.out.println("Input cannot be empty");
            valid = false;
        }
        else if(Objects.equals(start, null) || Objects.equals(end, null)){
            System.out.println(start + " -> " + end + " : Input cannot be null");
            valid = false;
        }
        else if(!sortedWords.get(start.length() - 1).contains(start) || !sortedWords.get(end.length() - 1).contains(end)){
            System.out.println(start + " -> " + end + " : Input words must be in the english dictionary");
            valid = false;
        }
        else if(start.length() != end.length()){
            System.out.println(start + " -> " + end + " : Input words must be the same length");
            valid = false;
        }
        return valid;
    }
}
