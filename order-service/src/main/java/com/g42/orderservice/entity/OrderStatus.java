package com.g42.orderservice.entity;

import lombok.*;

@RequiredArgsConstructor
@Getter
public enum OrderStatus {
    CREATED,
    PENDING,
    COMPLETED
}
