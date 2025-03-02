package com.g42.inventoryservice.controller;

import com.g42.inventoryservice.dto.ProductDto;
import com.g42.inventoryservice.service.InventoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/inventory")
@RequiredArgsConstructor
@Tag(name = "Inventory Service", description = "Operations for managing inventory")
public class InventoryController {
    private final InventoryService inventoryService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Add a new product")
    public ProductDto addProduct(@RequestBody ProductDto productDto) {
        return inventoryService.addProduct(productDto);
    }

    @GetMapping
    @Operation(summary = "Retrieve all products")
    public List<ProductDto> getProducts() {
        return inventoryService.getProducts();
    }

    @PutMapping("/{productCode}/update")
    @Operation(summary = "Update inventory quantity")
    public void updateInventory(@PathVariable String productCode, @RequestParam Integer delta) {
        inventoryService.updateInventory(productCode, delta);
    }
}
