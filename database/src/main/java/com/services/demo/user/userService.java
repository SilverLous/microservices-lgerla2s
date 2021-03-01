package com.services.demo.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Optional;

@Service
public class userService {

    private final userRepository UserRepository;

    @Autowired
    public userService(userRepository UserRepository) {
        this.UserRepository = UserRepository;
    }

    public void deleteUser(Long userId) {

        if(!UserRepository.existsById(userId)){
            throw new IllegalStateException("Keinen Benutzer mit der ID " +userId + " gefunden");
        }
        UserRepository.deleteById(userId);
    }

    public void addNewUser(User user) {
        Optional<User> userName = UserRepository.findUserByUserName(user.getUserName());
        if(userName.isPresent()){
            throw new IllegalStateException("Benutzername bereits vorhanden");
        }
        UserRepository.save(user);
        System.out.print(user);
    }

    @GetMapping
    public String getUsers() {
        return (UserRepository.findAll().toString());
    }
}
