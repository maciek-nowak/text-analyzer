package app;

import java.util.ArrayList;
import java.util.Map;
import java.io.FileNotFoundException;

import view.View;
import dataaccess.FileContent;
import analysis.StatisticalAnalysis;

public class Application {
    private View printer = new View();
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
