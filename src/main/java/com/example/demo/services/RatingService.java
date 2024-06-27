package com.example.demo.services;

import com.example.demo.feedback.domain.model.entities.Rating;

public interface RatingService {
    public Rating save(Rating rating);
    public Double getRating(Long musicalId);
}
