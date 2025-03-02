package com.g42.inventoryservice.service;

import com.g42.inventoryservice.dto.ProductDto;
import com.g42.inventoryservice.entity.Product;
import com.g42.inventoryservice.mapper.ProductMapper;
import com.g42.inventoryservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class InventoryService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public ProductDto addProduct(ProductDto productDTO) {
        Product product = productMapper.toEntity(productDTO);
        Product saved = productRepository.save(product);
        return productMapper.toDTO(saved);
    }

    public List<ProductDto> getProducts() {
        return productRepository.findAll().stream()
                .map(productMapper::toDTO)
                .toList();
    }

    public void updateInventory(String productCode, Integer delta) {
        Product product = productRepository.findByProductCode(productCode);
        if (product != null) {
            product.setAvailableQuantity(product.getAvailableQuantity() + delta);
            productRepository.save(product);
        }
    }
}
