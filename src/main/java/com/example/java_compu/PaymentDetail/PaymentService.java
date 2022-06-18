package com.example.java_compu.PaymentDetail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.java_compu.OrderItem.OrderItemRepository;

import java.util.List;

@Service
public class PaymentService {
    private PaymentRepository paymentRepository;
    private OrderItemRepository orderItemRepository;

    @Autowired
    public PaymentService(PaymentRepository paymentRepository, OrderItemRepository orderItemRepository) {
        this.paymentRepository = paymentRepository;
        this.orderItemRepository = orderItemRepository;
    }

    public List<PaymentDetail> getAllPayments() {
        return paymentRepository.findAll();
    }
}
