package MilitaryElite.Enums;

public enum State {
    INPROGRESS("inProgress"),
    FINISHED("Finished");

    private final String displayText;

    State(String displayText) {
        this.displayText = displayText;
    }

    public String getDisplayText() {
        return this.displayText;
    }
}