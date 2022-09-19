package com.challengerFinal.arte.controllers;

import com.challengerFinal.arte.dtos.ShoppingCartDto;
import com.challengerFinal.arte.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api")
public class ShoppingCartController {
    @Autowired
    ShoppingCartService shoppingCartService;

    @GetMapping(value = "/orderLineal")
    public List<ShoppingCartDto> getOrderLineal() {
        return shoppingCartService.getAllOrdersLineals().stream().map(ShoppingCartDto::new).collect(Collectors.toList());
    }
}
