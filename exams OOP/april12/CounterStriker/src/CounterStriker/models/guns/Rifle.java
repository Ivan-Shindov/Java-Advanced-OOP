package CounterStriker.models.guns;

public class Rifle extends GunImpl {
    private static final int DEFAULT_BULLETS = 10;

    public Rifle(String name, int bulletsCount) {
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
