package com.challengerFinal.arte.controllers;

import com.challengerFinal.arte.dtos.OrderDto;
import com.challengerFinal.arte.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api")
public class OrderController {
    @Autowired
    OrderService orderService;
    @GetMapping("/orders")
    public List<OrderDto> getOrderRequestsAll() {
        return orderService.getOrderRequestsAll().stream().map(OrderDto::new).collect(Collectors.toList());
    }
}
