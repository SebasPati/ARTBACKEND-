package com.challengerFinal.arte.service;

import com.challengerFinal.arte.model.ShoppingCart;

import java.util.List;

public interface ShoppingCartService {
    List<ShoppingCart> getAllOrdersLineals();
    ShoppingCart getOrderLinealId(Long id);
    ShoppingCart saveOrderLineal(ShoppingCart shoppingCart);
}
