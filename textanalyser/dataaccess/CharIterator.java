package dataaccess;

import java.util.Iterator;
import java.util.ArrayList;

public class CharIterator implements Iterator<String> {
    private ArrayList<String> allLetters = new ArrayList<>();
    private int charIndex = 0;

    public CharIterator(FileContent content) {

        for (String line : content.fullText) {

            for (String letter : line.split("")) {

                if (!letter.trim().equals("")) {
                    allLetters.add(letter.toUpperCase());
                }
            }

        }

    }

    public boolean hasNext() {
        return this.charIndex < this.allLetters.size();
    }

    public String next() {
        return allLetters.get(this.charIndex++);
    }

}
