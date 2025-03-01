package com.g42.orderservice.mapper;

import com.g42.orderservice.dto.OrderDto;
import com.g42.orderservice.entity.Order;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    OrderDto toDto(Order order);
    Order toEntity(OrderDto dto);
}
