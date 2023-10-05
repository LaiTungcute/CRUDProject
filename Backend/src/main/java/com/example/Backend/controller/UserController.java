package com.example.Backend.controller;

import com.example.Backend.Exception.UserNotFoundException;
import com.example.Backend.model.User;
import com.example.Backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("http://localhost:3000")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    //Thêm user mới
    @PostMapping("/user")
    User newUser(@RequestBody User nUser) {
        return userRepository.save(nUser);
    }

    //Lấy thông tin tất cả users
    @GetMapping("/users")
    List<User> getAllUsers() {
        return userRepository.findAll();
    }

    //Lấy thông tin user qua id
    @GetMapping("/user/{id}")
    User getUserById(@PathVariable Long id) {
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
    }

    //Sửa thông tin user qua id
    @PutMapping("/user/{id}")
    User editUserbyId(@PathVariable Long id, @RequestBody User nUser) {
        return userRepository.findById(id).map(
                user -> {
                    user.setName(nUser.getName());
                    user.setUsername(nUser.getUsername());
                    user.setEmail(nUser.getEmail());
                    return userRepository.save(user);
                }
        ).orElseThrow(() -> new UserNotFoundException(id));
    }

    //Xóa thông tin user qua id
    @DeleteMapping("/user/{id}")
    String deleteById(@PathVariable Long id) {
        if(!userRepository.existsById(id)) throw new UserNotFoundException(id);
        userRepository.deleteById(id);
        return "User with id= " + id + "has been deleted";
    }
}
