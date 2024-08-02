package com.pedroaldama.orders_service.model.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrderItemRequest {
    private Long id;
    private String sku;
    private Double price;
    private Long quantity;
}
