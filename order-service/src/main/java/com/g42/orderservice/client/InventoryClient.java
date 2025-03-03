package com.g42.orderservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "inventoryClient", url = "${inventory.service.url}")
public interface InventoryClient {

    @GetMapping("/api/inventory/check")
    boolean checkInventory(@RequestParam("productCode") String productCode);
}
