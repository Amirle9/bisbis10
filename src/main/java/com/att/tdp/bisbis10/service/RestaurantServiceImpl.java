package com.att.tdp.bisbis10.service;

import com.att.tdp.bisbis10.model.Restaurant;
import com.att.tdp.bisbis10.repository.RatingRepository;
import com.att.tdp.bisbis10.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    private final RestaurantRepository restaurantRepository;
    private final RatingRepository ratingRepository;

    @Autowired
    public RestaurantServiceImpl(RestaurantRepository restaurantRepository, RatingRepository ratingRepository) {
        this.restaurantRepository = restaurantRepository;
        this.ratingRepository = ratingRepository;
    }

    @Override
    public List<Restaurant> getAllRestaurants() {
        return restaurantRepository.findAll();
    }

    @Override
    public Optional<Restaurant> getRestaurantById(Long id) {
        return restaurantRepository.findById(id);
    }

    @Override
    public Restaurant createRestaurant(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }

    @Override
    public Restaurant updateRestaurant(Long id, Restaurant restaurantDetails) {
        return restaurantRepository.findById(id).map(restaurant -> {
            restaurant.setName(restaurantDetails.getName());
            restaurant.setKosher(restaurantDetails.isKosher());
            restaurant.setCuisines(restaurantDetails.getCuisines());
            return restaurantRepository.save(restaurant);
        }).orElseThrow(() -> new RuntimeException("Restaurant not found!"));
    }

    @Override
    public void deleteRestaurant(Long id) {
        restaurantRepository.deleteById(id);
    }

    @Override
    public double calculateAverageRating(Long restaurantId) {
        return ratingRepository.findByRestaurantId(restaurantId)
                .stream()
                .mapToDouble(rating -> rating.getRating())
                .average()
                .orElse(0.0);
    }

    @Override
    public List<Restaurant> getRestaurantsByCuisine(String cuisine) {
        return restaurantRepository.findAll().stream()
                .filter(restaurant -> restaurant.getCuisines().contains(cuisine))
                .collect(Collectors.toList());
    }
}
