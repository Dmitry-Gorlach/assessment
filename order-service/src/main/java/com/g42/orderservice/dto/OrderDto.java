package com.g42.orderservice.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderDto {
    private Long id;
    private String customerName;
    private String productCode;
    private Integer quantity;
    private OrderStatusDto status;
}
