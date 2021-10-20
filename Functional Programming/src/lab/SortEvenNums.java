package lab;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SortEvenNums {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(", ");

        String output = Arrays.stream(input)
                .mapToInt(e -> Integer.parseInt(e))
                .filter(num -> num % 2 == 0)
                .boxed()
                .map(e -> String.valueOf(e))
                .collect(Collectors.joining(", "));

        System.out.println(output);

        if (!output.isEmpty()) {
            output = Arrays.stream(output.split(", "))
                    .mapToInt(Integer::parseInt)
                    .sorted()
                    .mapToObj(String::valueOf)
                    .collect(Collectors.joining(", "));
        }


        System.out.println(output);


    }
}