package exercise;
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;

public class AppliedArithmetic {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        Function<int[], int[]> add = a -> Arrays.stream(a).map(e -> e + 1).toArray();
        Function<int[],int[]> multiply = a -> Arrays.stream(a).map(e -> e * 2).toArray();
        Function<int[],int[]> subtract = a -> Arrays.stream(a).map(e -> e - 1).toArray();
        Consumer<int[]> print = a -> Arrays.stream(a).forEach(e -> System.out.print(e + " "));

        String input = scanner.nextLine();

        while (!input.equals("end")) {

            switch (input) {
                case "add":
                    numbers = add.apply(numbers);
                    break;
                case "multiply":
                    numbers = multiply.apply(numbers);
                    break;
                case "subtract":
                    numbers = subtract.apply(numbers);
                    break;
                case "print":
                    print.accept(numbers);
                    System.out.println();
                    break;
            }

            input = scanner.nextLine();
        }
    }
}
