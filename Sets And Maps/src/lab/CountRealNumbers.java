package lab;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double[] realNums = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToDouble(Double::parseDouble)
                .toArray();

        Map<Double,Integer> countNumbers = new LinkedHashMap<>();

        for (double num : realNums) {
            if (!countNumbers.containsKey(num)) {
                countNumbers.put(num, 1);
            } else {
                countNumbers.put(num, countNumbers.get(num) + 1);
            }
        }

        countNumbers.entrySet()
                .forEach(e -> System.out.printf("%.1f -> %d%n",e.getKey(),e.getValue()));
    }
}