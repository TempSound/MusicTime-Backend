package com.example.demo.services;

import com.example.demo.profile.domain.model.entities.Comment;

import java.util.List;

public interface CommentService {
    Comment addComment(Comment comment);
    List<Comment> getComments(Long id);
}
