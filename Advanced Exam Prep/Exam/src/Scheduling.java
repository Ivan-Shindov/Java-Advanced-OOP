import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Scheduling {
    public static void main(String[] args) throws IOException {
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));

        ArrayDeque<Integer> stackTasks = new ArrayDeque<>();
        Arrays.stream(buff.readLine().split(", "))
                .mapToInt(Integer::parseInt)
                .forEach(stackTasks::push);

        ArrayDeque<Integer> queueThreads = Arrays.stream(buff.readLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        int taskToKill = Integer.parseInt(buff.readLine());

        while (stackTasks.peek() != taskToKill) {
            int threadValue = queueThreads.peek();
            int taskValue = stackTasks.peek();

            if (threadValue >= taskValue) {
                queueThreads.poll();
                stackTasks.pop();
            } else if (threadValue < taskValue) {
                queueThreads.poll();
            }
        }

        int queueValue = queueThreads.peek();

        System.out.printf("Thread with value %d killed task %d%n",queueValue,taskToKill);

        while (!queueThreads.isEmpty()) {
            System.out.print(queueThreads.poll() + " ");
        }
        System.out.println();
    }
}
