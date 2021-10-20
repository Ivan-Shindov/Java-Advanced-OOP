package exercise;

import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeSet;

public class PeriodicTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TreeSet<String> chemicalCompounds = new TreeSet<>();

        int n = Integer.parseInt(scanner.nextLine());

        while (n-- > 0) {
            String[] tokens = scanner.nextLine().split("\\s+");
            chemicalCompounds.addAll(Arrays.asList(tokens));
        }

        System.out.println(String.join(" ",chemicalCompounds));
    }
}
