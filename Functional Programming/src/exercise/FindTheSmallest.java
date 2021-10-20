package exercise;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class FindTheSmallest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] nums = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        Function<int[],Integer> function = a -> {
            int min = Integer.MAX_VALUE;
            int index = -1;
            for (int i = 0; i < a.length; i++) {
                if (a[i] <= min) {
                    min = a[i];
                    index = i;
                }
            }
            return index;
        };

        System.out.println(function.apply(nums));
    }
}
