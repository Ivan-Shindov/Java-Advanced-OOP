package MilitaryElite;

import MilitaryElite.Interfaces.LieutenantGeneral;
import MilitaryElite.Interfaces.Private;

import java.util.Set;
import java.util.TreeSet;

public class LieutenantGeneralImpl extends PrivateImpl implements LieutenantGeneral {
    private Set<Private> privates;

    public LieutenantGeneralImpl(int id, String firstName, String lastName, double salary) {
        super(id, firstName, lastName, salary);
        this.privates = new TreeSet<>((f, s) -> s.getId() - f.getId());
    }

    @Override
    public void addPrivate(Private soldier) {
        this.privates.add(soldier);
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder(super.toString());
        output.append(System.lineSeparator()).append("Privates:").append(System.lineSeparator());

        this.privates.forEach(p -> output.append("  ").append(p.toString()).append(System.lineSeparator()));

        return output.toString().trim();
    }
}