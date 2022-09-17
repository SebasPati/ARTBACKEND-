package com.challengerFinal.arte.dtos;

import com.challengerFinal.arte.model.OrderLineal;

import java.io.Serializable;

public class OrderLinealDto implements Serializable {
    private final Long id;
    private final Integer units;

    public OrderLinealDto(OrderLineal orderLineal) {
        this.id = orderLineal.getId();
        this.units = orderLineal.getUnits();
    }

    public Long getId() {
        return id;
    }

    public Integer getUnits() {
        return units;
    }
}
