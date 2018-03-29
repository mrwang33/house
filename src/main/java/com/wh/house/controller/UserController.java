package com.wh.house.controller;

import com.wh.house.entity.User;
import com.wh.house.service.UserService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class UserController {
    @Resource
    private UserService userService;


    @RequestMapping(value = "/user/{userId}",method = RequestMethod.GET)
    public User getUser(@PathVariable("userId") Integer userId) {
        return userService.getById(userId);
    }
}
