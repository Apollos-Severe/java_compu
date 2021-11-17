package com.example.java_compu.Product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
@Service // This line is what helps this class know that it has to be injected somewhere!
public interface ProductRepository extends JpaRepository<Product, Long> {
}
