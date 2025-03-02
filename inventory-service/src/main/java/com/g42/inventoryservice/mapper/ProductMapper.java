package com.g42.inventoryservice.mapper;

import com.g42.inventoryservice.dto.ProductDto;
import com.g42.inventoryservice.entity.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductDto toDTO(Product product);
    Product toEntity(ProductDto dto);
}
