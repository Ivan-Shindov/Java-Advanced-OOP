import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;


public class BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] inputArr = scanner.nextLine().split("\\s+");
        int nElementsToPush = Integer.parseInt(inputArr[0]);
        int elementsToPop = Integer.parseInt(inputArr[1]);
        int target = Integer.parseInt(inputArr[2]);

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < nElementsToPush; i++) {
            int num = scanner.nextInt();
            stack.push(num);
        }

        for (int i = 0; i < elementsToPop; i++) {
            stack.pop();
        }

        if (stack.contains(target)) {
            System.out.println("true");

        } else if (stack.isEmpty()) {
            System.out.println(0);

        } else {
            int min = Collections.min(stack);
            System.out.println(min);
        }
    }
}
