package com.example.demo.services;

import com.example.demo.entities.User;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface UserService {
    User create(User user);
    User findByEmail(String email);
    User registerCustomer(User user);
    User registerMusical(User user);
    User registerEnterprice(User user);
    User login(String email, String password);
    User getUserById(Long id);
    User updateCustomer(Long id, User user);
    User updateMusical(Long id, User user);
    User updateEnterprice(Long id, User user);
    List<User> getAllMusicals();
    public User editPhoto(Long id, MultipartFile photo) throws IOException;

}
