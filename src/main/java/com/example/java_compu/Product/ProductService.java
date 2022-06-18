package com.example.java_compu.Product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// We have to let this class know that it has to be instantiated

@Service // Lets class know it has to be injected somewhere!
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired // Says this class needs this dependency injected!
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public void addProduct(Product product) {
        System.out.println(product + "<------ Heyyyy");
        productRepository.save(product);
    }

    public void deleteProduct(Long productId) {
        System.out.println(productId + "<------ Heyyyy");
        boolean productExists = productRepository.existsById(productId);

        if (!productExists) {
            throw new IllegalStateException("Product with id" + productId + "does not exists!");
        }

        productRepository.deleteById(productId);
    }

}
