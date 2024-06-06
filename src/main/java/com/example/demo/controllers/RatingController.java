package com.example.demo.controllers;

import com.example.demo.entities.Rating;
import com.example.demo.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/ratings")
@CrossOrigin(origins = "http://localhost:4200")
public class RatingController {
    @Autowired
    private RatingService ratingService;
    @PostMapping
    public Rating createRating(@RequestBody Rating rating) {
        System.out.println(rating);
        return ratingService.save(rating);
    }
    @GetMapping("/{id}")
    public Double getAverageRating(@PathVariable Long id) {
        return ratingService.getRating(id);
    }
}
