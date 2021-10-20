package exercise;
import java.util.*;

public class HandsOfCards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Set<String>> playersPoints = new LinkedHashMap<>();

        String input = scanner.nextLine();

        while (!input.equals("JOKER")) {
            String name = input.split(": ")[0];
            String[] cardsArr = input.split(": ")[1].split(", ");
            Set<String> cards = new LinkedHashSet<>(Arrays.asList(cardsArr));

            if (!playersPoints.containsKey(name)) {
                playersPoints.put(name, cards);
            } else {
                Set<String> currentCards = playersPoints.get(name);
                currentCards.addAll(cards);
                playersPoints.put(name,currentCards);
            }

            input = scanner.nextLine();
        }

        for (Map.Entry<String, Set<String>> entry : playersPoints.entrySet()) {
            int points = calculatePoints(entry.getValue());
            System.out.printf("%s: %d%n",entry.getKey(),points);
        }
    }

    private static int calculatePoints(Set<String> value) {
        int sum = 0;
        Map<Character,Integer> cards = getMap(value);
        for (String val : value) {
            char firstSymbol = val.charAt(0);
            char secondSymbol = val.charAt(1);

            if (firstSymbol == '1' && secondSymbol == '0') {
                sum += 10 * cards.get(val.charAt(2));
                continue;
            }

            sum += cards.get(firstSymbol) * cards.get(secondSymbol);
        }
        return sum;
    }

    private static Map<Character, Integer> getMap(Set<String> value) {
        Map<Character,Integer> map = new HashMap<>();

        map.put('2',2);
        map.put('3',3);
        map.put('4',4);
        map.put('5',5);
        map.put('6',6);
        map.put('7',7);
        map.put('8',8);
        map.put('9',9);
        map.put('J',11);
        map.put('Q',12);
        map.put('K',13);
        map.put('A',14);
        map.put('S',4);
        map.put('H',3);
        map.put('D',2);
        map.put('C',1);

        return map;
    }
}

