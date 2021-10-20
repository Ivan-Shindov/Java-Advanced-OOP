package exercise;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        Map<Character,Integer> lettersCount = new TreeMap<>();

        for (int i = 0; i < text.length(); i++) {
            char currentSymbol = text.charAt(i);
            lettersCount.putIfAbsent(currentSymbol,0);
            lettersCount.put(currentSymbol,lettersCount.get(currentSymbol) + 1);
        }

        for (Map.Entry<Character, Integer> entry : lettersCount.entrySet()) {
            System.out.printf("%c: %d time/s%n",entry.getKey(),entry.getValue());
        }
    }
}
