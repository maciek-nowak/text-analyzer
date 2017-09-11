package app;

import java.util.ArrayList;
import java.util.Map;
import java.io.FileNotFoundException;

import view.View;
import dataaccess.FileContent;
import analysis.StatisticalAnalysis;

public class Application {
    private View printer = new View();

    private void testAndPrint(FileContent fileContent) {
        StatisticalAnalysis charAnalyzer = new StatisticalAnalysis(fileContent.charIterator());
        StatisticalAnalysis wordAnalyzer = new StatisticalAnalysis(fileContent.wordIterator());

        String title = String.format("==%s==", fileContent.getFilename());
        printer.printMessage("\n" + title);

        int charCount = charAnalyzer.size();
        int wordCount = wordAnalyzer.size();

        printer.printMessage("Char count: " + charCount);
        printer.printMessage("Word count: " + wordCount);
        printer.printMessage("Dict size: " + wordAnalyzer.dictionarySize());
        printer.printMessage("Most used words (>1%): " + wordAnalyzer.occurMoreThan(wordCount / 100));

        String[] wordsToFind = {"love", "hate", "music"};
        for(String word : wordsToFind) {
            printer.printMessage(String.format("'%s' count: %d", word, wordAnalyzer.countOf(word)));
        }

        int vowelsCount = charAnalyzer.countOf("A", "O", "E", "I", "U");
        printer.printMessage("vowels %: " + (int) (vowelsCount / (double) charCount * 100));

        double ratio = Math.round(charAnalyzer.countOf("A") / (double) charAnalyzer.countOf("E") * 100.0) / 100.0;
        printer.printMessage("'a':'e' count ratio: " + ratio);

        Map<String, Integer> charsOccurencies = charAnalyzer.getItemsOccurencies();
        printer.printMap(charsOccurencies, charCount);
    }

    private void start(String[] args) {

        for(String arg: args) {

            try {
                FileContent fileContent = new FileContent(arg);
                testAndPrint(fileContent);
            }  catch (FileNotFoundException e) {
                System.out.println("\nFile " + arg +  " not found!");
            }

        }

    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        if(args.length == 2) {
            Application app = new Application();
            app.start(args);
        } else {
            new View().printMessage("Wrong arguments!\nProper command:\njava Application file1.txt file2.txt");
        }

        long endTime = System.currentTimeMillis();
        double elapsedTime = (endTime - startTime) / 1000.0;
        new View().printMessage("Benchmark time: " + elapsedTime + " secs");

    }

}
