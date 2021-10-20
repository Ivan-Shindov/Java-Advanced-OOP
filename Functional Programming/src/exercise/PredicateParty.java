package exercise;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> names = Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toList());
        String input = scanner.nextLine();

        while (!input.equals("Party!")) {

            BiPredicate<String,String> predicate = null;

            String[] tokens = input.split("\\s+");
            String command = tokens[1];

            switch (command) {
                case "StartsWith":
//                    String start = tokens[2];
                    predicate = (n,s) -> n.startsWith(s);
                    break;
                case "EndsWith":
                    predicate = (n,e) -> n.endsWith(e);
                    break;
                case "Length":
                    predicate = (name,l) -> {
                        int length = Integer.parseInt(l);
                        return name.length() == length;
                    };
                    break;
            }
            String removeOrDouble = tokens[0];

            if ("Double".equals(removeOrDouble)) {
                int startSize = names.size();
                for (int i = 0; i < startSize; i++) {
                    if (predicate.test(names.get(i), tokens[2])) {
                        names.add(names.get(i));
                    }
                }
            } else if ("Remove".equals(removeOrDouble)) {
                for (int i = 0; i < names.size(); i++) {
                    if (predicate.test(names.get(i),tokens[2])) {
                        names.remove(i);
                        i--;
                    }
                }
            }

            input = scanner.nextLine();
        }

        String collect = names.stream().sorted(Comparator.naturalOrder())
                .collect(Collectors.joining(", "));
        if (collect.isEmpty()) {
            System.out.println("Nobody is going to the party!");
        } else {
            System.out.println(collect + " are going to the party!");
        }

    }
}
