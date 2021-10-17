package ShoppingSpree;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Person {
    private String name;
    private double money;
    private List<Product> products;

    public Person(String name, double money) {
        this.setName(name);
        this.setMoney(money);
        this.products = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        if (name.trim().isEmpty()) {
            throw new IllegalStateException("Name cannot be empty");
        }
        this.name = name;
    }

    public List<Product> getProducts() {
        return this.products;
    }

    private void setMoney(double money) {
        if (money < 0) {
            throw new IllegalStateException("Money cannot be negative");
        }
        this.money = money;
    }

    public void buyProduct(Product product) {
        if (this.money >= product.getCost()) {
            this.money -= product.getCost();
            products.add(product);
        } else {
            throw new IllegalStateException(String.format("%s can't afford %s",
                    this.getName(),product.getName()));
        }
    }

    @Override
    public String toString() {
        if (this.products.isEmpty()) {
            return String.format("%s - Nothing bought",this.getName());
        }
        return String.format("%s - %s",
                this.name,this.products.stream()
                        .map(Product::getName)
                        .collect(Collectors.joining(", ")));

//        StringBuilder builder = new StringBuilder();
//
//        for (int i = 0; i < this.products.size(); i++) {
//            if (i == this.products.size() - 1) {
//                builder.append(this.products.get(i).getName());
//                break;
//            }
//            builder.append(this.products.get(i).getName()).append(", ");
//        }


    }
}
