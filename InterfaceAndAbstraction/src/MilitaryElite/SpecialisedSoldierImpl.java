package MilitaryElite;

import MilitaryElite.Enums.Corps;
import MilitaryElite.interfaces.SpecialisedSoldier;

public abstract class SpecialisedSoldierImpl extends PrivateImpl implements SpecialisedSoldier {
    private Corps corps;

    public SpecialisedSoldierImpl(int id, String firstName,
                                  String lastName, double salary,
                                  Corps corps) {
        super(id, firstName, lastName, salary);
        this.corps = corps;
    }

    @Override
    public Corps getCorps() {
        return this.corps;
    }

    @Override
    public String toString() {
       return super.toString() + System.lineSeparator() +
                "Corps: " + this.getCorps().getType();
    }
}
