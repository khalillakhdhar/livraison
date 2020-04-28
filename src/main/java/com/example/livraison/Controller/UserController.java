/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.livraison.Controller;

import com.example.livraison.Repository.UserRepository;
import com.example.livraison.exception.ResourceNotFoundException;
import com.example.livraison.model.User;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author pro
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserRepository userRepository;
    
    
    @GetMapping()
    public List<User> list() {
        return (List<User>) userRepository.findAll();
    }
    
    @GetMapping("/{id}")
    public User get(@PathVariable Long id) {
        return (User) userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
    }
    
    @PostMapping
    public User post(@RequestBody User user) {
        return userRepository.save(user);
    }
    
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        userRepository.delete(get(id));
    }
    
    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Error message")
    public String handleError() {
        return "erreur de connexion";
    }
    
}
