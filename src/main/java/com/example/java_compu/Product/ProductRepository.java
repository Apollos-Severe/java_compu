package com.example.java_compu.Product;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
@Service // This line is what helps this class know that it has to be injected somewhere!
public interface ProductRepository extends JpaRepository<Product, Long> {

    // Here you can add alot of your own custom functions to grab information
    /*
     * This is good because on Node.js you can write a whole function to grab info
     * on one route
     * and need to do the same in another place but you will just have to rewrite
     * everything again!!
     * 
     * - Here, you can just define a function here and have it set in you service
     */

    // All you have to do here is Camel Case the function name
    public List<Product> findByCategory(String category);

    public List<Product> findByCategoryContaining(String category);
}
