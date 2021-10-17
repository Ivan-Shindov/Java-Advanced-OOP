package Vehicles;

public abstract class Vehicle {
    private String type;
    private double fuelQuantity;
    private double fuelConsumption;
    private int tankCapacity;


    protected Vehicle (String type, double fuelQuantity,
                       double fuelConsumption,int tankCapacity) {
        this.type = type;
        this.setFuelQuantity(fuelQuantity);
        this.fuelConsumption = fuelConsumption;
        this.tankCapacity = tankCapacity;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public double getFuelQuantity() {
        return fuelQuantity;
    }

    public String getType() {
        return type;
    }

    public int getTankCapacity() {
        return tankCapacity;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public void setFuelQuantity(double fuelQuantity) {
        if (fuelQuantity <= 0) {
            throw new IllegalArgumentException("Fuel must be a positive number");
        }
        this.fuelQuantity = fuelQuantity;
    }

    public abstract void drive(double distance);

    public abstract void refuel(double liters);
}
