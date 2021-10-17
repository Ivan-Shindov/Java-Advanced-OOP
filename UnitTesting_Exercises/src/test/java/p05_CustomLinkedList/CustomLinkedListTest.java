package p05_CustomLinkedList;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CustomLinkedListTest {

    private CustomLinkedList<String> customLinkedList;

    @Before
    public void setUp() {
        this.customLinkedList = new CustomLinkedList<>();
        customLinkedList.add("Ivan");
        customLinkedList.add("Pesho");

    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetMethodThrowsExceptionForBiggerIndex () {
        this.customLinkedList.get(4);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetMethodThrowsExceptionForLowerIndex () {
        this.customLinkedList.get(-1);
    }

    @Test
    public void testGetMethodWithValidIndex () {
        String actualElement = this.customLinkedList.get(1);
        assertEquals("Pesho",actualElement);
    }

    @Test
    public void testSetMethodWithValidElement() {
        this.customLinkedList.set(1,"Maya");
        assertEquals("Maya",this.customLinkedList.get(1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetMethodThrowsExceptionForBiggerIndex () {
        this.customLinkedList.get(4);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetMethodThrowsExceptionForLowerIndex () {
        this.customLinkedList.get(-1);
    }

    @Test
    public void testAddMethodWithEmptyList() {
        CustomLinkedList<String> customLinkedList = new CustomLinkedList<>();
        customLinkedList.add("Pesho");
        assertEquals("Pesho",customLinkedList.get(0));
        assertTrue(this.customLinkedList.contains("Pesho"));
    }

    @Test
    public void testAddMethodWithNonEmptyList() {
        this.customLinkedList.add("Maya");
        assertEquals("Maya",customLinkedList.get(2));
        assertTrue(this.customLinkedList.contains("Maya"));

    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveAtShouldThrowException() {
        this.customLinkedList.removeAt(5);
    }

    @Test
    public void testRemoveAtShouldWorkCorrectlyWithIndexInBounds() {
        String actual = this.customLinkedList.removeAt(1);
        assertEquals("Pesho",actual);
    }

    @Test
    public void testRemoveMethodWorkWithValidElement() {
        int removed = this.customLinkedList.remove("Ivan");
        assertEquals(0, removed);
        assertEquals("Pesho",this.customLinkedList.get(0));
    }

    @Test
    public void testRemoveMethodWhichNotContainGivenElement() {
        int removed = this.customLinkedList.remove("Gosho");
        assertEquals(-1,removed);
    }

    @Test
    public void testIndexOfWithCorrectlyElement() {
        int indexOf = this.customLinkedList.indexOf("Pesho");
        assertEquals(1,indexOf);
    }

    @Test
    public void testIndexOfWithNonCorrectlyElement() {
        int indexOf = this.customLinkedList.indexOf("Petur");
        assertEquals(-1,indexOf);
    }

    @Test
    public void testContainsMethodShouldReturnTrue() {
        assertTrue(this.customLinkedList.contains("Ivan"));
    }

    @Test
    public void testContainsMethodShouldReturnFalse() {
        assertFalse(this.customLinkedList.contains("Miro"));
    }

}
