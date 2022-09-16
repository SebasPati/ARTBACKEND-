package com.challengerFinal.arte.service;

import com.challengerFinal.arte.model.OrderLineal;

import java.util.List;

public interface OrderLinealService {
    List<OrderLineal> getAllOrdersLineals();
    OrderLineal getOrderLinealId(Long id);
    OrderLineal saveOrderLineal(OrderLineal orderLineal);
}
