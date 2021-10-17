package MilitaryElite.Enums;

public enum State {
    INPROGRESS("inProgress"),
    FINISHED("Finished");

    private final String type;

    State(String type) {
        this.type = type;
    }

    public String getType() {
        return this.type;
    }
}
