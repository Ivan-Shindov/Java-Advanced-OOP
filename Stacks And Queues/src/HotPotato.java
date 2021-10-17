import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class HotPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] line = scanner.nextLine().split("\\s+");
        int n = Integer.parseInt(scanner.nextLine());
        ArrayDeque<String> queue = new ArrayDeque<>(Arrays.asList(line));
        int counter = 1;

        while (queue.size() > 1) {

            String currentChild = queue.poll();

            if (counter % n != 0) {
                queue.offer(currentChild);
            } else {
                System.out.println("Removed " + currentChild);
            }

            counter++;
        }

        System.out.println("Last is " + queue.poll());

    }
}
