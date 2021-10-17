import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        ArrayDeque<String> stack = new ArrayDeque<>();

        stack.push("");

        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");

            int command = Integer.parseInt(tokens[0]);

            switch (command) {
                case 1:
                    StringBuilder text = new StringBuilder();
                    String addToText = tokens[1];
                    text.append(stack.peek()).append(addToText);
                    stack.push(text.toString());
                    break;
                case 2:
                    int count = Integer.parseInt(tokens[1]);
                    String peekedText = stack.peek();
                    stack.push(peekedText.substring(0,peekedText.length() - count));
                    break;
                case 3:
                    int index = Integer.parseInt(tokens[1]);
                    char element = stack.peek().charAt(index - 1);
                    System.out.println(element);
                    break;
                case 4:
                    stack.pop();
                    break;
            }
        }
    }
}
