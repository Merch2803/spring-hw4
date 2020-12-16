package ru.geekbrains.boot.springboothw4.services;

import org.springframework.stereotype.Component;
import ru.geekbrains.boot.springboothw4.model.Product;
import ru.geekbrains.boot.springboothw4.repositories.ProductRepository;

import java.util.List;

@Component
public class ProductService {
    private ProductRepository productRepository;

    public List<Product> findAll() {
        return productRepository.getProducts();
    }

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void add(Product product) {
        productRepository.add(product);
    }

    public void removeById(Integer id) {
        productRepository.removeById(id);
    }
}
