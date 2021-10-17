package MilitaryElite.Interfaces;

import MilitaryElite.Utility.Interfaces.Repair;

import java.util.Collection;

public interface Engineer {
    void addRepair(Repair repair);
    Collection<Repair> getRepairs();
}