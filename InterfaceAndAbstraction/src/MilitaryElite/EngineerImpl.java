package MilitaryElite;

import MilitaryElite.Enums.Corps;
import MilitaryElite.interfaces.Engineer;
import MilitaryElite.interfaces.Repair;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class EngineerImpl extends SpecialisedSoldierImpl implements Engineer {
    private List<Repair> repairs;

    public EngineerImpl(int id, String firstName, String lastName,
                        double salary, Corps corps) {
        super(id, firstName, lastName, salary, corps);
        this.repairs = new ArrayList<>();
    }

    @Override
    public void addRepair(Repair repair) {
        this.repairs.add(repair);
    }

    @Override
    public Collection<Repair> getRepairs() {
        return Collections.unmodifiableCollection(this.repairs);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb      .append(System.lineSeparator())
                .append("Repairs:")
                .append(System.lineSeparator());
        this.repairs.forEach(r ->
                sb.append("  ")
                        .append(r.toString())
                        .append(System.lineSeparator()));

        return sb.toString().trim();
    }
}
