package com.example.orderservice.model;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "order_table")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Builder
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   Long id;
    Long product_code;
    BigDecimal price;
    Integer quantity;

}
