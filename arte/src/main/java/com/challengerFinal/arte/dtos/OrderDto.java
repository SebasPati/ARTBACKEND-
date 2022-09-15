package com.challengerFinal.arte.dtos;

import com.challengerFinal.arte.model.OrderRequest;
import com.challengerFinal.arte.model.enums.StatePedido;

import java.io.Serializable;
import java.time.LocalDate;

public class OrderDto implements Serializable {
    private Long id;
    private LocalDate date;
    private StatePedido state;

    public OrderDto(OrderRequest order) {
        this.id = order.getId();
        this.date = order.getDate();
        this.state = order.getState();
    }

    public Long getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    public StatePedido getState() {
        return state;
    }
}
