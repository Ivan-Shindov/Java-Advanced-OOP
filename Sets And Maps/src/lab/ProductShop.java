package lab;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ProductShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TreeMap<String, Map<String,Double>> shopList = new TreeMap<>();

        String input = scanner.nextLine();

        while (!input.equals("Revision")) {

            String[] tokens = input.split(", ");
            String shop = tokens[0];
            String product = tokens[1];
            double price = Double.parseDouble(tokens[2]);

            shopList.putIfAbsent(shop, new LinkedHashMap<>());
            shopList.get(shop).put(product,price);

            input = scanner.nextLine();
        }

        shopList.entrySet().stream()
                .forEach(e -> {
                    System.out.println(e.getKey() + "->");
                    e.getValue().entrySet()
                            .stream()
                            .forEach(p -> System.out.printf("Product: %s, Price: %.1f%n",
                                    p.getKey(),p.getValue()));
                });
    }
}