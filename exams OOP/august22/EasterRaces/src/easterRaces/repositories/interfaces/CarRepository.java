package easterRaces.repositories.interfaces;

import easterRaces.entities.cars.Car;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import static easterRaces.common.ExceptionMessages.CAR_EXISTS;


public class CarRepository<T extends Car> implements Repository<T> {
    private Collection<T> models;

    public CarRepository() {
        this.models = new ArrayList<>();
    }

    @Override
    public T getByName(String name) {
        for (T model : this.models) {
            if (model.getModel().equals(name)) {
                return model;
            }
        }
        return null;
    }

    @Override
    public Collection<T> getAll() {
        return Collections.unmodifiableCollection(this.models);
    }

    @Override
    public void add(T model) {
        for (T t : this.models) {
            if (t.getModel().equals(model.getModel())) {
                throw new IllegalArgumentException(String.format(CAR_EXISTS,
                        model.getModel()));
            }
        }
        this.models.add(model);
    }

    @Override
    public boolean remove(T model) {
        return this.models.remove(model);
    }
}
