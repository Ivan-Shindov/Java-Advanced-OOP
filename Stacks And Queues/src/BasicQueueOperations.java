import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class BasicQueueOperations {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] inputArr = scanner.nextLine().split("\\s+");
        int numsToAdd = Integer.parseInt(inputArr[0]);
        int numsToRemove = Integer.parseInt(inputArr[1]);
        int target = Integer.parseInt(inputArr[2]);

        ArrayDeque<Integer> queueNumbers = new ArrayDeque<>();

        for (int i = 0; i < numsToAdd; i++) {
            int currentNum = scanner.nextInt();
            queueNumbers.offer(currentNum);
        }

        for (int i = 0; i < numsToRemove; i++) {
            queueNumbers.poll();
        }

        if (queueNumbers.contains(target)) {
            System.out.println("true");

        } else if (queueNumbers.isEmpty()) {
            System.out.println(0);

        } else {
            int min = Collections.min(queueNumbers);
            System.out.println(min);
        }
    }
}
