package com.example.demo.profile.interfaces.rest;

import com.example.demo.profile.domain.model.entities.Comment;
import com.example.demo.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/comments")
@CrossOrigin(origins = "http://localhost:4200")
public class CommentController {
    @Autowired
    private CommentService commentService;
    @PostMapping
    public Comment addComment(@RequestBody Comment comment) {
        return commentService.addComment(comment);
    }
    @GetMapping("/{id}")
    public List<Comment> getComment(@PathVariable long id) {
        return commentService.getComments(id);
    }
}
