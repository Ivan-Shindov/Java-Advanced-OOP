package parking;

import java.util.ArrayList;
import java.util.List;

public class Parking {
    private List<Car> data;
    private String type;
    private int capacity;

    public Parking(String type,int capacity) {
        this.type = type;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Car car) {
        if (this.data.size() < this.capacity) {
            this.data.add(car);
        }
    }

    public boolean remove(String manufacturer, String model) {
        for (Car car : this.data) {
            if (car.getManufacturer().equals(manufacturer)
                    && car.getModel().equals(model)) {
                this.data.remove(car);
                return true;
            }
        }
        return false;
    }

    public Car getLatestCar() {
//        Car car = new Car("","",-1);
        Car car = null;

        for (Car currentCar : this.data) {
            if (car == null) {
                car = currentCar;
            }
            if (car.getYear() < currentCar.getYear()) {
                car = currentCar;
            }
        }
        return car;
//        if (car.getManufacturer().equals("")
//                && car.getModel().equals("")
//                && car.getYear() == -1) {
//            return null;
//        } else {
//            return car;
//        }
    }

    public Car getCar(String manufacturer, String model) {

        for (Car currentCar : this.data) {
            if (currentCar.getManufacturer().equals(manufacturer)
                    && currentCar.getModel().equals(model)) {
                return currentCar;
            }
        }
        return null;
    }

    public int getCount() {
        return this.data.size();
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("The cars are parked in %s:",this.type))
                .append(System.lineSeparator());
        this.data.forEach(c -> sb.append(c).append(System.lineSeparator()));
        return sb.toString().trim();
    }
}
