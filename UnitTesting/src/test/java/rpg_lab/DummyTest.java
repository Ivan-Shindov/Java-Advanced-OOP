package rpg_lab;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class DummyTest {
    private final int DUMMY_HEALTH = 10;
    private final int DUMMY_EXPERIENCE = 10;

    private ItemStorage itemStorage;
    private Dummy dummy;

    @Before
    public void setUp() {
        this.itemStorage = Mockito.mock(ItemStorage.class);
        this.dummy = new Dummy(DUMMY_HEALTH,DUMMY_EXPERIENCE,itemStorage);
    }

    @Test
    public void targetLoosesHealthAfterAttack() {
        dummy.takeAttack(2);
        assertEquals(8,dummy.getHealth());
    }

    @Test(expected = IllegalStateException.class)
    public void testTargetIsAttackedWhenItIsDead() {
        Dummy dummy = new Dummy(0, DUMMY_EXPERIENCE, this.itemStorage);
        dummy.takeAttack(10);
    }

    @Test
    public void testDeadDummyGivesXp() {
        Dummy dummy = new Dummy(0, DUMMY_EXPERIENCE, this.itemStorage);
        dummy.giveExperience();
        assertEquals(10,dummy.giveExperience());
    }

    @Test(expected = IllegalStateException.class)
    public void testAliveDummyCanNotGiveXp() {
        this.dummy.giveExperience();
    }
}