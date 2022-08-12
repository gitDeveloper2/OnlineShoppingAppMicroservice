package com.example.inventoryservice.service;

import com.example.inventoryservice.dto.InventoryDTO;
import com.example.inventoryservice.model.Inventory;
import com.example.inventoryservice.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InventoryService {
    private final InventoryRepository inventoryRepository;
    public List<InventoryDTO> isInStock(List<String> productCodes){
    List<Inventory> inventoryList=inventoryRepository.findByproduct_codeIn(productCodes);
    List<InventoryDTO> inventoryDTOS=inventoryList.stream().map(
            inventory -> {

                return InventoryDTO.builder().
                        product_code(inventory.getProduct_code()).
                        quantity(inventory.getQuantity()).
                        isAvailable(inventory.getQuantity()>0).
                        build();

            }
    ).toList();
    return inventoryDTOS;
    }

}
