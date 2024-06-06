package com.example.demo.repositories;

import com.example.demo.entities.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RatingRepository extends JpaRepository<Rating, Long> {
    @Query("select avg(r.points) from Rating r  where r.musical.id=:id")
    Double getRatingByMusical(@Param("id") Long id);
}