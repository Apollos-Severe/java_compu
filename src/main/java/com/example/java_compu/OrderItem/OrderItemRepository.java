package com.example.java_compu.OrderItem;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
@Service
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
