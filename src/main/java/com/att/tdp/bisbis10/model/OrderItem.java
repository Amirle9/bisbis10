package com.att.tdp.bisbis10.model;

public class OrderItem {
    private int dishId;
    private int amount;

    // Constructors, getters, and setters
    public OrderItem() {
    }

    public OrderItem(int dishId, int amount) {
        this.dishId = dishId;
        this.amount = amount;
    }

    public int getDishId() {
        return dishId;
    }

    public void setDishId(int dishId) {
        this.dishId = dishId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}