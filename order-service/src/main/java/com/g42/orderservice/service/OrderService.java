package com.g42.orderservice.service;

import com.g42.orderservice.dto.OrderDto;
import com.g42.orderservice.entity.*;
import com.g42.orderservice.mapper.OrderMapper;
import com.g42.orderservice.repository.OrderRepository;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

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

    @CircuitBreaker(name = "inventoryService", fallbackMethod = "inventoryFallback")
    public void callInventoryUpdate(String productCode, Integer delta) {
        // we can call Inventory Service via REST
    }

    public void inventoryFallback(String productCode, Integer delta, Throwable t) {
        // we can add fallback logic, e.g. log warning
    }
}
