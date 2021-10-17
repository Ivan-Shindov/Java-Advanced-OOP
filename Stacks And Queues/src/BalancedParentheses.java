import java.util.ArrayDeque;
import java.util.Scanner;

public class BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String parenthesesLine = scanner.nextLine();
        ArrayDeque<Character> stack = new ArrayDeque<>();
        String openingParentheses = "({[";
        boolean areBalanced = true;

        for (int i = 0; i < parenthesesLine.length(); i++) {
            char symbol = parenthesesLine.charAt(i);

            if (openingParentheses.contains(String.valueOf(symbol))) {
                stack.push(symbol);
            } else {
                if (stack.isEmpty()) {
                    areBalanced = false;
                    break;
                }

                char topSymbol = stack.pop();

                if (!(topSymbol == '(' && symbol == ')'
                        || topSymbol == '{' && symbol == '}'
                        || topSymbol == '[' && symbol == ']')) {
                    areBalanced = false;
                    break;

                }
            }
        }

        String result = areBalanced ? "YES" : "NO";
        System.out.println(result);
    }
}
