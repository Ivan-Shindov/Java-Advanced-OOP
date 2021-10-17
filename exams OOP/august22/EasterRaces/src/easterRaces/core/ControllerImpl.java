package easterRaces.core;

import easterRaces.core.interfaces.Controller;
import easterRaces.entities.cars.Car;
import easterRaces.entities.cars.MuscleCar;
import easterRaces.entities.cars.SportsCar;
import easterRaces.entities.drivers.Driver;
import easterRaces.entities.drivers.DriverImpl;
import easterRaces.entities.racers.Race;
import easterRaces.entities.racers.RaceImpl;
import easterRaces.repositories.interfaces.CarRepository;
import easterRaces.repositories.interfaces.DriverRepository;
import easterRaces.repositories.interfaces.RaceRepository;
import easterRaces.repositories.interfaces.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static easterRaces.common.ExceptionMessages.*;
import static easterRaces.common.OutputMessages.*;

public class ControllerImpl implements Controller {
    private Repository<Car> cars;
    private Repository<Race> races;
    private Repository<Driver> drivers;

    public ControllerImpl(Repository<Driver> riderRepository,
                          Repository<Car> motorcycleRepository, Repository<Race> raceRepository) {

        this.drivers = riderRepository;
        this.cars = motorcycleRepository;
        this.races = raceRepository;
    }

    @Override
    public String createDriver(String driver) {

        Driver driver1 = new DriverImpl(driver);
        this.drivers.add(driver1);
        return String.format(DRIVER_CREATED, driver);
    }

    @Override
    public String createCar(String type, String model,
                            int horsePower) {
        Car car;
        switch (type) {
            case "Muscle":
                type = "MuscleCar";
                car = new MuscleCar(model, horsePower);
                break;
            case "Sports":
                type = "SportsCar";
                car = new SportsCar(model, horsePower);
                break;
            default: car = null;
        }

        if (this.cars.getAll().contains(car)) {
            throw new IllegalArgumentException(String.format(CAR_EXISTS, model));
        }

        this.cars.add(car);
        return String.format(CAR_CREATED,type, model);
    }

    @Override
    public String addCarToDriver(String driverName, String carModel) {

        Driver driver = this.drivers.getByName(driverName);
        if (!this.drivers.getAll().contains(driver) || driver == null) {
            throw new IllegalArgumentException(String.format(DRIVER_NOT_FOUND, driverName));
        }

        Car car = this.cars.getByName(carModel);

        if (car == null) {
            throw new IllegalArgumentException(String.format(CAR_NOT_FOUND, carModel));
        }

        driver.addCar(car);
        return String.format(CAR_ADDED, driverName, carModel);
    }

    @Override
    public String addDriverToRace(String raceName, String driverName) {

        Race race = this.races.getByName(raceName);

        if (race == null) {
            throw new IllegalArgumentException(String.format(RACE_NOT_FOUND, raceName));
        }

        Driver driver = this.drivers.getByName(driverName);
        if (driver == null) {
            throw new IllegalArgumentException(String.format(DRIVER_NOT_FOUND, driverName));
        }

        race.addDriver(driver);
        return String.format(DRIVER_ADDED, driverName, raceName);
    }

    @Override
    public String startRace(String raceName) {

        Race race = this.races.getByName(raceName);
        if (race == null) {
            throw new IllegalArgumentException(String.format(RACE_NOT_FOUND, raceName));
        }

        int laps = race.getLaps();

        List<Driver> driversList = this.drivers.getAll()
                .stream()
                .sorted(Comparator.comparingDouble(d -> d.getCar().calculateRacePoints(laps)))
                .collect(Collectors.toList());

        if (driversList.size() < 3) {
            throw new IllegalArgumentException(String.format(RACE_INVALID,raceName,3));
        }

        Collections.reverse(driversList);

        List<Driver> threeSortedDrivers = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            threeSortedDrivers.add(i,driversList.get(i));
        }

        this.races.remove(race);
        StringBuilder sb = new StringBuilder();

        sb.append(String.format(DRIVER_FIRST_POSITION,threeSortedDrivers.get(0).getName(),raceName))
                .append(System.lineSeparator())
                .append(String.format(DRIVER_SECOND_POSITION,threeSortedDrivers.get(1).getName(),raceName))
                .append(System.lineSeparator())
                .append(String.format(DRIVER_THIRD_POSITION,threeSortedDrivers.get(2).getName(),raceName))
                .append(System.lineSeparator());
        return sb.toString().trim();

    }

    @Override
    public String createRace(String name, int laps) {

        Race race = new RaceImpl(name,laps);

        if (this.races.getAll().contains(race)) {
            throw new IllegalArgumentException(String.format(RACE_EXISTS,name));
        }

        this.races.add(race);
        return String.format(RACE_CREATED,name);
    }
}
