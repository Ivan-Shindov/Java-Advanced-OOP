package exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class MinerTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String,Integer> resources = new LinkedHashMap<>();

        String input = scanner.nextLine();

        while (!input.equals("stop")) {
            int quantity = Integer.parseInt(scanner.nextLine());

            if (!resources.containsKey(input)) {
                resources.put(input, quantity);
            } else {
                int currentValue = resources.get(input);
                resources.put(input, currentValue + quantity);
            }

            input = scanner.nextLine();
        }

        resources.forEach((key, value) -> System.out.println(String.format("%s -> %d",
                key, value)));
    }
}
