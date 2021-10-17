package MilitaryElite.Enums;

public enum Corps {
        AIRFORCES("Airforces"),
        MARINES("Marines");

    private final String type;

    Corps(String type) {
        this.type = type;
    }

    public String getType() {
        return this.type;
    }
}
