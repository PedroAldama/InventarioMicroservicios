package com.pedroaldama.orders_service.model.entities;

import jakarta.persistence.*;
import lombok.*;
import java.util.*;

@Entity
@Table(name="orders")
@AllArgsConstructor @NoArgsConstructor
@Setter @Getter
@Builder
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String orderNumber;

    @OneToMany(mappedBy = "order",cascade = CascadeType.ALL)
    private List<OrderItems> orderItems;
}
