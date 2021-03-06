package MilitaryElite;

import MilitaryElite.Enums.State;
import MilitaryElite.interfaces.Mission;

public class MissionImpl implements Mission {
    private String codeName;
    private State state;

    public MissionImpl(String codeName, State state) {
        this.codeName = codeName;
        this.state = state;
    }

    @Override
    public State getState() {
        return this.state;
    }

    @Override
    public String getCodeName() {
        return this.codeName;
    }

    @Override
    public void completeMission() {
        this.state = State.FINISHED;
    }

    @Override
    public String toString() {
        return String.format("Code Name: %s State: %s",
                this.codeName,this.state.getType());
    }
}
