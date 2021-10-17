package rpg_lab;

import java.util.Random;

public interface Target {
    void takeAttack(int attackPoints);

    Weapon dropWeapon(Random random);

    boolean isDead();

    int giveExperience();
}
