package p01_Database;

import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

import static org.junit.Assert.*;

public class DatabaseTest {

    private static final Integer[] NUMBERS = {1,23,4,5,54};
    private Database database;

    @Before
    public void setUpDatabase() throws OperationNotSupportedException {
        this.database = new Database(NUMBERS);
    }

    @Test
    public void testConstructorCreateValidObject() throws OperationNotSupportedException {
        assertEquals(5,database.getElements().length);
        assertEquals(4,database.getElements().length - 1);
        Integer[] databaseNums = database.getElements();
        for (int i = 0; i < NUMBERS.length; i++) {
            assertEquals(NUMBERS[i],databaseNums[i]);
        }
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorThrowsExceptionMoreThanSixteenElements() throws OperationNotSupportedException {
        Integer[] nums = new Integer[17];
        Database database = new Database(nums);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorThrowsExceptionWithZeroElements() throws OperationNotSupportedException {
        Database database = new Database();
    }

    @Test
    public void testAddOperationWithValidData() throws OperationNotSupportedException {
        this.database.add(10);
        assertEquals(6,database.getElements().length);
        assertEquals(Integer.valueOf(10),database.getElements()[5]);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testAddOperationWithNullValue() throws OperationNotSupportedException {
        this.database.add(null);
    }

    @Test
    public void testRemoveOperationRemovingLastElement() throws OperationNotSupportedException {
        Integer[] expectedArr = {1, 23, 4, 5};
        this.database.remove();
        for (int i = 0; i < expectedArr.length; i++) {
            assertEquals(expectedArr[i],database.getElements()[i]);
        }
        assertEquals(4,database.getElements().length);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testRemoveOperationWhereThereIsNoDataThrowsException() throws OperationNotSupportedException {

        for (int i = 0; i < NUMBERS.length; i++) {
            database.remove();
        }
        database.remove();
    }
}
