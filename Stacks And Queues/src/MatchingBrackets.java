import java.util.ArrayDeque;
import java.util.Scanner;

public class MatchingBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        String expression = scanner.nextLine();

        for (int i = 0; i < expression.length(); i++) {
            char symbol = expression.charAt(i);
            if (symbol == '(') {
                stack.push(i);
            } else if (symbol == ')') {
                int startIndex = stack.pop();
                int endIndex = i + 1;
                System.out.println(expression.substring(startIndex, endIndex));
            }
        }
    }
}
