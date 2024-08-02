package com.pedroaldama.products_service.controllers;

import com.pedroaldama.products_service.model.dtos.ProductRequest;
import com.pedroaldama.products_service.model.dtos.ProductResponse;
import com.pedroaldama.products_service.repositories.ProductRepository;
import com.pedroaldama.products_service.services.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@AllArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addProduct(@RequestBody ProductRequest productRequest){
        this.productService.addProduct(productRequest);
    }

    @GetMapping
    public ResponseEntity<List<ProductResponse>> getAllProducts(){
        return ResponseEntity.ok(productService.getAllProducts());
    }
}

