package MilitaryElite.Enums;

public enum Corps {
    AIRFORCES("Airforces"),
    MARINES("Marines");

    private final String displayString;

    Corps(String displayString) {
        this.displayString = displayString;
    }

    public String getDisplayString() {
        return this.displayString;
    }
}