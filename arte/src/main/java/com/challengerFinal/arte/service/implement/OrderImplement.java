package com.challengerFinal.arte.service.implement;

import com.challengerFinal.arte.model.OrderRequest;
import com.challengerFinal.arte.repositories.OrderRepository;
import com.challengerFinal.arte.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderImplement implements OrderService {
    @Autowired
    OrderRepository orderRepository;
    @Override
    public OrderRequest getOrderRequest(Long id) {
        return orderRepository.findById(id).get();
    }

    @Override
    public List<OrderRequest> getOrderRequestsAll() {
        return orderRepository.findAll();
    }

    @Override
    public OrderRequest saveRequest(OrderRequest orderRequest) {
        return orderRepository.save(orderRequest);
    }
}
