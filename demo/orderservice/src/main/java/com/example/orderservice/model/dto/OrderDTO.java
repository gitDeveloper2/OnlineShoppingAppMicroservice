package com.example.orderservice.model.dto;

import lombok.*;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class OrderDTO {
    private Long id;
    private Long product_code;
    private BigDecimal price;
    private Integer quantity;
}
