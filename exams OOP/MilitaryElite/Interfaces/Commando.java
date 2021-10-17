package MilitaryElite.Interfaces;

import MilitaryElite.Utility.Interfaces.Mission;

import java.util.Collection;

public interface Commando {
    void addMission(Mission mission);
    Collection<Mission> getMissions();
}