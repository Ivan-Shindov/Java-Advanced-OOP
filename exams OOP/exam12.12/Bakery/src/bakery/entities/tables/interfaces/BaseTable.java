package bakery.entities.tables.interfaces;

import bakery.entities.bakedFoods.interfaces.BakedFood;
import bakery.entities.drinks.interfaces.Drink;

import java.util.ArrayList;
import java.util.Collection;

import static bakery.common.ExceptionMessages.*;

public abstract class BaseTable implements Table {

    private Collection<BakedFood> foodOrders;
    private Collection<Drink> drinkOrders;
    private int tableNumber;
    private int capacity;
    private int numberOfPeople;
    private double pricePerPerson;
    private boolean isReserved;
    private double price;

    protected BaseTable(int tableNumber, int capacity,
                        double pricePerPerson) {
        this.foodOrders = new ArrayList<>();
        this.drinkOrders = new ArrayList<>();
        this.tableNumber = tableNumber;
        this.setCapacity(capacity);
        this.numberOfPeople = 0;
        this.pricePerPerson = pricePerPerson;
        this.isReserved = false;
        this.price = 0.0;
    }

    private void setCapacity(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException(INVALID_TABLE_CAPACITY);
        }
        this.capacity = capacity;
    }

    private Collection<BakedFood> getFoodOrders() {
        return this.foodOrders;
    }

    private Collection<Drink> getDrinkOrders() {
        return this.drinkOrders;
    }

    @Override
    public int getTableNumber() {
        return this.tableNumber;
    }

    @Override
    public int getCapacity() {
        return this.capacity;
    }

    @Override
    public int getNumberOfPeople() {
        return this.numberOfPeople;
    }

    @Override
    public double getPricePerPerson() {
        return this.pricePerPerson;
    }

    @Override
    public boolean isReserved() {
        return this.isReserved;
    }

    @Override
    public double getPrice() {
        return this.price;
    }

    @Override
    public void reserve(int numberOfPeople) {
        if (numberOfPeople <= 0) {
            throw new IllegalArgumentException(INVALID_NUMBER_OF_PEOPLE);
        }

        this.isReserved = true;
        this.numberOfPeople = numberOfPeople;
        this.price = this.pricePerPerson * this.numberOfPeople;
    }

    @Override
    public void orderFood(BakedFood food) {
        this.getFoodOrders().add(food);
    }

    @Override
    public void orderDrink(Drink drink) {
        this.getDrinkOrders().add(drink);
    }

    @Override
    public double getBill() {
        double sumOfDrinks = this.drinkOrders.stream()
                .mapToDouble(Drink::getPrice)
                .sum();

        double sumOfFood = this.foodOrders.stream()
                .mapToDouble(BakedFood::getPrice)
                .sum();

        return getPrice() + sumOfFood + sumOfDrinks;
    }

    @Override
    public void clear() {
        this.foodOrders.clear();
        this.drinkOrders.clear();
        isReserved = false;
        this.numberOfPeople = 0;
        this.price = 0;
    }

    @Override
    public String getFreeTableInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Table: %d",getTableNumber()))
                .append(System.lineSeparator())
                .append(String.format("Type: %s",this.getClass().getSimpleName()))
                .append(System.lineSeparator())
                .append(String.format("Capacity: %d",getCapacity()))
                .append(System.lineSeparator())
                .append(String.format("Price per Person: %.2f",getPricePerPerson()))
                .append(System.lineSeparator());
        return sb.toString().trim();
    }

}
