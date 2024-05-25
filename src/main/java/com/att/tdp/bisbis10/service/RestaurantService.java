package com.att.tdp.bisbis10.service;

import com.att.tdp.bisbis10.model.Restaurant;

import java.util.List;
import java.util.Optional;

public interface RestaurantService {
    List<Restaurant> getAllRestaurants();
    Optional<Restaurant> getRestaurantById(Long id);
    Restaurant createRestaurant(Restaurant restaurant);
    Restaurant updateRestaurant(Long id, Restaurant restaurantDetails);
    void deleteRestaurant(Long id);
    double calculateAverageRating(Long restaurantId);
    List<Restaurant> getRestaurantsByCuisine(String cuisine);
}
