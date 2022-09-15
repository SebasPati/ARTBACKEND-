package com.challengerFinal.arte.service;

import com.challengerFinal.arte.model.OrderRequest;

import java.util.List;

public interface OrderService {
    OrderRequest getOrderRequest(Long id);
    List<OrderRequest> getOrderRequestsAll();
    OrderRequest saveRequest(OrderRequest orderRequest);
}
