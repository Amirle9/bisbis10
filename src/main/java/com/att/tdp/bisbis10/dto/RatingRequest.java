package com.att.tdp.bisbis10.dto;

public class RatingRequest {
    private Long restaurantId;
    private double rating;

    // Constructors, getters, and setters
    public RatingRequest() {
    }

    public RatingRequest(Long restaurantId, double rating) {
        this.restaurantId = restaurantId;
        this.rating = rating;
    }

    public Long getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Long restaurantId) {
        this.restaurantId = restaurantId;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
}
