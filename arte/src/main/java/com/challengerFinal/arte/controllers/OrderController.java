package com.challengerFinal.arte.controllers;

import com.challengerFinal.arte.dtos.OrderRequestDto;
import com.challengerFinal.arte.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api")
public class OrderController {
    @Autowired
    OrderService orderService;
    @GetMapping("/orders")
    public List<OrderRequestDto> getOrderRequestsAll() {
        return orderService.getOrderRequestsAll();
    }
    @PostMapping("/addItemToCart")
    public ResponseEntity<Object> createPurchaseOrder(
            @RequestParam String nameProduct,
            @RequestParam int cant,
            Authentication authentication
    ) {
        return orderService.createPurchaseOrder(nameProduct, cant, authentication);
    }

    @DeleteMapping("/deleteItemFromCart/{id}")
    public ResponseEntity<Object> deleteItem(
            @PathVariable("id")Long id){
        return orderService.deleteItem(id);
    }
}
