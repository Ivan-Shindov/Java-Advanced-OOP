import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Instock implements ProductStock {
    private List<Product> productStocks;

    public Instock() {
        this.productStocks = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return this.productStocks.size();
    }

    @Override
    public boolean contains(Product product) {
        for (Product product1 : this.productStocks) {
            if (product1.getLabel().equals(product.getLabel())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void add(Product product) {
        this.productStocks.add(product);
    }

    @Override
    public void changeQuantity(String product, int quantity) {
        for (Product productStock : this.productStocks) {
            if(productStock.getLabel().equals(product)) {
                productStock.setQuantity(quantity);
                return;
            }
        }

        throw new IllegalArgumentException();
    }

    @Override
    public Product find(int index) {
        if (index < 0 || index >= this.productStocks.size()) {
            throw new IndexOutOfBoundsException();
        }

        return this.productStocks.get(index);
    }

    @Override
    public Product findByLabel(String label) {
        for (Product productStock : this.productStocks) {
            if(productStock.getLabel().equals(label)) {
                return productStock;
            }
        }

        throw new IllegalArgumentException();
    }

    @Override
    public Iterable<Product> findFirstByAlphabeticalOrder(int count) {
        if (count > this.getCount() || count < 0) {
            return new ArrayList<>();
        }

        return this.productStocks.stream()
                .sorted(Comparator.comparing(Product::getLabel))
                .limit(count)
                .collect(Collectors.toList());
    }

    @Override
    public Iterable<Product> findAllInRange(double lo, double hi) {
        return this.productStocks.stream()
                .filter(p -> p.getPrice() > lo && p.getPrice() <= hi)
                .sorted(Comparator.comparing(Product::getPrice).reversed())
                .collect(Collectors.toList());
    }

    @Override
    public Iterable<Product> findAllByPrice(double price) {
        return this.productStocks.stream()
                .filter(p -> p.getPrice() == price)
                .collect(Collectors.toList());
    }

    @Override
    public Iterable<Product> findFirstMostExpensiveProducts(int count) {
        if (count > this.getCount()) {
            throw new IllegalArgumentException();
        }

        return this.productStocks.stream()
                .sorted(Comparator.comparing(Product::getPrice).reversed())
                .limit(count)
                .collect(Collectors.toList());
    }

    @Override
    public Iterable<Product> findAllByQuantity(int quantity) {
        return this.productStocks.stream()
                .filter(p -> p.getQuantity() == quantity)
                .collect(Collectors.toList());
    }

    @Override
    public Iterator<Product> iterator() {
        return this.productStocks.iterator();
    }
}
