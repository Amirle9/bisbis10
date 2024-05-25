package com.att.tdp.bisbis10.service;

import com.att.tdp.bisbis10.model.Rating;

import java.util.List;

public interface RatingService {
    void addRating(Long restaurantId, double rating);
    List<Rating> getAllRatings();
    Rating getRatingById(Long id);
}
