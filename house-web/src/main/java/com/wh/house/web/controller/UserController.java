package com.wh.house.web.controller;

import com.wh.house.common.entity.User;
import com.wh.house.common.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;

@Controller
public class UserController {
    @Resource
    private UserService userService;


    @RequestMapping(value = "/user/{userId}",method = RequestMethod.GET)
    public String getUser(@PathVariable("userId") Integer userId, ModelMap modelMap) {

        User byId = userService.getById(userId);
        modelMap.addAttribute("user",byId);
        return "user";
    }
}
