package com.edu.food.foodbackend.controller;

import com.edu.food.foodbackend.entity.User;
import com.edu.food.foodbackend.repository.UserRepository;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/api/v1")
public class UserController {
    @Autowired
    public UserRepository userRepository;

    @RequestMapping(value = "/user/{account}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public User getUserByAct(
            @ApiParam(value = "account", required = true) @PathVariable String account) {
        return userRepository.findByAccount(account);
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public User addUser(
            @ApiParam(value = "user", required = true) @RequestBody User user) {
        return userRepository.save(user);
    }
}
