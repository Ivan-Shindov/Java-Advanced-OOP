import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> stack = new ArrayDeque<>();

        String navigation = scanner.nextLine();

        String current = "";

        while (!navigation.equals("Home")) {

            if (navigation.equals("back")) {
                if (stack.isEmpty()) {
                    System.out.println("no previous URLs");
                    navigation = scanner.nextLine();
                    continue;
                } else {
                    current = stack.pop();
                }

            } else {
                if (!current.isEmpty()) {
                    stack.push(current);
                }
                current = navigation;
            }

            System.out.println(current);

            navigation = scanner.nextLine();
        }
    }
}
