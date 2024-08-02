package com.pedroaldama.inventory_service.servicies;

import com.pedroaldama.inventory_service.model.dto.BaseResponse;
import com.pedroaldama.inventory_service.model.dto.OrderItemRequest;

import java.util.List;

public interface InventoryService {
    Boolean isInStock(String sku);
    BaseResponse areInStock(List<OrderItemRequest> orderItems);
}
