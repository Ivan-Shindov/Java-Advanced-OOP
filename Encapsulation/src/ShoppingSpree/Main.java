package ShoppingSpree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Person> people;
        Map<String, Product> products;

        try {
            people = getPeople(buff);
            products = getProduct(buff);

        } catch (IllegalStateException ex) {
            System.out.println(ex.getMessage());
            return;
        }

        String input;

        while (!(input = buff.readLine()).equals("END")) {
            String[] tokens = input.split("\\s+");
            String personName = tokens[0];
            String productName = tokens[1];

            try {
                Person person = people.get(personName);
                person.buyProduct(products.get(productName));
                System.out.printf("%s bought %s%n", person.getName(), productName);
            } catch (IllegalStateException ex) {
                System.out.println(ex.getMessage());
            }
        }

        for (Person person : people.values()) {
            System.out.println(person);
        }
    }



    private static Map<String, Product> getProduct(BufferedReader buff) throws IOException {
        Map<String, Product> products = new LinkedHashMap<>();

        String[] tokens = buff.readLine().split(";");
        for (String token : tokens) {
            String[] personInfo = token.split("=");

            Product product = new Product(personInfo[0], Double.parseDouble(personInfo[1]));
            products.put(product.getName(), product);
        }
        return products;
    }

    private static Map<String, Person> getPeople(BufferedReader buff) throws IOException {
        Map<String, Person> people = new LinkedHashMap<>();

        String[] tokens = buff.readLine().split(";");
        for (String token : tokens) {
            String[] personInfo = token.split("=");

            Person person = new Person(personInfo[0], Double.parseDouble(personInfo[1]));

            people.put(person.getName(), person);
        }
        return people;
    }
}
