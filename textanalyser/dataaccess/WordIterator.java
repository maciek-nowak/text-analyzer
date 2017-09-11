package dataaccess;

import java.util.Iterator;
import java.util.ArrayList;

public class WordIterator implements Iterator<String> {
    private ArrayList<String> allWords = new ArrayList<>();
    private int wordIndex = 0;

    public WordIterator(FileContent content) {

        for (String line : content.fullText) {

            for (String word : line.split("\\s+")) {

                if(!word.equals("")) {
                    allWords.add(word.toLowerCase());
                }

            }

        }
    }

    public boolean hasNext() {
        return this.wordIndex < this.allWords.size();
    }

    public String next() {
        return allWords.get(this.wordIndex++);
    }

}
