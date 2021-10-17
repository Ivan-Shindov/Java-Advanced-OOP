package bankSafe;

import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;
import java.util.Map;

import static org.junit.Assert.*;

public class BankVaultTest {
    private BankVault bankVault;

    @Before
    public void setUp() {
        this.bankVault = new BankVault();
    }

    @Test
    public void testConstructor() {
        BankVault bankVault = new BankVault();
        assertNotNull(bankVault);
        assertEquals(12,bankVault.getVaultCells().size());
    }

    @Test
    public void testGetVaultCells() {
        BankVault bankVault = new BankVault();
        Map<String, Item> vaultCells = bankVault.getVaultCells();
        assertEquals(vaultCells.size(),bankVault.getVaultCells().size());
    }

    @Test
    public void testGetOneCellShouldReturnNullValue() {
        BankVault bankVault = new BankVault();
        Item item = bankVault.getVaultCells().get("A2");
        assertNull(item);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testGetVaultCellsThrowsException() {
        BankVault bankVault = new BankVault();
        bankVault.getVaultCells().put("C4",new Item("Ivan","12"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddItemThrowExceptionWhenNotContainTheCell () throws OperationNotSupportedException {
        BankVault bankVault = new BankVault();
        String cell = "ivan";
        Item item = new Item("IvanOwner","233");
        bankVault.addItem(cell,item);
    }

    @Test(expected = IllegalArgumentException.class)
    public  void testAddItemThrowExceptionWhenContainCellButValueIsNotNull() throws OperationNotSupportedException {
        BankVault bankVault = new BankVault();
        Item item = new Item("IvanOwner","233");
        bankVault.addItem("A1",item);
        bankVault.addItem("A1",item);
    }

    @Test(expected = OperationNotSupportedException.class)
    public  void testAddItemThrowExceptionWhenItemExist() throws OperationNotSupportedException {
        BankVault bankVault = new BankVault();
        Item item = new Item("IvanOwner","233");
        bankVault.addItem("A1",item);
        bankVault.addItem("A2",item);
    }

    @Test
    public void testAddItemWorkCorrectly() throws OperationNotSupportedException {
        BankVault bankVault = new BankVault();
        Item item = new Item("IvanOwner","233");
        String cell = "A1";
        String addItem = bankVault.addItem(cell, item);
        assertEquals("Item:233 saved successfully!",addItem);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveItemThrowsExceptionWhenCellDoesNotExist() throws OperationNotSupportedException {
        BankVault bankVault = new BankVault();
        String cell = "Ivan";
        Item item = new Item("IvanOwner","233");
        bankVault.addItem("A1",item);
        bankVault.removeItem(cell,item);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveItemThrowsExceptionItemNotExistInCell() throws OperationNotSupportedException {
        BankVault bankVault = new BankVault();
        Item item = new Item("IvanOwner","233");
        bankVault.addItem("A1",item);
        bankVault.removeItem("A1",item);
        bankVault.removeItem("A1",item);
    }

    @Test
    public void testRemoveItemShouldPutOnCellNullValue() throws OperationNotSupportedException {
        BankVault bankVault = new BankVault();
        Item item = new Item("IvanOwner","233");
        Item item2 = new Item("IvanOwner2","2334");
        bankVault.addItem("A1",item);
        bankVault.addItem("A2",item2);
        String removed = bankVault.removeItem("A1", item);
        assertEquals("Remove item:233 successfully!",removed);
    }

    // not necessary
//    @Test
//    public void testGetOwnerInItemClass() {
//        String owner = "Ivan";
//        String idemId = "123";
//
//        Item item = new Item(owner,idemId);
//        String actual = item.getOwner();
//        assertEquals(owner,actual);
//    }
}