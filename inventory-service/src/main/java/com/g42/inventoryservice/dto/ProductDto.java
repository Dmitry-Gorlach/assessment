package com.g42.inventoryservice.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDto {
    private Long id;
    private String productCode;
    private String name;
    private Integer availableQuantity;
}
