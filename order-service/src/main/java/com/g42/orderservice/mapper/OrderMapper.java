package com.g42.orderservice.mapper;

import com.g42.orderservice.dto.*;
import com.g42.orderservice.entity.*;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    OrderDto toDto(Order order);
    Order toEntity(OrderDto dto);
    OrderStatusDto toOrderStatusDto(OrderStatus orderStatus);
    OrderStatus toOrderStatus(OrderStatusDto orderStatus);
}
