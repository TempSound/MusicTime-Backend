package com.example.demo.repositories;

import com.example.demo.profile.domain.model.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    @Query("select c from Comment c where c.musical.id=:id")
    List<Comment> getAllComentsByMusical(@Param("id") Long id);
}