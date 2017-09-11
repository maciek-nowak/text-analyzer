package dataaccess;

import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.io.File;
import java.util.Iterator;

public class FileContent implements IterableText {
    private String filename;
    ArrayList<String> fullText;

    public FileContent(String filename) throws FileNotFoundException {
        this.filename = filename;
        this.fullText = new ArrayList<>();

        try (Scanner fileScan = new Scanner(new File("data/" + filename))) {

            while(fileScan.hasNextLine()) {
                this.fullText.add(fileScan.nextLine());
            }

        } catch (FileNotFoundException e) {
            throw e;
        }
    }

    public Iterator<String> charIterator() {
        return new CharIterator(this);
    }

    public Iterator<String> wordIterator() {
        return new WordIterator(this);
    }

    public String getFilename() {
        return filename;
    }

    public static void main(String[] args) {
        FileContent fileContentr = null;
        try {
            fileContentr = new FileContent("dsf");
        } catch (FileNotFoundException e) {
            System.out.println("Niema");
        }

        Iterator<String> wordIterator = fileContentr.wordIterator();

        while(wordIterator.hasNext()) {
            System.out.println(wordIterator.next());
        }
    }

}
