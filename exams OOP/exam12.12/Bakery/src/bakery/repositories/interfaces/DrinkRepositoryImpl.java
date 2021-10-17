package bakery.repositories.interfaces;

import bakery.entities.drinks.interfaces.Drink;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;


public class DrinkRepositoryImpl<T extends Drink> implements DrinkRepository<T>{
    private Collection<T> models;

    public DrinkRepositoryImpl() {
        this.models = new ArrayList<>();
    }
    @Override
    public T getByNameAndBrand(String drinkName,
                               String drinkBrand) {

        for (T model : this.models) {
            if (model.getName().equals(drinkName) &&
                model.getBrand().equals(drinkBrand)) {
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
    public void add(T t) {
        this.models.add(t);
    }
}
