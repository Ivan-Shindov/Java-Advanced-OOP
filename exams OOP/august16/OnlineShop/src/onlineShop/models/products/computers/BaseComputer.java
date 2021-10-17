package onlineShop.models.products.computers;


import onlineShop.models.products.BaseProduct;
import onlineShop.models.products.Product;
import onlineShop.models.products.components.Component;
import onlineShop.models.products.peripherals.Peripheral;

import java.util.ArrayList;
import java.util.List;

import static onlineShop.common.constants.ExceptionMessages.*;
import static onlineShop.common.constants.OutputMessages.*;

public abstract class BaseComputer extends BaseProduct implements Computer {

    private List<Component> components;
    private List<Peripheral> peripherals;

    protected BaseComputer(int id, String manufacturer,
                           String model, double price,
                           double overallPerformance) {

        super(id, manufacturer, model, price,
                overallPerformance);
        this.components = new ArrayList<>();
        this.peripherals = new ArrayList<>();
    }

    @Override
    public List<Component> getComponents() {
        return this.components;
    }

    @Override
    public List<Peripheral> getPeripherals() {
        return this.peripherals;
    }

    @Override
    public void addComponent(Component component) {
        for (Component compon : this.components) {
            if (compon.getClass().equals(component.getClass())) {
                throw new IllegalArgumentException(String.format(EXISTING_COMPONENT,
                        compon.getClass().getSimpleName(),
                        this.getClass().getSimpleName(), this.getId()));
            }
        }
        this.components.add(component);
    }

    @Override
    public Component removeComponent(String componentType) {

        for (Component component : this.components) {
            if (component.getClass().getSimpleName().equals(componentType)) {
                boolean isRemoved = this.components.remove(component);
                if (isRemoved) {
                    return component;
                }
            }
        }
        throw new IllegalArgumentException(String.format(NOT_EXISTING_COMPONENT,
                componentType, this.getClass().getSimpleName(), this.getId()));
    }

    @Override
    public void addPeripheral(Peripheral peripheral) {

        for (Peripheral peripheral1 : peripherals) {
            if (peripheral1.getClass().equals(peripheral.getClass())) {
                throw new IllegalArgumentException(String.format(EXISTING_PERIPHERAL,
                        peripheral.getClass().getSimpleName(),
                        this.getClass().getSimpleName(), this.getId()));
            }
        }
        this.peripherals.add(peripheral);
    }

    @Override
    public Peripheral removePeripheral(String peripheralType) {
        for (Peripheral peripheral : peripherals) {
            if (peripheral.getClass().getSimpleName().equals(peripheralType)) {
                this.peripherals.remove(peripheral);
                return peripheral;
            }
        }
        throw new IllegalArgumentException(String.format(NOT_EXISTING_PERIPHERAL,
                peripheralType, this.getClass().getSimpleName(), this.getId()));
    }

    @Override
    public double getOverallPerformance() {

        double averageOfComponents = this.components.stream()
                .mapToDouble(Product::getOverallPerformance)
                .average().orElse(0);

        return super.getOverallPerformance() + averageOfComponents;
    }

    @Override
    public double getPrice() {

        double sumComponents = this.components.stream()
                .mapToDouble(Component::getPrice)
                .sum();

        double sumPeripherals = this.peripherals.stream()
                .mapToDouble(Peripheral::getPrice)
                .sum();

        return super.getPrice() + sumComponents + sumPeripherals;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString()).append(System.lineSeparator());
        sb.append(String.format(" " + COMPUTER_COMPONENTS_TO_STRING, getComponents().size()))
                .append(System.lineSeparator());
        for (Component component : components) {
            sb.append("  ").append(component.toString())
                    .append(System.lineSeparator());
        }
        sb.append(String.format(" " + COMPUTER_PERIPHERALS_TO_STRING,
                this.peripherals.size(),
                this.peripherals.stream()
                        .mapToDouble(Peripheral::getOverallPerformance)
                        .average()
                        .orElse(0)))
                .append(System.lineSeparator());
        for (Peripheral peripheral : peripherals) {
            sb.append("  ").append(peripheral.toString())
                    .append(System.lineSeparator());
        }

        return sb.toString().trim();
    }
}
