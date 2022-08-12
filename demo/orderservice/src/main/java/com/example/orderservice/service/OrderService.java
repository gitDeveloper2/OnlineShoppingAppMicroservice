package com.example.orderservice.service;

import com.example.orderservice.model.Order;
import com.example.orderservice.model.OrderList;
import com.example.orderservice.model.dto.OrderDTO;
import com.example.orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class OrderService {
private final OrderRepository orderRepository;
    public void placeOrder(List<OrderDTO> list) {
        OrderList orderList=new OrderList();
        orderList.setOrderNumber(UUID.randomUUID().toString());
        orderList.setOrders(list.stream().map(orderDTO -> {return
                Order.builder().
                        product_code(orderDTO.getProduct_code()).
                        price(orderDTO.getPrice()).
                        quantity(orderDTO.getQuantity()).
                        build();
        }).toList() );
        //inquire from inventory
           //generate UUID order number
        orderRepository.save(orderList);
        //send notification to notification service

    }
}
