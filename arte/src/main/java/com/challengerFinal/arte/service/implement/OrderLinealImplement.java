package com.challengerFinal.arte.service.implement;

import com.challengerFinal.arte.model.OrderLineal;
import com.challengerFinal.arte.repositories.OrderLinealRepository;
import com.challengerFinal.arte.service.OrderLinealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderLinealImplement implements OrderLinealService {
    @Autowired
    OrderLinealRepository orderRepository;
    @Override
    public List<OrderLineal> getAllOrdersLineals() {
        return orderRepository.findAll();
    }

    @Override
    public OrderLineal getOrderLinealId(Long id) {
        return orderRepository.findById(id).get();
    }

    @Override
    public OrderLineal saveOrderLineal(OrderLineal orderLineal) {
        return orderRepository.save(orderLineal);
    }
}
