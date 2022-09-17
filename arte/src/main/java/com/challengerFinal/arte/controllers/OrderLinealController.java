package com.challengerFinal.arte.controllers;

import com.challengerFinal.arte.dtos.OrderLinealDto;
import com.challengerFinal.arte.service.OrderLinealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api")
public class OrderLinealController {
    @Autowired
    OrderLinealService orderLinealService;

    @GetMapping(value = "/orderLineal")
    public List<OrderLinealDto> getOrderLineal() {
        return orderLinealService.getAllOrdersLineals().stream().map(OrderLinealDto::new).collect(Collectors.toList());
    }
}
