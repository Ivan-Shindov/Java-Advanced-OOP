import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistoryUpgrade {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String navigation = scanner.nextLine();

        ArrayDeque<String> stackForward = new ArrayDeque<>();
        ArrayDeque<String> stackBack = new ArrayDeque<>();

        while (!navigation.equals("Home")) {

            if (navigation.equals("back")) {
                if (stackBack.size() <= 1) {
                    System.out.println("no previous URLs");
                } else {
                    stackForward.push(stackBack.peek());
                    stackBack.pop();
                    System.out.println(stackBack.peek());
                }

            } else if (navigation.equals("forward")) {
                if (stackForward.isEmpty()) {
                    System.out.println("no next URLs");
                } else {
                    System.out.println(stackForward.peek());
                    stackBack.push(stackForward.pop());
                }
            } else {
                System.out.println(navigation);
                stackBack.push(navigation);
                stackForward.clear();
            }
            navigation = scanner.nextLine();
        }
    }
}