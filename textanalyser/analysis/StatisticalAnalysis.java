package analysis;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.Map;
import java.util.Iterator;

public class StatisticalAnalysis {
    private LinkedHashMap<String, Integer> itemsOccurencies;

    public StatisticalAnalysis(Iterator<String> iter) {
        this.itemsOccurencies = new LinkedHashMap<>();
        this.storeOccurencies(iter);
    }

    public Map<String, Integer> getItemsOccurencies() {
        return this.itemsOccurencies;
    }

    private void storeOccurencies(Iterator<String> iter) {

        while(iter.hasNext()) {
            String element = iter.next();

            if(this.itemsOccurencies.containsKey(element)) {
                this.itemsOccurencies.put(element, itemsOccurencies.get(element) + 1);
            } else {
                this.itemsOccurencies.put(element, 1);
            }

        }

    }

    public int countOf(String... elements) {
        int count = 0;

        for(String element : elements) {
            count += this.itemsOccurencies.getOrDefault(element, 0);
        }

        return count;
    }

}
