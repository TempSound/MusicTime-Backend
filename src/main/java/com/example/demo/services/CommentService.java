package com.example.demo.services;

import com.example.demo.entities.Comment;

import java.util.List;

public interface CommentService {
    Comment addComment(Comment comment);
    List<Comment> getComments(Long id);
}
