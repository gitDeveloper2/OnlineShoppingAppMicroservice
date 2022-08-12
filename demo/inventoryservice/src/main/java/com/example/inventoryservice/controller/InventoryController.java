package com.example.inventoryservice.controller;

import com.example.inventoryservice.dto.InventoryDTO;
import com.example.inventoryservice.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/inventory")
public class InventoryController {
    private final InventoryService inventoryService;
    @ResponseStatus(HttpStatus.OK)
    public List<InventoryDTO> isInStock(List<String> product_codes){
        return inventoryService.isInStock(product_codes);

    }

}
