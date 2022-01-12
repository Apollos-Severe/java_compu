package com.example.java_compu.PaymentDetail;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
@Service // This class with be injected somewhere
public interface PaymentRepository
                extends JpaRepository<PaymentDetail, Long> {
}
