package com.example.inventoryservice.dto;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InventoryDTO {
    Long product_code;
    Integer quantity;
    boolean isAvailable;
}
