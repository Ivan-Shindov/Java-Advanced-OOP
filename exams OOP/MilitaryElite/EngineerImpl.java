package MilitaryElite;

import MilitaryElite.Enums.Corps;
import MilitaryElite.Utility.Interfaces.Repair;
import MilitaryElite.Interfaces.Engineer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class EngineerImpl extends SpecialisedSoldierImpl implements Engineer {
    private List<Repair> repairs;

    public EngineerImpl(int id, String firstName, String lastName, double salary, Corps corps) {
        super(id, firstName, lastName, salary, corps);
        this.repairs = new ArrayList<>();
    }

    @Override
    public void addRepair(Repair repair) {
        this.repairs.add(repair);
    }

    @Override
    public Collection<Repair> getRepairs() {
        return this.repairs;
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder(super.toString());
        output.append(System.lineSeparator()).append("Repairs:").append(System.lineSeparator());

        for (Repair repair : this.repairs) {
            output.append("  ").append(repair.toString()).append(System.lineSeparator());
        }

        return output.toString().trim();
    }
}