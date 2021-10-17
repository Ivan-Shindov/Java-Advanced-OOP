package MilitaryElite;


import MilitaryElite.Enums.Corps;
import MilitaryElite.interfaces.Commando;
import MilitaryElite.interfaces.Mission;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class CommandoImpl extends SpecialisedSoldierImpl implements Commando {

    private List<Mission> missions;

    public CommandoImpl(int id, String firstName,
                        String lastName, double salary, Corps corps) {
        super(id, firstName, lastName, salary, corps);
        this.missions = new ArrayList<>();
    }

    @Override
    public void addMission(Mission mission) {
        this.missions.add(mission);
    }

    @Override
    public Collection<Mission> getMissions() {
        return Collections.unmodifiableCollection(this.missions);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb      .append(System.lineSeparator())
                .append("Missions:").append(System.lineSeparator());
        this.missions.forEach(m -> sb
                .append("  ")
                .append(m.toString())
                .append(System.lineSeparator()));
        return sb.toString().trim();
    }
}
