package com.example.demo.services;

import com.example.demo.entities.Rating;

public interface RatingService {
    public Rating save(Rating rating);
    public Double getRating(Long musicalId);
}
