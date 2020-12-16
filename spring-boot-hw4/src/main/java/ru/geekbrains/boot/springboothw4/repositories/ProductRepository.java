package ru.geekbrains.boot.springboothw4.repositories;

import org.springframework.stereotype.Component;
import ru.geekbrains.boot.springboothw4.model.Product;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Component
public class ProductRepository {
    private List<Product> products;

    @PostConstruct
    public void init() {
        this.products = new ArrayList<>(Arrays.asList(
                new Product(1, "Яблоки", 500),
                new Product(2, "Груши", 560),
                new Product(3, "Мандарины", 600),
                new Product(4, "Бананы", 580),
                new Product(5, "Киви", 650)
        ));
    }

    public List<Product> getProducts() {
        return Collections.unmodifiableList(products);
    }

    public Product getProductById(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return new Product(product.getId(), product.getName(), product.getPrice());
            }
        }
        throw new RuntimeException("There is no any product with this id!");
    }

    public void add(Product product) {
        products.add(product);
    }

    public void removeById(Integer id) {
        products.removeIf(p -> p.getId() == id);
    }
}
