package computers;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class ComputerTest {
    private Computer computer;
    private Part part;

    @Before
    public void setUp() {
        this.computer = new Computer("Asus");
        this.part = new Part("Dell",11.50);
        this.computer.addPart(this.part);
    }

    @Test
    public void testConstructor() {
        assertNotNull(this.computer);
        assertEquals("Asus", this.computer.getName());
        assertEquals(1, this.computer.getParts().size());
    }

    @Test
    public void testGetNameReturnsCorrectName() {
        assertEquals("Asus", this.computer.getName());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorWithNullForName() {
        Computer computer = new Computer(null);
    }

    @Test
    public void testGetParts() {
        List<Part> parts = this.computer.getParts();
        assertEquals(parts.size(),this.computer.getParts().size());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testGetPartsThrowsException() {
        this.computer.getParts().add(new Part("Dell",25.00));
    }

    @Test
    public void testGetTotalPriceShouldReturnCorrectSum() {
        this.computer.addPart(this.part);
        this.computer.addPart(this.part);
        double totalPrice = this.computer.getTotalPrice();
        assertEquals(34.50,totalPrice,0);
    }

    @Test
    public void testAddPartShouldReturnBiggerSizeList() {
        this.computer.addPart(this.part);
        assertEquals(2,this.computer.getParts().size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddPartThrowsExceptionForNullValue() {
        this.computer.addPart(null);
    }

    @Test
    public void testRemovePartReturnBoolean() {
        Part part = new Part("Dell",10.0);
        this.computer.addPart(part);
        boolean isRemoved = this.computer.removePart(part);
        assertTrue(isRemoved);
    }

    @Test
    public void testGetPartShouldReturnCorrectPart() {
        String name = "Dell";
        Part part = new Part(name,10.0);
        this.computer.addPart(part);
        Part actualPart = this.computer.getPart(name);
        assertEquals(part.getName(),actualPart.getName());
    }

    @Test
    public void testGetPartShouldReturnNullValue() {
        Part part = this.computer.getPart("Lenovo");
        assertNull(part);
    }

    @Test
    public void testSetNameShouldChangeCorrectlyInPartClass() {
        this.part.setName("Lenovo");
        String name = this.part.getName();
        assertEquals("Lenovo",name);
    }

    @Test
    public void testSetPriceShouldChangePriceInPartClass() {
        double price = 12.20;
        this.part.setPrice(price);
        assertEquals(price,this.part.getPrice(),0);
    }

}