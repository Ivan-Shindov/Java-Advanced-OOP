package lab;
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class SumNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] nums = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();

        Function<int[], String> getCounts =
                arr -> String.format("Count = %d", arr.length);

        System.out.println(getCounts.apply(nums));

        Function<int[], String> getSumString =
                arr -> {
                    int sum = Arrays.stream(arr).sum();
                    return "Sum = " + sum;
                };

        System.out.println(getSumString.apply(nums));
    }
}
