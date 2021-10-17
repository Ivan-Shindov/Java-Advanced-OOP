package MilitaryElite.Utility;

import MilitaryElite.Enums.State;
import MilitaryElite.Utility.Interfaces.Mission;

public class MissionImpl implements Mission {
    private String codeName;
    private State state;

    public MissionImpl(String codeName, State missionState) {
        this.codeName = codeName;
        this.state = missionState;
    }

    @Override
    public String getCodeName() {
        return this.codeName;
    }

    @Override
    public State getState() {
        return this.state;
    }

    @Override
    public void completeMission() {
        this.state = State.FINISHED;
    }

    @Override
    public String toString() {
        return "Code Name: " + this.getCodeName() + " State: " + this.getState().getDisplayText();
    }
}