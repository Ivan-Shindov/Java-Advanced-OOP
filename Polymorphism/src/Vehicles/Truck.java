package Vehicles;

import java.text.DecimalFormat;

public class Truck extends Vehicle {
    private final double AIR_CONDITIONER_CONSUMPTION = 1.6;

    public Truck(String type, double fuelQuantity, double fuelConsumption, int tankCapacity) {
        super(type, fuelQuantity, fuelConsumption, tankCapacity);
    }


    @Override
    public void drive(double distance) {
        double currentConsumption = super.getFuelConsumption()
                + AIR_CONDITIONER_CONSUMPTION;
        double neededFuel = distance * currentConsumption;

        if (neededFuel > super.getFuelQuantity()) {
            System.out.println("Truck needs refueling");
        } else {
            double fuelQuantity = super.getFuelQuantity() - neededFuel;

            if (fuelQuantity <= 0) {
                System.out.println("Fuel must be a positive number");
            } else {
                DecimalFormat formatter = new DecimalFormat("##.##");

                System.out.printf("%s travelled %s km%n",
                        super.getType(),
                        formatter.format(distance));

                super.setFuelQuantity(fuelQuantity);
            }
        }
    }

    @Override
    public void refuel(double liters) {
        if (liters <= 0) {
            System.out.println("Fuel must be a positive number");

        } else if (super.getFuelQuantity() + liters > super.getTankCapacity()) {
            System.out.println("Cannot fit fuel in tank");

        } else {
            super.setFuelQuantity(super.getFuelQuantity() + (liters * 0.95));
        }
    }

    @Override
    public String toString() {
        return
                String.format("%s: %.2f",
                        super.getType(),
                        super.getFuelQuantity());
    }
}
