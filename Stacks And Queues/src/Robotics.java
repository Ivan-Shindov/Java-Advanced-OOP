import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class Robotics {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] inputArr = scanner.nextLine().split(";");
        String[] robots = new String[inputArr.length];
        int[] processTimes = new int[inputArr.length];
        int[] currentRobotTime = new int[inputArr.length];

        for (int i = 0; i < inputArr.length; i++) {
            String[] tokens = inputArr[i].split("-");
            robots[i] = tokens[0];
            processTimes[i] = Integer.parseInt(tokens[1]);
            currentRobotTime[i] = 0;
        }

        int[] timeInput = Arrays.stream(scanner.nextLine().split(":"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int time = timeInput[0] * 3600 + timeInput[1] * 60 + timeInput[2];

        String product;

        ArrayDeque<String> queueProducts = new ArrayDeque<>();

        while (!"End".equals(product = scanner.nextLine())) {
            queueProducts.offer(product);
        }

        while (!queueProducts.isEmpty()) {

            time++;
            String detail = queueProducts.poll();

            boolean isTaken = false;

            for (int i = 0; i < robots.length; i++) {

                if (currentRobotTime[i] == 0 && !isTaken) {
                    currentRobotTime[i] = processTimes[i];
                    isTaken = true;
                    System.out.printf(
                            "%s - %s [%s]%n", robots[i], detail, getTime(time));
                }

                if (currentRobotTime[i] > 0) {
                    currentRobotTime[i]--;
                }
            }

            if (!isTaken) {
                queueProducts.offer(detail);
            }

        }
    }

    private static String getTime(int time) {
        int hours = time / 3600 % 24;
        int minutes = time / 60 % 60;
        int seconds = time % 60;

        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }
}
