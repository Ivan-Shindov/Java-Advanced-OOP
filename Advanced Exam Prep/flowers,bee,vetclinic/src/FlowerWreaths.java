import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.stream.Collectors;

public class FlowerWreaths {
    public static void main(String[] args) throws IOException {
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));


        ArrayDeque<Integer> stackLilies = new ArrayDeque<>();
        Arrays.stream(buff.readLine().split(", "))
                .mapToInt(Integer::parseInt)
                .forEach(stackLilies::push);

        ArrayDeque<Integer> rosesQueue = Arrays.stream(buff.readLine().split(", "))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toCollection(ArrayDeque::new));

        int wreaths = 0;
        int storedFlowers = 0;

        while (!stackLilies.isEmpty() && !rosesQueue.isEmpty()) {
            int lilie = stackLilies.peek();
            int rose = rosesQueue.peek();
            int sum = lilie + rose;

            if (sum == 15) {
                wreaths++;
                stackLilies.pop();
                rosesQueue.poll();
            } else if (sum > 15) {
                lilie -= 2;
                stackLilies.pop();
                stackLilies.push(lilie);
            } else {
                storedFlowers += sum;
                stackLilies.pop();
                rosesQueue.poll();
            }
        }

        double total = storedFlowers / 15.0;
        wreaths += total;
        int totalWreaths =  Math.round(wreaths);

        if (totalWreaths >= 5) {
            System.out.printf("You made it, you are going to the competition with %d wreaths!%n",totalWreaths);
        } else {
            int neededWreaths = 5 - totalWreaths;
            System.out.printf("You didn't make it, you need %d wreaths more!%n",neededWreaths);
        }
    }
}
