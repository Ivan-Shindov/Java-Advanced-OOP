package p03_IteratorTest;

import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

import static org.junit.Assert.*;

public class ListIteratorTest {

    private ListIterator listIterator;
    private static final String[] ARRAY = {"el","em","ent"};

    @Before
    public void setUp() throws OperationNotSupportedException {
        this.listIterator = new ListIterator(ARRAY);
    }

    @Test
    public void testConstructorWithValidData() throws OperationNotSupportedException {
        String[] arr = {"el","em","ent"};
        ListIterator listIterator = new ListIterator(arr);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorWithNullParametar() throws OperationNotSupportedException {
        ListIterator listIterator = new ListIterator(null);
    }

    @Test
    public void testHasNextReturnCorrectlyBoolean() {
        while (this.listIterator.hasNext()) {
            this.listIterator.move();
        }
        assertFalse(this.listIterator.hasNext());
    }

    @Test
    public void testMoveCorrectlyReturnBoolean() {
        assertTrue(listIterator.move());
        assertTrue(listIterator.move());
        assertFalse(listIterator.move());
    }

    @Test(expected = IllegalStateException.class)
    public void testPrintWithNullParameter() throws OperationNotSupportedException {
        ListIterator listIterator = new ListIterator();
        listIterator.print();
    }

    @Test
    public void testPrintWithCorrectlyValue() {
        int index = 0;
        while (this.listIterator.hasNext()) {
            assertEquals(ARRAY[index],this.listIterator.print());
            this.listIterator.move();
            index++;
        }
    }
}
