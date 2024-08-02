package com.pedroaldama.inventory_service.servicies;

import com.pedroaldama.inventory_service.model.dto.BaseResponse;
import com.pedroaldama.inventory_service.model.dto.OrderItemRequest;
import com.pedroaldama.inventory_service.model.entities.Inventory;
import com.pedroaldama.inventory_service.repositories.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class InventoryServiceImpl implements InventoryService {

    private final InventoryRepository inventoryRepository;

    @Override
    public Boolean isInStock(String sku) {
        Optional<Inventory> inventory = inventoryRepository.findBySku(sku);
        return inventory.filter(value -> value.getQuantity() > 0).isPresent();
    }

    @Override
    public BaseResponse areInStock(List<OrderItemRequest> orderItems) {
        var errorList = new ArrayList<String>();
        List<String> skus = orderItems.stream().map(OrderItemRequest::getSku).toList();

        List<Inventory> inventoryList = inventoryRepository.findBySkuIn(skus);

        orderItems.forEach(orderItem ->{
            var inventory = inventoryList.stream().filter(value -> value.getSku().equals(orderItem.getSku())).findFirst();
            if(inventory.isEmpty()){
                errorList.add("Product with sku " + orderItem.getSku() + " doesn't exist");
            } else if(inventory.get().getQuantity() < orderItem.getQuantity()){
                errorList.add("Product with sku " + orderItem.getSku() + " has insufficient quantity");
            }
        } );

        return !errorList.isEmpty() ? new BaseResponse(errorList.toArray(new String[0])) : new BaseResponse(null);
    }
}
