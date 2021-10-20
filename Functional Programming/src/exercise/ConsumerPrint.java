package exercise;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class ConsumerPrint {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Consumer<String> consumer = s -> System.out.println(s);

        String[] words = scanner.nextLine().split("\\s+");

        Arrays.stream(words)
                .forEach(consumer);
    }
}

