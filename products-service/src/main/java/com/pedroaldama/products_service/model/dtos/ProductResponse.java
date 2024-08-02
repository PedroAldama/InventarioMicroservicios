package com.pedroaldama.products_service.model.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductResponse {
    private Long id;
    private String sku;
    private String name;
    private String description;
    private Double price;
    private Boolean status;
}
