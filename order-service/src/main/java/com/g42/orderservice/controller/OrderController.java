package com.g42.orderservice.controller;

import com.g42.orderservice.dto.OrderDto;
import com.g42.orderservice.service.OrderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
@Tag(name = "Order Service", description = "Operations pertaining to orders")
public class OrderController {
    private final OrderService orderService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Create a new order")
    public OrderDto createOrder(@RequestBody OrderDto orderDTO) {
        return orderService.createOrder(orderDTO);
    }

    @GetMapping
    @Operation(summary = "Retrieve all orders")
    public List<OrderDto> getOrders() {
        return orderService.getAllOrders();
    }
}
