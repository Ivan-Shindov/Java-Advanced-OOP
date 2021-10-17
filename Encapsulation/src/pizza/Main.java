package pizza;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));

        String[] inputPizza = buff.readLine().split("\\s+");

        Pizza pizza;
        try {
            pizza = new Pizza(inputPizza[1], Integer.parseInt(inputPizza[2]));
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
            return;
        }

        String[] inputDough = buff.readLine().split("\\s+");
        Dough dough;
        try {
            dough = new Dough(inputDough[1], inputDough[2], Double.parseDouble(inputDough[3]));
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
            return;
        }

        pizza.setDough(dough);

        String input = buff.readLine();

        while (!input.equals("END")) {

            String[] tokens = input.split("\\s+");

            try {
                Topping topping = new Topping(tokens[1], Double.parseDouble(tokens[2]));
                pizza.addTopping(topping);
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
                return;
            }

            input = buff.readLine();
        }

        System.out.println(pizza.toString());
    }
}
