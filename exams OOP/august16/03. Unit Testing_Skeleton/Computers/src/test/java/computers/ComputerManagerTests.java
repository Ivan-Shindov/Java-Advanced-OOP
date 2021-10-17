package computers;

import org.junit.Before;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class ComputerManagerTests {
    private ComputerManager computerManager;
    private Computer computer;

    @Before
    public void setUp() {
        this.computerManager = new ComputerManager();
        this.computer = new Computer("Ivan", "Pesho", 100.54);
    }

    @Test
    public void testInitializingConstructor() {
        assertEquals(0, computerManager.getComputers().size());
    }

    @Test
    public void testGetUnmodifiableList() {
        ComputerManager comp = new ComputerManager();
        assertEquals(Collections.unmodifiableList(comp.getComputers()),
                this.computerManager.getComputers());
    }


    @Test
    public void testGetCountMethod() {
        this.computerManager.addComputer(new Computer("ds", "as", 23.0));
        assertEquals(1, this.computerManager.getComputers().size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddMethodThrowsException() {
        this.computerManager.addComputer(computer);
        this.computerManager.addComputer(computer);
    }

    @Test
    public void testGetComputersByManufacter() {
        this.computerManager.addComputer(computer);
        this.computerManager.addComputer(new Computer("Ivan", "as", 23.0));
        this.computerManager.addComputer(new Computer("ds", "as", 23.0));
        this.computerManager.addComputer(new Computer("dsas", "as21", 23.02));
        List<Computer> list = this.computerManager.getComputersByManufacturer("Ivan");
        assertEquals(2,list.size());
    }

    @Test
    public void testAddMethodReturnCorrectValue() {
        this.computerManager.addComputer(computer);
        this.computerManager.addComputer(new Computer("ds", "as", 23.0));
        assertEquals(2, this.computerManager.getComputers().size());
    }

    @Test
    public void testRemoveMethodReturnCorrectValue() {
        this.computerManager.addComputer(computer);
        Computer computer = this.computerManager.removeComputer("Ivan", "Pesho");
        assertEquals(computer, this.computer);
        assertEquals(0, computerManager.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetMethodThrowsException() {
        this.computerManager.addComputer(computer);
        this.computerManager.addComputer(new Computer("ds", "as", 23.0));
        this.computerManager.addComputer(new Computer("dsas", "as21", 23.02));
        this.computerManager.getComputer("Maya", "Kancheva");
    }

}