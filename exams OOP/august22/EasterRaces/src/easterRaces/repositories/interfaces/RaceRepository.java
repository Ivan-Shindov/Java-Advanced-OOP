package easterRaces.repositories.interfaces;

import easterRaces.entities.racers.Race;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import static easterRaces.common.ExceptionMessages.RACE_EXISTS;


public class RaceRepository<T extends Race> implements Repository<T> {
    private Collection<T> models;

    public RaceRepository() {
        this.models = new ArrayList<>();
    }

    @Override
    public T getByName(String name) {
        for (T model : this.models) {
            if (model.getName().equals(name)) {
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
            if (t.getName().equals(model.getName())) {
                throw new IllegalArgumentException(String.format(RACE_EXISTS, model.getName()));
            }
        }

        this.models.add(model);
    }

    @Override
    public boolean remove(T model) {
        return this.models.remove(model);
    }
}
