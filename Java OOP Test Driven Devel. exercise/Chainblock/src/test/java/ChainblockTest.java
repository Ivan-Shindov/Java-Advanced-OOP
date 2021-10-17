import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class ChainblockTest {
    private Chainblock chainblock;
    private List<Transaction> transactions;

    @Before
    public void setUp() {
        this.chainblock = new ChainblockImpl();
        this.transactions = fillListOfTransactions();
    }

    @Test
    public void testContainsShouldReturnCorrectBoolean() {
        assertFalse(chainblock.contains(transactions.get(0).getId()));

        chainblock.add(transactions.get(0));
        assertTrue(chainblock.contains(transactions.get(0).getId()));
        assertEquals(1, chainblock.getCount());

        Transaction transaction2 = new TransactionImpl(2, TransactionStatus.SUCCESSFUL,
                "From", "To", 12.00);
        chainblock.add(transaction2);
        assertFalse(chainblock.contains(4));
        assertEquals(2, chainblock.getCount());
    }

    @Test
    public void testAddShouldReturnAddedTransactionByIdSuccessfully() {
        this.chainblock.add(this.transactions.get(0));
        assertEquals(1, chainblock.getCount());
    }

    @Test
    public void testAddShouldNotAddTransactionIfThereIsAlreadyOne() {
        this.chainblock.add(this.transactions.get(0));
        assertEquals(1, chainblock.getCount());
        this.chainblock.add(this.transactions.get(0));
        assertEquals(1, chainblock.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testChangeTransactionStatusThrowsExceptionIfIdNotExist() {
        int id = this.transactions.get(0).getId();
        this.chainblock.changeTransactionStatus(id, TransactionStatus.ABORTED);
    }

    @Test
    public void testChangeTransactionStatusShouldChangeItSuccessfully() {
        this.chainblock.add(this.transactions.get(0));
        Transaction transaction2 = new TransactionImpl(2, TransactionStatus.SUCCESSFUL,
                "From", "To", 13.00);
        this.chainblock.add(transaction2);
        this.chainblock.changeTransactionStatus(2, TransactionStatus.FAILED);
        Transaction byId = chainblock.getById(2);
        assertNotNull(byId);
        assertEquals(TransactionStatus.FAILED, byId.getStatus());
    }

    @Test
    public void testRemoveTransactionByIdReturnCorrectlyRemovedTransaction() {
        fillChainblock();
        int id = this.transactions.get(0).getId();
        this.chainblock.removeTransactionById(id);
        assertEquals(3,this.chainblock.getCount());
        assertFalse(this.chainblock.contains(id));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveTransactionShouldThrowExceptionWhenIdIsInvalid() {
        fillChainblock();
        this.chainblock.removeTransactionById(9);
    }

    @Test
    public void testGetByIdShouldReturnTransactionById() {
        fillChainblock();
        Transaction byId = this.chainblock.getById(2);
        assertNotNull(byId);

        assertEquals(2,byId.getId());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetByIdShouldThrowExceptionNotContainsIdInChainblock() {
        fillChainblock();
        this.chainblock.getById(5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetByTransactionStatusShouldReturnOrderedByAmount() {
        fillChainblock();
        this.chainblock.getByTransactionStatus(TransactionStatus.UNAUTHORIZED);
    }

    @Test
    public void testGetByTransactionStatusReturnValidTransactions() {
        fillChainblock();
        List<Transaction> expected = this.transactions.stream()
                .filter(t -> t.getStatus() == TransactionStatus.SUCCESSFUL)
                .collect(Collectors.toList());

        Iterable<Transaction> result =
                this.chainblock.getByTransactionStatus(TransactionStatus.SUCCESSFUL);
        assertNotNull(result);

        List<Transaction> actual = new ArrayList<>();
        result.forEach(actual::add);

        assertEquals(expected.size(),actual.size());

        for (Transaction transaction : actual) {
            assertEquals(TransactionStatus.SUCCESSFUL,transaction.getStatus());
        }
    }

    @Test
    public void testGetByTransactionStatusReturnValidTransactionsInCorrectOrder() {
        fillChainblock();
        List<Transaction> expected = this.transactions.stream()
                .filter(t -> t.getStatus() == TransactionStatus.SUCCESSFUL)
                .sorted(Comparator.comparing(Transaction::getAmount).reversed())
                .collect(Collectors.toList());

        Iterable<Transaction> result =
                this.chainblock.getByTransactionStatus(TransactionStatus.SUCCESSFUL);
        assertNotNull(result);

        List<Transaction> actual = new ArrayList<>();
        result.forEach(actual::add);

        assertEquals(expected.size(),actual.size());

        assertEquals(expected,actual);
    }




    private List<Transaction> fillListOfTransactions() {
        List<Transaction> transactions = new ArrayList<>();
        Transaction transaction = new TransactionImpl(1, TransactionStatus.SUCCESSFUL,
                "From", "To", 12.00);
        transactions.add(transaction);
        Transaction transaction2 = new TransactionImpl(2, TransactionStatus.SUCCESSFUL,
                "From2", "To2", 13.00);
        transactions.add(transaction2);
        Transaction transaction3 = new TransactionImpl(3, TransactionStatus.FAILED,
                "From3", "To3", 14.00);
        transactions.add(transaction3);
        Transaction transaction4 = new TransactionImpl(4, TransactionStatus.SUCCESSFUL,
                "From3", "To3", 15.00);
        transactions.add(transaction4);

        return transactions;
    }


    private void fillChainblock() {
        List<Transaction> transactions = fillListOfTransactions();
        for (Transaction tr : transactions) {
            this.chainblock.add(tr);
        }
    }


    private Transaction createTransaction() {
        return new TransactionImpl(10, TransactionStatus.UNAUTHORIZED,
                "Ivan", "Pesho", 102.00);
    }
}
