package com.att.tdp.bisbis10.service;

import com.att.tdp.bisbis10.model.Dish;
import com.att.tdp.bisbis10.model.Restaurant;
import com.att.tdp.bisbis10.repository.DishRepository;
import com.att.tdp.bisbis10.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DishServiceImpl implements DishService {

    private final DishRepository dishRepository;
    private final RestaurantRepository restaurantRepository;

    @Autowired
    public DishServiceImpl(DishRepository dishRepository, RestaurantRepository restaurantRepository) {
        this.dishRepository = dishRepository;
        this.restaurantRepository = restaurantRepository;
    }

    @Override
    public Dish addDish(Long restaurantId, Dish dish) {
        Optional<Restaurant> restaurantOptional = restaurantRepository.findById(restaurantId);
        if (restaurantOptional.isPresent()) {
            dish.setRestaurant(restaurantOptional.get());
            return dishRepository.save(dish);
        }
        throw new RuntimeException("Restaurant not found!");
    }

    @Override
    public Dish updateDish(Long restaurantId, Long dishId, Dish dishDetails) {
        return dishRepository.findByIdAndRestaurantId(dishId, restaurantId).map(dish -> {
            dish.setName(dishDetails.getName());
            dish.setDescription(dishDetails.getDescription()); // Updated description
            dish.setPrice(dishDetails.getPrice());
            return dishRepository.save(dish);
        }).orElseThrow(() -> new RuntimeException("Dish not found!"));
    }

    @Override
    public void deleteDish(Long restaurantId, Long dishId) {
        dishRepository.deleteByIdAndRestaurantId(dishId, restaurantId);
    }

    @Override
    public List<Dish> getDishesByRestaurant(Long restaurantId) {
        return dishRepository.findByRestaurantId(restaurantId);
    }
}
