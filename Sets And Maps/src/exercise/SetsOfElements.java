package exercise;

import java.util.LinkedHashSet;
import java.util.Scanner;

public class SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstSize = scanner.nextInt();
        int secondSize = scanner.nextInt();
        scanner.nextLine();

        LinkedHashSet<Integer> firstSet = new LinkedHashSet<>(firstSize);
        LinkedHashSet<Integer> secondSet = new LinkedHashSet<>(secondSize);

        for (int i = 0; i < firstSize; i++) {
            int number = Integer.parseInt(scanner.nextLine());
            firstSet.add(number);
        }

        for (int i = 0; i < secondSize; i++) {
            int number = Integer.parseInt(scanner.nextLine());
            secondSet.add(number);
        }

        firstSet.retainAll(secondSet);

        firstSet.forEach(e -> System.out.print(e + " "));
    }
}

