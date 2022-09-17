package com.challengerFinal.arte.dtos;

import com.challengerFinal.arte.model.OrderRequest;
import com.challengerFinal.arte.model.enums.StatePedido;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;
import java.util.stream.Collectors;


public class OrderRequestDto implements Serializable {
    private Long id;
    private LocalDate date;
    private StatePedido state;
    private Set<OrderLinealDto> orders;

    public OrderRequestDto(OrderRequest orderRequest) {
        this.id = orderRequest.getId();
        this.date = orderRequest.getDate();
        this.state = orderRequest.getState();
        this.orders = orderRequest.getOrders().stream().map(OrderLinealDto::new ).collect(Collectors.toSet());

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

    public Set<OrderLinealDto> getOrders() {
        return orders;
    }
}
