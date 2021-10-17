package WildFarm;

import WildFarm.Animals.*;
import WildFarm.Food.Food;
import WildFarm.Food.Meat;
import WildFarm.Food.Vegetable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));

        List<Mammal> mammals = new ArrayList<>();

        String evenLine = buff.readLine();

        while (!evenLine.equals("End")) {
            String[] animalTokens = evenLine.split("\\s+");
            String oddLine = buff.readLine();
            String[] foodTokens = oddLine.split("\\s+");

            Mammal mammal = createMammal(animalTokens);

            Food food = createFood(foodTokens);

            mammal.makeSound();

            mammal.eat(food);

            mammals.add(mammal);


            evenLine = buff.readLine();
        }

        for (Mammal mammal : mammals) {
            System.out.println(mammal.toString());
        }

    }

    private static Food createFood(String[] foodTokens) {
        switch (foodTokens[0]) {
            case "Meat":
                return new Meat(Integer.parseInt(foodTokens[1]));
            case "Vegetable":
                return new Vegetable(Integer.parseInt(foodTokens[1]));
            default:
                throw new IllegalStateException("There is no that type of food");
        }
    }

    private static Mammal createMammal(String[] animalTokens) {
        String type = animalTokens[0];
        String name = animalTokens[1];
        Double weight = Double.parseDouble(animalTokens[2]);
        String livingRegion = animalTokens[3];

        switch (type) {
            case "Cat":
                String breed = animalTokens[4];
                return new Cat(name, type, weight, livingRegion, breed);
            case "Tiger":
                return new Tiger(name, type, weight, livingRegion);
            case "Zebra":
                return new Zebra(name, type, weight, livingRegion);
            case "Mouse":
                return new Mouse(name, type, weight, livingRegion);
            default:
                throw new IllegalStateException("Missing mammal");
        }
    }
}
