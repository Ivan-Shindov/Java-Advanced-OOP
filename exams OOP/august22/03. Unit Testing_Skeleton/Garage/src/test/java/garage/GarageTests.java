package garage;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class GarageTests {

    @Test
    public void testConstructor() {
        Garage garage = new Garage();
        assertNotNull(garage);
        assertEquals(0, garage.getCars().size());
        garage.addCar(new Car("ford",100,250.0));
        garage.addCar(new Car("ford12",1002,2520.0));
        assertEquals(2, garage.getCars().size());
    }

    @Test
    public void testGetCarsReturnList() {
        Garage garage = new Garage();
        garage.addCar(new Car("ford",100,250.0));
        garage.addCar(new Car("ford12",1002,2520.0));
        List<Car> cars = garage.getCars();
        assertEquals(cars.get(0),garage.getCars().get(0));
        assertEquals(cars.get(1),garage.getCars().get(1));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testGetCarsThrowsException() {
        Garage garage = new Garage();
        garage.getCars().add(new Car("ford",100,250.0));
    }

    @Test
    public void testGetCountReturnCorrectCountElements() {
        Garage garage = new Garage();
        garage.addCar(new Car("ford",100,250.0));
        garage.addCar(new Car("ford12",1002,2520.0));
        assertEquals(2,garage.getCount());
    }

    @Test
    public void testFindAllCarsWithGivenSpeedAbove() {
        Garage garage = new Garage();
        garage.addCar(new Car("ford",100,250.0));
        garage.addCar(new Car("ford12",1002,2520.0));
        garage.addCar(new Car("ford123",1022,2510.0));

        List<Car> cars = garage.findAllCarsWithMaxSpeedAbove(100);
        assertEquals(2,cars.size());
    }

    @Test
    public void testGetMostExpensiveCarReturnsCorrectCar() {
        Garage garage = new Garage();
        garage.addCar(new Car("ford",100,250.0));
        garage.addCar(new Car("ford12",1002,2520.0));
        garage.addCar(new Car("ford123",1022,2510.0));
        Car car = garage.getTheMostExpensiveCar();
        assertEquals(car.getPrice(), garage.getCars().get(1).getPrice(),0);
    }

    @Test
    public void testGetMostExpensiveCarReturnsNull() {
        Garage garage = new Garage();
        Car car = garage.getTheMostExpensiveCar();
        assertNull(car);
    }

    @Test
    public void testGetAllCarsByBrand() {
        Garage garage = new Garage();
        garage.addCar(new Car("ford",100,250.0));
        garage.addCar(new Car("ford",120,230.0));
        garage.addCar(new Car("ford12",1002,2520.0));
        garage.addCar(new Car("ford123",1022,2510.0));
        List<Car> carsByBrand = garage.findAllCarsByBrand("ford");
        assertEquals(2,carsByBrand.size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddCarWithNullValue() {
        Garage garage = new Garage();
        garage.addCar(new Car("ford",100,250.0));
        garage.addCar(null);
    }
}