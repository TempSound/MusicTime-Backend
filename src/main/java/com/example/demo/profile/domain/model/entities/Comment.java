package com.example.demo.profile.domain.model.entities;

import com.example.demo.IAM.domain.model.entities.User;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
@Data
@Entity
@Table(name = "comments")
public class Comment {
    @Id
    @GeneratedValue
    private long id;
    private String description;
    @ManyToOne
    @JoinColumn(name = "musical_id")
    private User musical;
    private LocalDate createdAt;
    @ManyToOne
    @JoinColumn(name = "author_id")
    private User author;
}
