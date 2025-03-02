package com.g42.orderservice.dto;

import lombok.*;

@RequiredArgsConstructor
@Getter
public enum OrderStatusDto {
    CREATED,
    PENDING,
    COMPLETED
}
