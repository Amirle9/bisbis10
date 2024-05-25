package com.att.tdp.bisbis10.service;

import com.att.tdp.bisbis10.model.Rating;
import com.att.tdp.bisbis10.model.Restaurant;
import com.att.tdp.bisbis10.repository.RatingRepository;
import com.att.tdp.bisbis10.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingServiceImpl implements RatingService {

    private final RatingRepository ratingRepository;
    private final RestaurantRepository restaurantRepository;

    @Autowired
    public RatingServiceImpl(RatingRepository ratingRepository, RestaurantRepository restaurantRepository) {
        this.ratingRepository = ratingRepository;
        this.restaurantRepository = restaurantRepository;
    }

    @Override
    public void addRating(Long restaurantId, double rating) {
        Restaurant restaurant = restaurantRepository.findById(restaurantId)
                .orElseThrow(() -> new RuntimeException("Restaurant not found!"));

        Rating newRating = new Rating(restaurant, rating);
        ratingRepository.save(newRating);
    }

    @Override
    public List<Rating> getAllRatings() {
        return ratingRepository.findAll();
    }

    @Override
    public Rating getRatingById(Long id) {
        return ratingRepository.findById(id).orElse(null);
    }
}
