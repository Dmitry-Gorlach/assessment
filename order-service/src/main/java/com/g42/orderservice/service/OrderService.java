package com.g42.orderservice.service;

import com.g42.orderservice.dto.OrderDto;
import com.g42.orderservice.entity.*;
import com.g42.orderservice.mapper.OrderMapper;
import com.g42.orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    public OrderDto createOrder(OrderDto orderDto) {
        Order order = orderMapper.toEntity(orderDto);
        order.setStatus(OrderStatus.CREATED);
        Order saved = orderRepository.save(order);
        return orderMapper.toDto(saved);
    }

    public List<OrderDto> getAllOrders() {
        return orderRepository.findAll().stream()
                .map(orderMapper::toDto)
                .toList();
    }
}
