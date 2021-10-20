package lab;

import java.util.*;

public class Cities {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Map<String, List<String>>> data = new LinkedHashMap<>();

        while (n-- > 0) {

            String[] tokens = scanner.nextLine().split("\\s+");
            String continent = tokens[0];
            String country = tokens[1];
            String city = tokens[2];

            if (!data.containsKey(continent)) {
                data.put(continent, new LinkedHashMap<>());
            }

            data.get(continent).putIfAbsent(country, new ArrayList<>());
            data.get(continent).get(country).add(city);
        }

        data.entrySet().stream()
                .forEach(e -> {
                    System.out.println(e.getKey() + ":");
                    e.getValue().entrySet().stream()
                            .forEach(v -> System.out.printf("%s -> %s%n",
                                    v.getKey(), String.join(", ",v.getValue())));
                });

    }
}
