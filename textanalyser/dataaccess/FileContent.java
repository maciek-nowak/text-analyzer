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
