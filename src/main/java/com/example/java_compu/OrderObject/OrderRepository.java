package com.example.java_compu.OrderObject;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
@Service
public interface OrderRepository extends JpaRepository<OrderObject, Long> {

}
