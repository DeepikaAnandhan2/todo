package com.sample.todo.service;


import com.sample.todo.model.User;
import com.sample.todo.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;
@Data
@Service
@AllArgsConstructor
@NoArgsConstructor
public class UserService {
    //Autowiring
    @Autowired
    private UserRepository userRepository;

    public User createUser(User user){

        return userRepository.save(user);
    }


    public User getUserById(Long id){
        return userRepository.findById(id)
                .orElseThrow(()->new RuntimeException("User not found"));


    }




}
