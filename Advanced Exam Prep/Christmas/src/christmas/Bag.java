package christmas;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Bag {
    private String color;
    private int capacity;
    private List<Present> data;

    public Bag(String color, int capacity) {
        this.color = color;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public String getColor() {
        return color;
    }

    public int getCapacity() {
        return capacity;
    }

    public int count() {
        return this.data.size();
    }

    public void add(Present present) {
        if (this.capacity > this.data.size()) {
            this.data.add(present);
        }
    }

    public boolean remove(String name) {
        for (Present present : this.data) {
            if (present.getName().equals(name)) {
                this.data.remove(present);
                return true;
            }
        }
        return false;
    }

    public Present heaviestPresent() {
        if (!this.data.isEmpty()) {
            String name = this.data.get(0).getName();
            double weight = this.data.get(0).getWeight();
            String gender = this.data.get(0).getGender();

            Present present = new Present(name, weight, gender);

            for (int i = 1; i < count(); i++) {
                Present current = this.data.get(i);
                if (current.getWeight() > present.getWeight()) {
                    present = current;
                }
            }
            return present;
        }
        return null;
//         Present present1 = this.data.stream()
//         .max(Comparator.comparingDouble(Present::getWeight)).orElse(null);
//         return present1;
    }

    public Present getPresent(String name) {
        for (int i = 0; i < count(); i++) {
            Present current = this.data.get(i);
            if (current.getName().equals(name)) {
                return current;
            }
        }
        return null;
//         Present present1 = this.data.stream().filter(e ->
//         e.getName().equals(name)).findFirst().orElse(null);
//         return present1;
    }

    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.color).append(" bag contains:")
                .append(System.lineSeparator());
        for (Present datum : this.data) {
            sb.append(datum).append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
