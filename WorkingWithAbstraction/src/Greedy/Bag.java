package greedyTimes;

import java.util.HashMap;
import java.util.Map;

public class Bag {
    private long capacity;
    private long currentQuantity;
private boolean isAddGold;
    private long totalGold;
    private long totalGems;
    private Map<String, Long> gems;
    private long totalCash;
    private Map<String, Long> cash;

    public Bag(long capacity) {
        this.capacity = capacity;
        this.currentQuantity = 0;
        this.totalGold = 0;
        this.totalGems = 0;
        this.gems = new HashMap<>();
        this.totalCash = 0;
        this.cash = new HashMap<>();
        this.isAddGold = false;
    }

    public void addCash(String currency, long quantity) {
        if(hasFreeSpace(quantity) &&
                this.totalGems >= this.totalCash + quantity) {

            addToMap(this.cash,currency, quantity);
            this.totalCash += quantity;
        }
    }

    public void addGems(String gemName, long quantity) {
        if(hasFreeSpace(quantity) &&
                this.totalGems + quantity <= this.totalGold) {

            addToMap(this.gems,gemName, quantity);
            this.totalGems += quantity;
        }
    }

    public void addGold(long quantity) {
        if (hasFreeSpace(quantity)) {
            this.totalGold += quantity;
            this.currentQuantity += quantity;
            this.isAddGold = true;
        }
    }

    private boolean hasFreeSpace(long quantity) {
        return this.currentQuantity + quantity <= this.capacity;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        if (this.isAddGold) {
            sb.append("<Gold> $").append(this.totalGold).append(System.lineSeparator());
            sb.append("##Gold - ").append(this.totalGold).append(System.lineSeparator());
        }

        if (this.gems.size() > 0) {
            sb.append("<Gem> $").append(this.totalGems).append(System.lineSeparator());
            appending(sb, this.gems);
        }

        if (this.cash.size() > 0) {
            sb.append("<Cash> $").append(this.totalCash).append(System.lineSeparator());
            appending(sb, this.cash);
        }

        return sb.toString().trim();
    }

    private void addToMap(Map<String, Long> map, String gemName, long quantity) {
        if (!map.containsKey(gemName)) {
            map.put(gemName, quantity);
        } else {
            map.put(gemName, map.get(gemName) + quantity);
        }

        this.currentQuantity += quantity;
    }

    private void appending(StringBuilder sb, Map<String, Long> map) {
        map.entrySet().stream()
                .sorted((first, second) -> {
                    int result = second.getKey().compareTo(first.getKey());
                    if (result == 0) {
                        result = first.getValue().compareTo(second.getValue());
                    }
                    return result;
                }).forEach(e -> sb.append("##").append(e.getKey()).append(" - ")
                .append(e.getValue()).append(System.lineSeparator()));
    }
}
