package parking;

public class Main {
    public static void main(String[] args) {
// Initialize the repository
        Parking parking = new Parking("Underground parking garage", 5);

        Car car = new Car("BMW", "X5", 2020);
        parking.add(car);
// Get Latest Car
        Car latestCar = parking.getLatestCar();
        System.out.println(latestCar); // Peugeot 307 (2011)

    }
}
