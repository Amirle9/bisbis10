package com.att.tdp.bisbis10.service;

import com.att.tdp.bisbis10.model.Dish;

import java.util.List;

public interface DishService {
    Dish addDish(Long restaurantId, Dish dish);
    Dish updateDish(Long restaurantId, Long dishId, Dish dishDetails);
    void deleteDish(Long restaurantId, Long dishId);
    List<Dish> getDishesByRestaurant(Long restaurantId);
}
