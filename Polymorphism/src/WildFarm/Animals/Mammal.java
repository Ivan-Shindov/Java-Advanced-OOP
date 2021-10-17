package WildFarm.Animals;

import WildFarm.Food.Food;

public abstract class Mammal extends Animal {
    private String livingRegion;

    protected Mammal(String animalName, String animalType,
                  Double animalWeight,String livingRegion) {
        super(animalName, animalType, animalWeight);
        this.livingRegion = livingRegion;
    }

    public String getLivingRegion() {
        return livingRegion;
    }

    public abstract void makeSound();

    public abstract void eat(Food food);

}
