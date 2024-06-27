package com.example.demo.feedback.domain.model.entities;

import com.example.demo.IAM.domain.model.entities.User;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "ratings")
public class Rating {
    @Id
    private Long id;
    private Integer points;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private User customer;
    @ManyToOne
    @JoinColumn(name = "musical_id")
    private User musical;
}
