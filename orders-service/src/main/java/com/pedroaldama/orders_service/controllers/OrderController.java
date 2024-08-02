package com.pedroaldama.orders_service.controllers;

import com.pedroaldama.orders_service.model.dto.OrderRequest;
import com.pedroaldama.orders_service.services.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/order")
@AllArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<?> placeOrder(@RequestBody OrderRequest orderRequest){
        orderService.placeOrder(orderRequest);
        return ResponseEntity.ok("Order placed Successfuylly");
    }

    @GetMapping
    public ResponseEntity<?> getOrders(){
        return ResponseEntity.ok(orderService.getAllOrders());
    }
}
