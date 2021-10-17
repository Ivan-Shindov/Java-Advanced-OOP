package store;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class StoreTests {
    private Store store;
    private Product product;

    @Before
    public void setUp() {
        this.store = new Store();
        this.product = new Product("Apple",1,2.50);
    }

    @Test
    public void testConstructor() {
        Store store = new Store();
        assertNotNull(store);
        assertEquals(0,this.store.getCount());
    }

    @Test
    public void testGetProducts() {
        List<Product> products = this.store.getProducts();
        assertEquals(0,products.size());
    }


    @Test(expected = UnsupportedOperationException.class)
    public void testGetProductsThrowsException() {
        this.store.getProducts().add(this.product);
    }

    @Test
    public void testAddProductReturnsBiggerCollectionSize() {
        this.store.addProduct(this.product);
        assertEquals(1,this.store.getCount());
    }


    @Test(expected = IllegalArgumentException.class)
    public void testAddProductThrowsExceptionWithNullValue() {
        this.store.addProduct(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddProductThrowsExceptionWithQuantityBelowZero() {
        Product product = new Product("Apple",-1,2.50);
        this.store.addProduct(product);
    }


    @Test
    public void testBuyProductReturnCorrectPrice() {
        Product product = new Product("Banana",12,2.20);
        this.store.addProduct(product);
        double price = this.store.buyProduct("Banana", 5);
        assertEquals(7,this.store.getProducts().get(0).getQuantity());
        assertEquals(7,product.getQuantity());
        assertEquals(11.00,price,0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testBuyProductThrowsExceptionWithNullValue() {
        Product product = new Product("Banana",12,2.20);
        this.store.addProduct(product);
        this.store.buyProduct(null,2);
    }


    @Test(expected = IllegalArgumentException.class)
    public void testBuyProductThrowsExceptionWithLesserQuantity() {
        Product product = new Product("Banana",12,2.20);
        this.store.addProduct(product);
        this.store.buyProduct("Banana",15);
    }


    @Test
    public void testGetMostExpensiveProductReturnCorrectProduct() {
        Product product = new Product("Banana",12,2.20);
        Product product2 = new Product("Apple",112,4.20);
        Product product3 = new Product("Orange",2,6.20);
        this.store.addProduct(product);
        this.store.addProduct(product2);
        this.store.addProduct(product3);

        Product theMostExpensiveProduct = this.store.getTheMostExpensiveProduct();
        assertEquals(product3.getPrice(),theMostExpensiveProduct.getPrice(),0);
    }

    @Test
    public void testGetMostExpensiveProductReturnsNullValue() {
        Product product = this.store.getTheMostExpensiveProduct();
        assertNull(product);
    }

}