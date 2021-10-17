package MilitaryElite;

import MilitaryElite.interfaces.LieutenantGeneral;
import MilitaryElite.interfaces.Private;

import java.util.*;

public class LieutenantGeneralImpl extends PrivateImpl implements LieutenantGeneral {
    private Set<Private> privates;

    public LieutenantGeneralImpl(int id, String firstName, String lastName, double salary) {
        super(id, firstName, lastName, salary);
        this.privates = new TreeSet<>((f,s) -> s.getId() - f.getId());
    }

    @Override
    public void addPrivate(Private priv) {
        this.privates.add(priv);
    }

    @Override
    public Collection<Private> getPrivates() {
        return Collections.unmodifiableCollection(this.privates);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString()).append(System.lineSeparator())
                .append("Privates:").append(System.lineSeparator());
        this.privates.forEach(p ->
                sb.append("  ")
                        .append(p.toString())
                        .append(System.lineSeparator()));

        return sb.toString().trim();
    }
}
