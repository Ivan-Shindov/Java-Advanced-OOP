package easterRaces.entities.cars;

public class SportsCar extends BaseCar {
    private static final int DEFAULT_CUBIC_CENTIMETERS = 3000;

    public SportsCar(String model, int horsePower) {
        super(model, horsePower, DEFAULT_CUBIC_CENTIMETERS);
    }


}
