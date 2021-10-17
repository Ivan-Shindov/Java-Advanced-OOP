package bakery.entities.bakedFoods.interfaces;

public class Cake extends BaseFood {
    private static final int InitialCakePortion = 245;


    public Cake(String name, double price) {
        super(name, InitialCakePortion, price);
    }
}
