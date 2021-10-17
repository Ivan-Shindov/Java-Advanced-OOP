package halfLife;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class PlayerTests {
    private List<Gun> guns;
    private Player player;

    @Before
    public void setUp() {
        this.player = new Player("Ivan",100);
        this.guns = List.of(new Gun("Makarov",10),
                new Gun("M4",200));
    }

    @Test
    public void testConstructor() {
        String name = "Maya";
        int health = 200;

        Player player = new Player(name,health);
        assertEquals(name, player.getUsername());
        assertEquals(health,player.getHealth());
        assertNotNull(player);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testGetGunsThrowException() {
        this.guns.add(new Gun("Rifle",100));
    }

    @Test
    public void testGetGuns() {
        this.player.addGun(new Gun("adv",1));
        assertEquals(1,this.player.getGuns().size());
    }

    @Test
    public void testGetUsername() {
        String expected = "Ivan";
        String actual = this.player.getUsername();
        assertEquals(expected,actual);
    }

    @Test(expected = NullPointerException.class)
    public void testSetUsername() {
        new Player(null,10);
    }

    @Test
    public void testGetHealth() {
        int expected = 100;
        int actual = this.player.getHealth();
        assertEquals(expected,actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetHealth() {
        new Player("asd",-1);
    }

    @Test
    public void testGetGunsReturnsCorrectCollection() {
        this.player.addGun(new Gun("Makarov",10));
        this.player.addGun(new Gun("M4",200));
        assertEquals(2,this.player.getGuns().size());
    }

    @Test(expected = IllegalStateException.class)
    public void testTakeDamageThrowsException() {
        Player player = new Player("abv",0);
        player.takeDamage(100);
    }

    @Test
    public void testTakeDamageWithHealthBelowZero() {
        Player player = new Player("abv",50);
        player.takeDamage(100);
        assertEquals(0,player.getHealth());
    }

    @Test
    public void testTakeDamageWorkProperly() {
        int dmg = 10;
        this.player.takeDamage(dmg);
        assertEquals(90,this.player.getHealth());
    }

    @Test(expected = NullPointerException.class)
    public void testAddGunThrowsException() {
        this.player.addGun(null);
    }

    @Test
    public void tesAddGunReturnCorrectValue() {
        Gun gun = new Gun("M4",200);
        this.player.addGun(gun);
        assertEquals(gun,this.player.getGun("M4"));
    }

    @Test
    public void testRemoveGun() {
        Gun gun = new Gun("Makarov",10);
        Gun gun2 = new Gun("Makarov2",101);
        Gun gun3 = new Gun("Makarov3",102);
        this.player.addGun(gun);
        this.player.addGun(gun2);
        this.player.addGun(gun3);
        assertTrue(this.player.removeGun(gun));
        assertEquals(2,this.player.getGuns().size());
    }

    @Test
    public void testGetGunReturnCorrectGun() {
        Gun gunExpected = new Gun("Makarov",10);
        this.player.addGun(gunExpected);
        this.player.addGun(new Gun("Makarov1",101));
        this.player.addGun(new Gun("Makarov2",120));
        Gun gunActual = this.player.getGun("Makarov");
        assertEquals(gunExpected,gunActual);
        assertEquals(gunExpected.getName(),"Makarov");
        assertEquals(gunExpected.getBullets(),10);
    }

    @Test
    public void testGetGunReturnInCorrectGun() {
        Player player = new Player("abv",50);
        Gun gun = new Gun("Makarov",10);
        player.addGun(gun);
        Gun actual = player.getGun("Pistol");
        assertNull(actual);
    }
}
