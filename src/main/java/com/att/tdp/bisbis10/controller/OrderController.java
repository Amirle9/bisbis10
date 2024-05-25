package com.att.tdp.bisbis10.controller;

import com.att.tdp.bisbis10.dto.OrderDTO;
import com.att.tdp.bisbis10.model.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/order")
public class OrderController {

    @PostMapping("/")
    public ResponseEntity<OrderDTO> placeOrder(@RequestBody Order order) {
        // Sample logic to process the order
        String orderSummary = order.getOrderItems().stream()
                .map(item -> String.format("Dish %d, Quantity %d", item.getDishId(), item.getAmount()))
                .collect(Collectors.joining("; "));

        // Creating a unique order ID
        UUID orderId = UUID.randomUUID();

        // Mock response simulating order processing
        OrderDTO response = new OrderDTO(orderId.toString());

        return ResponseEntity.ok(response);
    }
}
