package com.att.tdp.bisbis10.dto;

import java.util.List;

public class RestaurantDTO {
    private Long id;
    private String name;
    private double averageRating;
    private boolean isKosher;
    private List<String> cuisines;

    // Constructors, getters, and setters
    public RestaurantDTO() {
    }

    public RestaurantDTO(Long id, String name, double averageRating, boolean isKosher, List<String> cuisines) {
        this.id = id;
        this.name = name;
        this.averageRating = averageRating;
        this.isKosher = isKosher;
        this.cuisines = cuisines;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(double averageRating) {
        this.averageRating = averageRating;
    }

    public boolean isKosher() {
        return isKosher;
    }

    public void setKosher(boolean isKosher) {
        this.isKosher = isKosher;
    }

    public List<String> getCuisines() {
        return cuisines;
    }

    public void setCuisines(List<String> cuisines) {
        this.cuisines = cuisines;
    }
}
