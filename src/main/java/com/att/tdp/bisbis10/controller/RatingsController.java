package com.att.tdp.bisbis10.controller;

import com.att.tdp.bisbis10.dto.RatingRequest;
import com.att.tdp.bisbis10.service.RatingService;
import org.springframework.http.ResponseEntity;
import com.att.tdp.bisbis10.model.Rating;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ratings")
public class RatingsController {

    private final RatingService ratingService;

    public RatingsController(RatingService ratingService) {
        this.ratingService = ratingService;
    }

    @PostMapping("/")
    public ResponseEntity<Void> addRating(@RequestBody RatingRequest ratingRequest) {
        ratingService.addRating(ratingRequest.getRestaurantId(), ratingRequest.getRating());
        return ResponseEntity.ok().build(); // Return only status without body
    }

    @GetMapping("/")
    public ResponseEntity<?> getAllRatings() {
        return ResponseEntity.ok(ratingService.getAllRatings());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getRatingById(@PathVariable Long id) {
        Rating rating = ratingService.getRatingById(id);
        if (rating != null) {
            return ResponseEntity.ok(rating);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
