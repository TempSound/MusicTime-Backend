package com.example.demo.servicesImpl;

import com.example.demo.entities.User;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.repositories.UserRepository;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User create(User user) {
        User userFound=userRepository.findByEmail(user.getEmail());
        if(userFound!=null){
            throw new ResourceNotFoundException("User is already exist");
        }
        return userRepository.save(user);
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public User registerCustomer(User user) {
        User userFound=userRepository.findById(user.getId()).get();
        if(userFound==null){
            throw new ResourceNotFoundException("User not found");
        }
        userFound.setUserType("1");
        userFound.setFirstName(user.getFirstName());
        userFound.setLastName(user.getLastName());
        userFound.setPhone(user.getPhone());
        return userRepository.save(userFound);
    }

    @Override
    public User registerMusical(User user) {
        User userFound=userRepository.findById(user.getId()).get();
        if(userFound==null){
            throw new ResourceNotFoundException("User not found");
        }
        userFound.setUserType("2");
        userFound.setMusicalName(user.getMusicalName());
        userFound.setDescription(user.getDescription());
        userFound.setSoloist(user.getSoloist());
        return userRepository.save(userFound);
    }

    @Override
    public User registerEnterprice(User user) {
        User userFound=userRepository.findById(user.getId()).get();
        if(userFound==null){
            throw new ResourceNotFoundException("User not found");
        }
        userFound.setUserType("3");
        userFound.setBusinessName(user.getBusinessName());
        userFound.setBusinessType(user.getBusinessType());
        userFound.setBusinessLocation(user.getBusinessLocation());
        return userRepository.save(userFound);
    }

    @Override
    public User login(String email, String password) {
        User userFound=userRepository.findByEmail(email);
        if(userFound==null) throw new ResourceNotFoundException("Usuario not found");
        if(!userFound.getPassword().equals(password)){
            throw new ResourceNotFoundException("Password invalid");
        }
        return userFound;
    }

    @Override
    public User getUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found"));
        // if (user.getPhoto() != null) {
        //    byte[] decompressedPhoto = Util.decompressZLib(user.getPhoto());
        //  String base64Photo = Base64.getEncoder().encodeToString(decompressedPhoto);
        // user.setPhoto(base64Photo.getBytes());
        //}
        return user;
    }


    @Override
    public User updateCustomer(Long id, User user) {
        User musicalFound=userRepository.findById(id).get();
        musicalFound.setFirstName(user.getFirstName());
        musicalFound.setLastName(user.getLastName());
        musicalFound.setPhone(user.getPhone());
        musicalFound.setEmail(user.getEmail());
        musicalFound.setPassword(user.getPassword());
        musicalFound.setDescription(user.getDescription());
        return userRepository.save(musicalFound);
    }
    @Override
    public User editPhoto(Long id, MultipartFile photo) throws IOException {
        User user=userRepository.findById(id).get();
        user.setPhoto(photo.getBytes());
        return userRepository.save(user);
    }
    @Override
    public User updateMusical(Long id, User user) {
        User musicalFound=userRepository.findById(id).get();
        musicalFound.setMusicalName(user.getMusicalName());
        musicalFound.setManagerFirstName(user.getManagerFirstName());
        musicalFound.setManagerLastName(user.getManagerLastName());
        musicalFound.setPhone(user.getPhone());
        musicalFound.setEmail(user.getEmail());
        musicalFound.setPassword(user.getPassword());
        musicalFound.setMembers(user.getMembers());
        musicalFound.setDescription(user.getDescription());
        musicalFound.setTypeContract(user.getTypeContract());
        musicalFound.setGenre(user.getGenre());
        return userRepository.save(musicalFound);
    }

    @Override
    public User updateEnterprice(Long id, User user) {
        User musicalFound=userRepository.findById(id).get();
        musicalFound.setFirstName(user.getFirstName());
        musicalFound.setLastName(user.getLastName());
        musicalFound.setPhone(user.getPhone());
        musicalFound.setBusinessName(user.getBusinessName());
        musicalFound.setBusinessType(user.getBusinessType());
        musicalFound.setBusinessLocation(user.getBusinessLocation());
        musicalFound.setEmail(user.getEmail());
        musicalFound.setPassword(user.getPassword());
        musicalFound.setDescription(user.getDescription());
        return userRepository.save(musicalFound);
    }

    @Override
    public List<User> getAllMusicals() {
        return userRepository.getAllMusicals();
    }
}
