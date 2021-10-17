package rabbits;

import java.util.ArrayList;
import java.util.List;

public class Cage {
    private String name;
    private int capacity;
    private List<Rabbit> data;

    public Cage(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void add(Rabbit rabbit) {
        if (this.data.size() < this.capacity) {
            this.data.add(rabbit);
        }
    }

    public boolean removeRabbit(String name) {
        return this.data.removeIf(r -> r.getName().equals(name));
    }

    public void removeSpecies(String species) {
        this.data.removeIf(r -> r.getSpecies().equals(species));
    }

    public Rabbit sellRabbit(String name) {
        Rabbit rabbit = null;

        for (Rabbit current : this.data) {
            if (current.getName().equals(name)) {
                rabbit = current;
                rabbit.setAvailable(false);
            }
        }
        return rabbit;
    }

    public int count() {
        return this.data.size();
    }

    public String report() {
        StringBuilder result = new StringBuilder();
        result.append(String.format("Rabbits available at %s:",this.name))
                .append(System.lineSeparator());
        for (Rabbit rabbit : this.data) {
            if (rabbit.isAvailable()) {
                result.append(rabbit).append(System.lineSeparator());
            }
        }

        return result.toString().trim();
    }

    public List<Rabbit> sellRabbitBySpecies(String species) {
        List<Rabbit> result = new ArrayList<>();

        for (int i = 0; i < this.data.size(); i++) {
            Rabbit rabbit = this.data.get(i);
            if (rabbit.getSpecies().equals(species)) {
                result.add(rabbit);
                this.data.remove(rabbit);
                i--;
            }
        }
        return result;
    }
}
