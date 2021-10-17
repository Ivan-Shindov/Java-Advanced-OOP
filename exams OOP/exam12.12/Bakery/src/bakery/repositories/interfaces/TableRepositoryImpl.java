package bakery.repositories.interfaces;

import bakery.entities.tables.interfaces.Table;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class TableRepositoryImpl<T extends Table> implements TableRepository<T>{
    private Collection<T> models;

    public TableRepositoryImpl() {
        this.models = new ArrayList<>();
    }

    @Override
    public Collection<T> getAll() {
        return Collections.unmodifiableCollection(this.models);
    }

    @Override
    public void add(T t) {
        this.models.add(t);
    }

    @Override
    public T getByNumber(int number) {
        for (T model : this.models) {
            if (model.getTableNumber() == number) {
                return model;
            }
        }
        return null;
    }
}
