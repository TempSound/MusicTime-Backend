package com.example.demo.contract.domain.model.entities;

import com.example.demo.IAM.domain.model.entities.User;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "events")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate initialDate;
    private String address;
    private String reason;
    private String typeContact;
    private Integer hours;
    private String status;
    private Double amount;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private User customer;
    @ManyToOne
    @JoinColumn(name = "musical_id")
    private User musical;
}
