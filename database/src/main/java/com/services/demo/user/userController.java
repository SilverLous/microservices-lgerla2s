package com.services.demo.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "user")

public class userController {

    private final userService UserService;
    private final userRepository UserRepository;

    @Autowired
    public userController(userService userService, userRepository userRepository) {
        UserRepository = userRepository;
        UserService = new userService(UserRepository);
    }


    @GetMapping
    public String getUsers(){
        return "Benutzerliste: " + UserService.getUsers()+"\nVon EUREKA-USER-DATABASE";
    }
    @PostMapping
    public void registerNewUser(@RequestBody User user){
        UserService.addNewUser(user);
    }
    @DeleteMapping(path = "/{userId}")
    public void deleteUser(@PathVariable("userId")String userId){
        System.out.print("TEST");
        UserService.deleteUser(Long.parseLong(userId));
    }
}
