package easterRaces.entities.cars;

public class MuscleCar extends BaseCar {
    private static final int DEFAULT_CUBIC_CENTIMETERS = 5000;


    public MuscleCar(String model, int horsePower) {
        super(model, horsePower, DEFAULT_CUBIC_CENTIMETERS);
    }

}
