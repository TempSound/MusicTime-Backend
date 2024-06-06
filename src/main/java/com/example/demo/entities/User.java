package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.Data;
@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String password;
    private String userType;

    //Customer
    private String firstName;
    private String lastName;
    private String phone;
    private String description;
    @Lob
    @Column(name = "photo")
    private byte[] photo;

    //musical
    private String musicalName;
    private String managerFirstName;
    private String managerLastName;
    private String soloist;
    private String contact;
    private String members;
    private String genre;
    private String typeContract;

    //enterprice
    private String businessName;
    private String businessType;
    private String businessLocation;
}
