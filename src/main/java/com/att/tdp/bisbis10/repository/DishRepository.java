package com.att.tdp.bisbis10.repository;

import com.att.tdp.bisbis10.model.Dish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DishRepository extends JpaRepository<Dish, Long> {
    List<Dish> findByRestaurantId(Long restaurantId);
    Optional<Dish> findByIdAndRestaurantId(Long id, Long restaurantId);
    void deleteByIdAndRestaurantId(Long id, Long restaurantId);
}
