package WildFarm.Animals;

import WildFarm.Food.Food;
import WildFarm.Food.Vegetable;

import java.text.DecimalFormat;

public class Zebra extends Mammal {

    public Zebra(String animalName, String animalType, Double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println("Zs");
    }

    @Override
    public void eat(Food food) {
        if (food instanceof Vegetable) {
            super.setFoodEaten(food.getQuantity());
        } else {
            System.out.printf("%ss are not eating that type of food!%n",
                    super.getAnimalType());
        }
    }

    @Override
    public String toString() {
        DecimalFormat formatter = new DecimalFormat("##.##");
        return String.format("%s[%s, %s, %s, %d]",
                super.getAnimalType(),
                super.getAnimalName(),
                formatter.format(super.getAnimalWeight()),
                super.getLivingRegion(),
                super.getFoodEaten());
    }
}
