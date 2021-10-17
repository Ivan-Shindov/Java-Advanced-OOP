package MilitaryElite.interfaces;

import MilitaryElite.Enums.State;

public interface Mission {

    void completeMission();

    String getCodeName();

    State getState();
}
