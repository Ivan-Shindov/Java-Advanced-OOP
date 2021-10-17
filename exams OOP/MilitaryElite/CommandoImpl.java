package MilitaryElite;

import MilitaryElite.Enums.Corps;
import MilitaryElite.Interfaces.Commando;
import MilitaryElite.Utility.Interfaces.Mission;
import MilitaryElite.Utility.Interfaces.Repair;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CommandoImpl extends SpecialisedSoldierImpl implements Commando {
    private List<Mission> missions;

    public CommandoImpl(int id, String firstName, String lastName, double salary, Corps corps) {
        super(id, firstName, lastName, salary, corps);
        this.missions = new ArrayList<>();
    }

    @Override
    public void addMission(Mission mission) {
        this.missions.add(mission);
    }

    @Override
    public Collection<Mission> getMissions() {
        return this.missions;
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder(super.toString());
        output.append(System.lineSeparator()).append("Missions:").append(System.lineSeparator());

        for (Mission mission : this.missions) {
            output.append("  ").append(mission.toString()).append(System.lineSeparator());
        }

        return output.toString().trim();
    }
}