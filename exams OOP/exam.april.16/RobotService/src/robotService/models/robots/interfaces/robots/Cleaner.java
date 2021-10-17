package robotService.models.robots.interfaces.robots;

public class Cleaner extends BaseRobot {

    public Cleaner(String name, int energy, int happiness, int procedureTime) {
        super(name, energy, happiness, procedureTime);
    }

    @Override
    public String toString() {
        return String.format(" Robot type: %s - %s - Happiness: %d - Energy: %d%n",
                this.getClass().getSimpleName(),super.getName(),super.getHappiness(),super.getEnergy());
    }
}
