import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Lootbox {
    public static void main(String[] args) throws IOException {
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));

        ArrayDeque<Integer> firstLootBoxQueue = Arrays.stream(buff.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<Integer> secondLootBoxStack = new ArrayDeque<>();

        Arrays.stream(buff.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(secondLootBoxStack::push);

        int collection = 0;

        while (!firstLootBoxQueue.isEmpty() && !secondLootBoxStack.isEmpty()) {
            int sum = firstLootBoxQueue.peek() + secondLootBoxStack.peek();

            if (sum % 2 == 0) {
                collection += sum;
                firstLootBoxQueue.poll();
                secondLootBoxStack.pop();
            } else {
                int removedItem = secondLootBoxStack.pop();
                firstLootBoxQueue.offer(removedItem);
            }
        }

        if (firstLootBoxQueue.isEmpty()) {
            System.out.println("First lootbox is empty");
        }

        if (secondLootBoxStack.isEmpty()) {
            System.out.println("Second lootbox is empty");
        }

        if (collection >= 100) {
            System.out.printf("Your loot was epic! Value: %d%n",collection);
        } else {
            System.out.printf("Your loot was poor... Value: %d%n",collection);
        }

    }
}
