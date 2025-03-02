package com.g42.inventoryservice.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "products")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_code", nullable = false)
    private String productCode;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "available_quantity")
    private Integer availableQuantity;
}
