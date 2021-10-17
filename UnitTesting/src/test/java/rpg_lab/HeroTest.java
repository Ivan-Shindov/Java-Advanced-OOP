package rpg_lab;

import org.junit.Test;
import org.mockito.Mockito;

import java.util.Random;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class HeroTest {

    @Test
    public void testItemShouldDropCorrectly() {
        Weapon weapon = mock(Weapon.class);
        Hero hero = new Hero("some",weapon);

        Target target = mock(Target.class);
        when(target.isDead()).thenReturn(true);
        Random random = mock(Random.class);
        Weapon weapon3 =mock(Weapon.class);

        when(weapon3.getAttack()).thenReturn(73);

        when(target.dropWeapon(random)).thenReturn(weapon3);

        Weapon attack = hero.attack(target, random);

        assertEquals(73,attack.getAttack());
    }
}