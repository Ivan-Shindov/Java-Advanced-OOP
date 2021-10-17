package vetClinic;

import java.util.ArrayList;
import java.util.List;

public class Clinic {
    private List<Pet> data;
    private int capacity;

    public Clinic(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Pet pet) {
        if (this.data.size() < this.capacity) {
            this.data.add(pet);
        }
    }

    public boolean remove(String name) {
        for (Pet pet : this.data) {
            if (pet.getName().equals(name)) {
                this.data.remove(pet);
                return true;
            }
        }
        return false;
    }

    public Pet getPet(String name, String owner) {
        Pet pet = null;
        for (Pet current : this.data) {
            if (current.getName().equals(name) && current.getOwner().equals(owner)) {
                pet = current;
            }
        }
        return pet;
    }

    public Pet getOldestPet() {
        Pet pet = null;
        for (Pet current : this.data) {
            if ((pet == null) || (current.getAge() > pet.getAge())) {
                pet = current;

            }
        }
        return pet;
    }

    public int getCount() {
        return this.data.size();
    }

    public String getStatistics() {
        StringBuilder result = new StringBuilder();
        result.append("The clinic has the following patients:")
                .append(System.lineSeparator());
        for (Pet pet : this.data) {
            result.append(pet.getName()).append(" ").append(pet.getOwner())
                    .append(System.lineSeparator());
        }
        return result.toString().trim();
    }
}
