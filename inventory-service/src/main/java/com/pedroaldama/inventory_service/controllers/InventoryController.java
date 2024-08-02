package com.pedroaldama.inventory_service.controllers;

import com.pedroaldama.inventory_service.model.dto.BaseResponse;
import com.pedroaldama.inventory_service.model.dto.OrderItemRequest;
import com.pedroaldama.inventory_service.servicies.InventoryService;
import lombok.AllArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventory")
@AllArgsConstructor
public class InventoryController {

    private final InventoryService inventoryService;

    @GetMapping("/{sku}")
    public Boolean isInStock(@PathVariable("sku") String sku){
        return inventoryService.isInStock(sku);
    }

    @PostMapping("/in-stock")
    public ResponseEntity<BaseResponse> areInStock(@RequestBody List<OrderItemRequest> orderItems){
        return ResponseEntity.ok(inventoryService.areInStock(orderItems));
    }
}
