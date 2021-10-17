import java.util.*;

public class MathPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] children = scanner.nextLine().split("\\s+");
        int n = Integer.parseInt(scanner.nextLine());

        ArrayDeque<String> queue = new ArrayDeque<>();

        Collections.addAll(queue, children);
        int cycles = 1;
        while (queue.size() > 1) {
            for (int i = 1; i < n; i++) {
                String child = queue.remove();
                queue.offer(child);
            }

            String name = queue.peek();
            if (!isPrime(cycles)) {
                System.out.println("Removed " + name);
                queue.poll();
            } else {
                System.out.println("Prime " + name);

            }
            cycles++;
        }

        System.out.println("Last is " + queue.poll());
    }

    private static boolean isPrime(int cycles) {
        if (cycles == 1) {
            return false;
        }
        for (int i = 2; i < cycles; i++) {
            if (cycles % i == 0) {
                return false;
            }
        }

        return true;
    }
}
