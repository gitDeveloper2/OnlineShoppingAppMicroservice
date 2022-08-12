package com.example.orderservice.controller;

import com.example.orderservice.model.dto.OrderDTO;
import com.example.orderservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
//@RequestMapping("/api/order")
public class OrderController {
    private final OrderService orderService;
//@PostMapping(consumes = MediaType.ALL_VALUE)
@RequestMapping(value = "/api/order",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
@ResponseStatus(HttpStatus.CREATED)
    public List<OrderDTO> placeOrder(@RequestBody List<OrderDTO> list){
        orderService.placeOrder(list);
    return list;
    }
}
