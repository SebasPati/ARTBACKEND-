package com.challengerFinal.arte.dtos;

import com.challengerFinal.arte.model.ShoppingCart;

import java.io.Serializable;

public class ShoppingCartDto implements Serializable {
    private final Long id;
    private final Integer units;

    public ShoppingCartDto(ShoppingCart shoppingCart) {
        this.id = shoppingCart.getId();
        this.units = shoppingCart.getUnits();
    }

    public Long getId() {
        return id;
    }

    public Integer getUnits() {
        return units;
    }
}
