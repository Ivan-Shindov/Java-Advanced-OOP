package lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CountUppercase {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        Predicate<String> predicate = w -> Character.isUpperCase(w.charAt(0));

        List<String> list = Arrays.stream(text.split("\\s+"))
                .filter(predicate)
                .collect(Collectors.toList());

        System.out.println(list.size());

        System.out.println(list.stream()
                .collect(Collectors.joining(System.lineSeparator())));
    }
}