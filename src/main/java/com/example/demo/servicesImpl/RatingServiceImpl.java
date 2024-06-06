package com.example.demo.servicesImpl;

import com.example.demo.entities.Rating;
import com.example.demo.repositories.RatingRepository;
import com.example.demo.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RatingServiceImpl implements RatingService {
    @Autowired
    private RatingRepository ratingRepository;
    @Override
    public Rating save(Rating rating) {
      return ratingRepository.save(rating);
    }

    @Override
    public Double getRating(Long musicalId) {
        return ratingRepository.getRatingByMusical(musicalId);
    }
}
