package com.att.tdp.bisbis10.controller;

import com.att.tdp.bisbis10.dto.DishDTO;
import com.att.tdp.bisbis10.model.Dish;
import com.att.tdp.bisbis10.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/restaurants/{restaurantId}/dishes")
public class DishController {

    private final DishService dishService;

    @Autowired
    public DishController(DishService dishService) {
        this.dishService = dishService;
    }

    @PostMapping
    public ResponseEntity<Void> addDish(@PathVariable Long restaurantId, @RequestBody Dish dish) {
        dishService.addDish(restaurantId, dish);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{dishId}")
    public ResponseEntity<Void> updateDish(@PathVariable Long restaurantId, @PathVariable Long dishId, @RequestBody Dish dishDetails) {
        dishService.updateDish(restaurantId, dishId, dishDetails);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{dishId}")
    public ResponseEntity<Void> deleteDish(@PathVariable Long restaurantId, @PathVariable Long dishId) {
        dishService.deleteDish(restaurantId, dishId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public ResponseEntity<List<DishDTO>> getDishesByRestaurant(@PathVariable Long restaurantId) {
        List<Dish> dishes = dishService.getDishesByRestaurant(restaurantId);
        List<DishDTO> dishDTOs = dishes.stream()
                .map(dish -> new DishDTO(dish.getId(), dish.getName(), dish.getDescription(), dish.getPrice()))
                .collect(Collectors.toList());
        return new ResponseEntity<>(dishDTOs, HttpStatus.OK);
    }
}
