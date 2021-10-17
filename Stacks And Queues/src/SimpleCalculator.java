import java.util.ArrayDeque;
import java.util.Scanner;


public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        String[] input = scanner.nextLine().split("\\s+");

        for (int i = 0; i < input.length; i++) {
            String symbol = input[i];

            if (symbol.equals("+")) {
                int nextDigit = Integer.parseInt(input[i + 1]);
                int total = stack.pop() + nextDigit;
                stack.push(total);
                i++;
            } else if (symbol.equals("-")) {
                int nextDigit = Integer.parseInt(input[i + 1]);
                int total = stack.pop() - nextDigit;
                stack.push(total);
                i++;
            } else {
                int digit = Integer.parseInt(symbol);
                stack.push(digit);
            }
        }
        System.out.println(stack.pop());
    }
}
