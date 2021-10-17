package p02_ExtendedDatabase;

import org.junit.Before;
import org.junit.Test;


import javax.naming.OperationNotSupportedException;

import static org.junit.Assert.assertEquals;

public class DatabaseTest {
    private static final Person[] PEOPLE = {new Person(1,"Ivan"),
            new Person(2,"Maya"), new Person(3, "Pesho")
    };
    private Database database;

    @Before
    public void setUpDatabase() throws OperationNotSupportedException {
        this.database = new Database(PEOPLE);
    }

    @Test
    public void testConstructorCreateValidObject() throws OperationNotSupportedException {
        assertEquals(3,database.getElements().length);
        assertEquals(2,database.getElements().length - 1);
        Person[] databaseNums = database.getElements();
        for (int i = 0; i < PEOPLE.length; i++) {
            assertEquals(PEOPLE[i],databaseNums[i]);
        }
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorThrowsExceptionMoreThanSixteenElements() throws OperationNotSupportedException {
        Person[] people = new Person[17];
        Database database = new Database(people);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorThrowsExceptionWithZeroElements() throws OperationNotSupportedException {
        Database database = new Database();
    }

    @Test
    public void testAddOperationWithValidData() throws OperationNotSupportedException {
        this.database.add(new Person(4,"Gosho"));
        assertEquals(4,database.getElements().length);
        assertEquals(4,database.getElements()[3].getId());
        assertEquals("Gosho",database.getElements()[3].getUsername());
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testAddOperationWithNullValue() throws OperationNotSupportedException {
        this.database.add(null);
    }

    @Test
    public void testRemoveOperationRemovingLastElement() throws OperationNotSupportedException {
        Person[] expectedPeople = {new Person(1,"Ivan"),
                new Person(2,"Maya")};
        this.database.remove();
        for (int i = 0; i < expectedPeople.length; i++) {
            assertEquals(expectedPeople[i].getId(),database.getElements()[i].getId());
            assertEquals(expectedPeople[i].getUsername(),database.getElements()[i].getUsername());
        }
        assertEquals(2,database.getElements().length);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testRemoveOperationWhereThereIsNoDataThrowsException() throws OperationNotSupportedException {

        for (int i = 0; i < PEOPLE.length; i++) {
            database.remove();
        }
        database.remove();
    }


    // null parameter
    @Test(expected = OperationNotSupportedException.class)
    public void testWithParameterUsernameNull() throws OperationNotSupportedException {
        Person resultPerson = this.database.findByUsername(null);
    }

    // null person
    @Test(expected = OperationNotSupportedException.class)
    public void testFindByUsernameThrowsExceptionForNulllPerson() throws OperationNotSupportedException {
        this.database = new Database(null,null);
        database.findByUsername("Ivan");

    }

    // if can not find one username
    @Test(expected = OperationNotSupportedException.class)
    public void testFindByUsernameIfSizeIsNotEqualsOne() throws OperationNotSupportedException {
        this.database = new Database();
        this.database.findByUsername("Ivan");
    }

    // to find person by username
    @Test
    public void testFindByUsernameWithCorrectUsername() throws OperationNotSupportedException {
        Person resultPerson = this.database.findByUsername("Ivan");
        assertEquals(1,resultPerson.getId());
        assertEquals("Ivan",resultPerson.getUsername());
    }

    @Test
    public void testFindByUsernameWithCorrectId() throws OperationNotSupportedException {
        Person resultPerson = this.database.findById(1);
        assertEquals(1,resultPerson.getId());
        assertEquals("Ivan",resultPerson.getUsername());
    }

    // if can not find one id
    @Test(expected = OperationNotSupportedException.class)
    public void testFindByIdIfSizeIsNotEqualsOne() throws OperationNotSupportedException {
        this.database = new Database();
        this.database.findById(1);
    }

    // null person
    @Test(expected = OperationNotSupportedException.class)
    public void testFindByIdThrowsExceptionForNulllPerson() throws OperationNotSupportedException {
        this.database = new Database(null,null);
        database.findById(1);

    }

    @Test(expected = OperationNotSupportedException.class)
    public void testWithMoreThanOneEqualsIds() throws OperationNotSupportedException {
        Database database = new Database(new Person(1,"Kolio"),
                new Person(1,"Petkan"));
        database.findById(1);
    }

}
