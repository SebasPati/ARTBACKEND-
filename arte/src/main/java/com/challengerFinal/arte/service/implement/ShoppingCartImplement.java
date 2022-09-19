package com.challengerFinal.arte.service.implement;

import com.challengerFinal.arte.model.ShoppingCart;
import com.challengerFinal.arte.repositories.ShoppingCartRepository;
import com.challengerFinal.arte.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ShoppingCartImplement implements ShoppingCartService {
    @Autowired
    ShoppingCartRepository orderRepository;
    @Override
    public List<ShoppingCart> getAllOrdersLineals() {
        return orderRepository.findAll();
    }

    @Override
    public ShoppingCart getOrderLinealId(Long id) {
        return orderRepository.findById(id).get();
    }

    @Override
    public ShoppingCart saveOrderLineal(ShoppingCart shoppingCart) {
        return orderRepository.save(shoppingCart);
    }
}
