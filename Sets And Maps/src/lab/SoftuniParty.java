package lab;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class SoftuniParty {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String guest = scanner.nextLine();

        Set<String> vips = new TreeSet<>();
        Set<String> regulars = new TreeSet<>();

        while (!guest.equals("PARTY")) {
            char firstSymbol = guest.charAt(0);
            if (Character.isDigit(firstSymbol)) {
                vips.add(guest);
            } else {
                regulars.add(guest);
            }

            guest = scanner.nextLine();
        }

        while (!guest.equals("END")) {

            vips.remove(guest);
            regulars.remove(guest);

            guest = scanner.nextLine();
        }

        System.out.println(vips.size() + regulars.size());
        if (!vips.isEmpty()) {
            vips.forEach(n -> System.out.println(n));
        }
        if (!regulars.isEmpty()) {
            regulars.forEach(System.out::println);
        }
    }
}
