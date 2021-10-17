import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.stream.Collectors;

public class DatingApp {
    public static void main(String[] args) throws IOException {
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));

        ArrayDeque<Integer> malesStack = new ArrayDeque<>();
        Arrays.stream(buff.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(malesStack::push);
        ArrayDeque<Integer> femalesQueue = Arrays.stream(buff.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toCollection(ArrayDeque::new));

        int matches = 0;

        while (!malesStack.isEmpty() && !femalesQueue.isEmpty()) {
            int maleInt = malesStack.peek();
            int femaleInt = femalesQueue.peek();

            if (maleInt <= 0) {
                malesStack.pop();
                continue;
            }
            if (femaleInt <= 0) {
                femalesQueue.poll();
                continue;
            }

            if (maleInt % 25 == 0) {
                malesStack.pop();
                malesStack.pop();
                continue;
            }
            if (femaleInt % 25 == 0) {
                femalesQueue.poll();
                femalesQueue.poll();
                continue;
            }

            if (maleInt == femaleInt) {
                matches++;
                malesStack.pop();
                femalesQueue.poll();
            } else {
                femalesQueue.poll();
                maleInt -= 2;
                malesStack.pop();
                malesStack.push(maleInt);
            }
        }

        System.out.printf("Matches: %d%n",matches);

        if (malesStack.isEmpty()) {
            System.out.printf("Males left: none%n");
        } else {
            System.out.print("Males left: ");
            String collect = malesStack.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(", "));
            System.out.println(collect);
        }

        if (femalesQueue.isEmpty()) {
            System.out.println("Females left: none");
        } else {
            System.out.print("Females left: ");
            String collect = femalesQueue.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(", "));
            System.out.println(collect);
        }

    }
}
