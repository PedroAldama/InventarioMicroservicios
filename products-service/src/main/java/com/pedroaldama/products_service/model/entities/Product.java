package com.pedroaldama.products_service.model.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table
@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
@Builder
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String sku;
    private String name;
    private String description;
    private Double price;
    private Boolean status;

    @Override
    public String toString() {
        return "Product{"+
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\''+
                "}";
    }
}
