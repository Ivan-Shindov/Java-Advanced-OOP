package lab;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.UnaryOperator;

public class AddVAT {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        UnaryOperator<Double> vatAdd = price -> price * 1.20;

        String[] input = scanner.nextLine().split(", ");
        System.out.println("Prices with VAT:");

        Arrays.stream(input)
                .mapToDouble(e -> vatAdd.apply(Double.parseDouble(e)))
                .forEach(e -> System.out.printf("%.2f%n",e));
    }
}