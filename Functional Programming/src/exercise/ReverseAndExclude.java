package exercise;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;

public class ReverseAndExclude {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> nums = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Collections.reverse(nums);

        int n = Integer.parseInt(scanner.nextLine());

        BiConsumer<List<Integer>, Integer> consumer = (list,num) -> list.stream()
                .filter(number -> number % num != 0)
                .forEach(e -> System.out.print(e + " "));

        consumer.accept(nums,n);
    }
}
