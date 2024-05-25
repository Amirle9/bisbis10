package com.att.tdp.bisbis10.model;

import java.util.List;

public class Order {
    private int restaurantId;
    private List<OrderItem> orderItems;

    // Constructors, getters, and setters
    public Order() {
    }

    public Order(int restaurantId, List<OrderItem> orderItems) {
        this.restaurantId = restaurantId;
        this.orderItems = orderItems;
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }
}