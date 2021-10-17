import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class ProductStockTest {

    private ProductStock stock;

    @Before
    public void setUp() {
        stock = new Instock();
    }

    @Test
    public void testGetCountShouldReturnCorrectSize() {
        assertEquals(0, this.stock.getCount());
        this.stock.add(new Product());
        assertEquals(1, this.stock.getCount());
    }

    @Test
    public void testContainsShouldReturnIfProductsIsInStock() {
        Product product = createProduct();
        assertFalse(this.stock.contains(product));

        this.stock.add(product);
        assertTrue(this.stock.contains(product));

        Product product2 = new Product("label_2", 30.0, 1);
        assertFalse(this.stock.contains(product2));
    }

    @Test
    public void testAddCorrectlyTheProductInStock() {
        Product product = createProduct();
        this.stock.add(product);
        assertTrue(this.stock.contains(product));
    }

    @Test
    public void testFindTheProductWithGivenIndexInBoundsAtBeginning() {
        int index = 0;
        Product product = createProduct();
        this.stock.add(product);
        Product product1 = this.stock.find(index);
        assertNotNull(product1);
        assertEquals(this.stock.find(index).getLabel(), product1.getLabel());
    }

    @Test
    public void testFindProductWithGivenIndexInBoundsAtMiddle() {
        fillProductsIntStock(8);
        Product product;
        int index = 0;
        if (stock.getCount() % 2 == 0) {
            index = (stock.getCount() / 2) - 1;
            product = this.stock.find(index);
        } else {
            index = stock.getCount() / 2;
            product = this.stock.find(index);
        }
        assertNotNull(product);
        assertEquals(product, this.stock.find(index));
    }

    @Test
    public void testFindTheProductWithGivenIndexInBoundsAtTheEnd() {
        fillProductsIntStock(6);
        Product product = createProduct();
        this.stock.add(product);
        int index = this.stock.getCount() - 1;
        Product product1 = this.stock.find(index);
        assertNotNull(product1);
        assertEquals(this.stock.find(index).getLabel(), product1.getLabel());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testFindTheProductWithIndexOutOfBounds() {
        createListOfProducts(3);
        this.stock.find(4);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testFindTheProductWithIndexBelowZero() {
        this.stock.find(-1);
    }

    @Test
    public void testChangeQuantityIfProductsIsInStock() {
        int newQuantity = 5;
        Product product = createProduct();
        this.stock.add(product);
        this.stock.changeQuantity(product.getLabel(), newQuantity);
        Product productByIndex = this.stock.find(0);
        assertNotNull(productByIndex);
        assertEquals(newQuantity, productByIndex.getQuantity());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testChangeQuantityIfProductsIsNotInStock() {
        Product product = createProduct();
        this.stock.changeQuantity(product.getLabel(), product.getQuantity() + 10);
    }

    @Test
    public void testReturnProductWithGivenLabelFoundByStringLabel() {
        fillProductsIntStock(2);
        Product product = createProduct();
        product.setLabel("ivan");
        stock.add(product);
        Product productFound = this.stock.findByLabel("ivan");
        assertNotNull(productFound);
        assertEquals(productFound.getLabel(), product.getLabel());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testReturnProductWithGivenInvalidLabelException() {
        Product product = createProduct();
        this.stock.add(product);
        assertNotNull(product);
        this.stock.findByLabel("not_exist_label");
    }

    @Test
    public void testFindFirstByAlphabeticalOrderWithValidIndex() {
        Product product1 = new Product("label100", 1.0, 1);
        Product product2 = new Product("label20", 1.0, 1);
        Product product3 = new Product("label3000", 1.0, 1);
        Product product4 = new Product("label444", 1.0, 1);
        Product product5 = new Product("label5", 1.0, 1);

        this.stock.add(product1);
        this.stock.add(product2);
        this.stock.add(product3);
        this.stock.add(product4);
        this.stock.add(product5);

        Iterable<Product> firstProducts = this.stock.findFirstByAlphabeticalOrder(4);
        assertNotNull(firstProducts);

        List<Product> returnedProducts = createListFromIterable(firstProducts);

        Set<String> orderedProductsByName = returnedProducts.stream()
                .map(Product::getLabel)
                .collect(Collectors.toCollection(TreeSet::new));

        assertEquals(4, returnedProducts.size());

        int index = 0;
        for (String p : orderedProductsByName) {
            assertEquals(p, returnedProducts.get(index++).getLabel());
        }
    }

    @Test
    public void testFindAllInPriceRangeShouldReturnListOfProducts() {
        Product product1 = new Product("label1", 1.0, 1);
        Product product2 = new Product("label2", 2.0, 1);
        Product product3 = new Product("label3", 3.0, 1);
        Product product4 = new Product("label4", 4.0, 1);
        Product product5 = new Product("label5", 5.0, 1);
        Product product6 = new Product("label6", 6.0, 1);

        this.stock.add(product1);
        this.stock.add(product2);
        this.stock.add(product3);
        this.stock.add(product4);
        this.stock.add(product5);
        this.stock.add(product6);

        //lower exclusive , higher is inclusive
        double lowerPrice = 2.00;
        double higherPrice = 5.00;
        Iterable<Product> allInRange = stock.findAllInRange(lowerPrice, higherPrice);
        assertNotNull(allInRange);

        List<Product> productList = createListFromIterable(allInRange);
        assertEquals(3, productList.size());

        assertEquals(5.0, productList.get(0).getPrice(), 0);
        assertEquals(4.0, productList.get(1).getPrice(), 0);
        assertEquals(3.0, productList.get(2).getPrice(), 0);
    }

    @Test
    public void testFindAllInPriceRangeShouldReturnEmptyListOfProducts() {
        Product product1 = new Product("label100", 1.0, 1);
        Product product2 = new Product("label20", 2.0, 1);
        Product product6 = new Product("label6", 6.0, 1);

        this.stock.add(product1);
        this.stock.add(product2);
        this.stock.add(product6);

        //lower exclusive , higher is inclusive
        double lowerPrice = 2.00;
        double higherPrice = 5.00;
        Iterable<Product> allInRange = stock.findAllInRange(lowerPrice, higherPrice);
        assertNotNull(allInRange);

        List<Product> productList = createListFromIterable(allInRange);
        assertEquals(0, productList.size());
    }

    @Test
    public void testFindAllByPriceInNonEmptyListShouldReturnListOfProducts() {
        Product product1 = new Product("label1", 11.0, 1);
        Product product2 = new Product("label2", 2.0, 1);
        Product product3 = new Product("label3", 11.0, 1);
        Product product4 = new Product("label4", 4.0, 1);
        Product product5 = new Product("label5", 11.0, 1);
        Product product6 = new Product("label6", 6.0, 1);

        this.stock.add(product1);
        this.stock.add(product2);
        this.stock.add(product3);
        this.stock.add(product4);
        this.stock.add(product5);
        this.stock.add(product6);

        Iterable<Product> productsByPrice = this.stock.findAllByPrice(11.0);
        assertNotNull(productsByPrice);

        List<Product> listBySamePriceProducts = createListFromIterable(productsByPrice);

        assertEquals(3, listBySamePriceProducts.size());
        for (Product product : listBySamePriceProducts) {
            assertEquals(11.00, product.getPrice(), 0);
        }
    }

    @Test
    public void testFindAllByPriceInEmptyListShouldReturnEmptyListOfProducts() {
        Product product2 = new Product("label2", 2.0, 1);
        Product product4 = new Product("label4", 4.0, 1);
        Product product6 = new Product("label6", 6.0, 1);

        this.stock.add(product2);
        this.stock.add(product4);
        this.stock.add(product6);

        Iterable<Product> productsByPrice = this.stock.findAllByPrice(11.00);
        assertNotNull(productsByPrice);

        List<Product> listBySamePriceProducts = createListFromIterable(productsByPrice);

        assertEquals(0, listBySamePriceProducts.size());
    }

    @Test
    public void testFindFirstMostExpensiveProductsInNonEmptyList() {
        Product product1 = new Product("label1", 1.0, 1);
        Product product2 = new Product("label2", 2.0, 1);
        Product product3 = new Product("label3", 3.0, 1);
        Product product4 = new Product("label4", 4.0, 1);
        Product product5 = new Product("label5", 5.0, 1);
        Product product6 = new Product("label6", 6.0, 1);

        this.stock.add(product1);
        this.stock.add(product2);
        this.stock.add(product3);
        this.stock.add(product4);
        this.stock.add(product5);
        this.stock.add(product6);

        Iterable<Product> allInRange = stock.findFirstMostExpensiveProducts(3);
        assertNotNull(allInRange);

        List<Product> listFromIterable = createListFromIterable(allInRange);
        assertEquals(3,listFromIterable.size());

        assertEquals(6.00,listFromIterable.get(0).getPrice(),0);
        assertEquals(5.00,listFromIterable.get(1).getPrice(),0);
        assertEquals(4.00,listFromIterable.get(2).getPrice(),0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindFirstMostExpensiveIfGivenCountIsBiggerThanSizeThrowsException() {
        List<Product> listOfProducts = createListOfProducts(5);
        this.stock.findFirstMostExpensiveProducts(8);
    }

    @Test
    public void testFindAllByQuantityProductsInNonEmptyList() {
        Product product1 = new Product("label1", 1.0, 1);
        Product product2 = new Product("label2", 2.0, 1);
        Product product3 = new Product("label3", 3.0, 1);
        Product product4 = new Product("label4", 4.0, 3);
        Product product5 = new Product("label5", 5.0, 1);
        Product product6 = new Product("label6", 6.0, 3);

        this.stock.add(product1);
        this.stock.add(product2);
        this.stock.add(product3);
        this.stock.add(product4);
        this.stock.add(product5);
        this.stock.add(product6);

        Iterable<Product> allInRange = stock.findAllByQuantity(3);
        assertNotNull(allInRange);

        List<Product> productList = createListFromIterable(allInRange);
        assertEquals(2,productList.size());

        for (Product product : productList) {
            assertEquals(3, product.getQuantity());
        }
    }

    @Test
    public void testFindAllByQuantityProductsInEmptyListShouldReturnEmptyList() {
        Product product2 = new Product("label2", 2.0, 1);
        Product product4 = new Product("label4", 4.0, 1);
        Product product6 = new Product("label6", 6.0, 1);

        this.stock.add(product2);
        this.stock.add(product4);
        this.stock.add(product6);

        Iterable<Product> productsByPrice = this.stock.findAllByQuantity(3);
        assertNotNull(productsByPrice);

        List<Product> listBySamePriceProducts = createListFromIterable(productsByPrice);

        assertEquals(0, listBySamePriceProducts.size());
    }

    @Test
    public void testGetIterableProductsInNonEmptyList() {
        Product product1 = new Product("label1", 1.0, 1);
        Product product2 = new Product("label2", 2.0, 1);
        Product product3 = new Product("label3", 3.0, 1);
        Product product4 = new Product("label4", 4.0, 3);
        Product product5 = new Product("label5", 5.0, 1);
        Product product6 = new Product("label6", 6.0, 3);

        this.stock.add(product1);
        this.stock.add(product2);
        this.stock.add(product3);
        this.stock.add(product4);
        this.stock.add(product5);
        this.stock.add(product6);

        Iterator<Product> allInRange = stock.iterator();
        assertNotNull(allInRange);

        List<Product> productList = new ArrayList<>();

        while (allInRange.hasNext()) {
            Product nextProduct = allInRange.next();
            productList.add(nextProduct);
        }

        assertEquals(6, productList.size());
    }

    @Test
    public void testGetIterableShouldReturnEmptyList() {

        Iterator<Product> productsByPrice = this.stock.iterator();
        assertNotNull(productsByPrice);

        List<Product> listBySamePriceProducts = new ArrayList<>();
        while (productsByPrice.hasNext()) {
            Product nextProduct = productsByPrice.next();
            listBySamePriceProducts.add(nextProduct);
        }
        assertEquals(0, listBySamePriceProducts.size());
    }


    private <T> List<T> createListFromIterable(Iterable<T> firstProducts) {
        List<T> result = new ArrayList<>();

        for (T product : firstProducts) {
            result.add(product);
        }
        return result;
    }


    private Product createProduct() {
        return new Product("label_1", 30.0, 1);
    }

    private List<Product> createListOfProducts(int count) {
        List<Product> products = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            Product product = createProduct();
            product.setLabel("label_" + i);
            products.add(product);
        }
        return products;
    }

    private void fillProductsIntStock(int count) {
        List<Product> listOfProducts = createListOfProducts(count);

        for (Product product : listOfProducts) {
            this.stock.add(product);
        }
    }
}
