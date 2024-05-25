package com.att.tdp.bisbis10.controller;

import com.att.tdp.bisbis10.dto.RestaurantDTO;
import com.att.tdp.bisbis10.model.Restaurant;
import com.att.tdp.bisbis10.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {

    private final RestaurantService restaurantService;

    @Autowired
    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @GetMapping
    public ResponseEntity<List<RestaurantDTO>> getAllRestaurants(@RequestParam(required = false) String cuisine) {
        List<Restaurant> restaurants;
        if (cuisine == null) {
            restaurants = restaurantService.getAllRestaurants();
        } else {
            restaurants = restaurantService.getRestaurantsByCuisine(cuisine);
        }
        List<RestaurantDTO> restaurantDTOs = restaurants.stream()
                .map(restaurant -> new RestaurantDTO(
                        restaurant.getId(),
                        restaurant.getName(),
                        restaurantService.calculateAverageRating(restaurant.getId()),
                        restaurant.isKosher(),
                        restaurant.getCuisines()
                ))
                .collect(Collectors.toList());
        return new ResponseEntity<>(restaurantDTOs, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Restaurant> getRestaurantById(@PathVariable Long id) {
        Optional<Restaurant> restaurant = restaurantService.getRestaurantById(id);
        return restaurant.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Restaurant> createRestaurant(@RequestBody Restaurant restaurant) {
        Restaurant newRestaurant = restaurantService.createRestaurant(restaurant);
        return new ResponseEntity<>(newRestaurant, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Restaurant> updateRestaurant(@PathVariable Long id, @RequestBody Restaurant restaurantDetails) {
        Restaurant updatedRestaurant = restaurantService.updateRestaurant(id, restaurantDetails);
        if (updatedRestaurant != null) {
            return new ResponseEntity<>(updatedRestaurant, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteRestaurant(@PathVariable Long id) {
        try {
            restaurantService.deleteRestaurant(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
