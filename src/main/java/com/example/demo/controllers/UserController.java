package com.example.demo.controllers;

import com.example.demo.entities.User;
import com.example.demo.services.UserService;
import jakarta.persistence.GeneratedValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(path = "/users")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping
    public User createUser(@RequestBody User user) {
        System.out.println(user);
        return userService.create(user);
    }
    @PostMapping("/customer")
    public User createCustomer(@RequestBody User user) {
        return userService.registerCustomer(user);
    }
    @PostMapping("/musical")
    public User createMusical(@RequestBody User user) {
        return userService.registerMusical(user);
    }
    @PostMapping("/enterprice")
    public User createEnterprice(@RequestBody User user) {
        return userService.registerEnterprice(user);
    }
    @PostMapping("/login")
    public User login(@RequestBody User user) {
        return userService.login(user.getEmail(), user.getPassword());
    }
    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }
    @PutMapping("/customer/{id}")
    public User updateCustomer(@PathVariable Long id,@RequestBody User user) {
        return userService.updateCustomer(id, user);
    }
    @PutMapping("/musical/{id}")
    public User updateMusical(@PathVariable Long id,@RequestBody User user) {
        return userService.updateMusical(id, user);
    }
    @PutMapping("/enterprice/{id}")
    public User updateEnterprice(@PathVariable Long id,@RequestBody User user) {
        return userService.updateEnterprice(id, user);
    }
    @GetMapping("/musicals")
    public List<User> getAllMusical(){
        return userService.getAllMusicals();
    }
    @PutMapping("/photo/{id}")
    public User updatePhoto(@PathVariable Long id,
                                                @RequestParam("photo") MultipartFile photo) throws IOException {

        return userService.editPhoto(id,photo);
    }
}
