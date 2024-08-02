package com.pedroaldama.orders_service.model.dto;


import com.pedroaldama.orders_service.model.entities.OrderItems;

import java.util.List;

public record OrderResponse(Long id, String orderNumber, List<OrderItemsResponse> orderItems) {
}
