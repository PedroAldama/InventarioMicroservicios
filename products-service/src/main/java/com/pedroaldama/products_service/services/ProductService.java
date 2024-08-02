package com.pedroaldama.products_service.services;

import com.pedroaldama.products_service.model.dtos.ProductRequest;
import com.pedroaldama.products_service.model.dtos.ProductResponse;

import java.util.List;

public interface ProductService {

     void addProduct(ProductRequest productRequest);
     List<ProductResponse> getAllProducts();
}
