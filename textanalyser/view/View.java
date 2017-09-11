package view;

import java.util.Map;

public class View {

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printMap(Map<String, Integer> dictionary, int itemsCount) {
        System.out.println("Letters frequency in given text [letter -> frequency [%]]:");

        for(String item : dictionary.keySet()) {
            System.out.printf("[%s -> %.2f]", item, dictionary.get(item) / (double)itemsCount * 100);
        }

        System.out.println();

    }
}
