package com.pedroaldama.orders_service.services;

import com.pedroaldama.orders_service.model.dto.OrderRequest;
import com.pedroaldama.orders_service.model.dto.OrderResponse;
import com.pedroaldama.orders_service.model.entities.Order;

import java.util.List;

public interface OrderService {
    void placeOrder(OrderRequest orderRequest);
    List<OrderResponse> getAllOrders();
}
