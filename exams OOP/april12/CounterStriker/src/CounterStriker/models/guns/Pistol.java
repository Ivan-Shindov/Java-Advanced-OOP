package CounterStriker.models.guns;

public class Pistol extends GunImpl {
    private static final int DEFAULT_BULLETS = 1;

    public Pistol(String name, int bulletsCount) {
        super(name, bulletsCount);
    }

    @Override
    public int fire() {
        if (super.getBulletsCount() < DEFAULT_BULLETS) {
            return 0;
        }
        super.decreaseBullets(DEFAULT_BULLETS);
        return DEFAULT_BULLETS;
    }
}
