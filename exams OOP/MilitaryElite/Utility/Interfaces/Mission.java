package MilitaryElite.Utility.Interfaces;

import MilitaryElite.Enums.State;

public interface Mission {
    String getCodeName();
    State getState();
    void completeMission();
}