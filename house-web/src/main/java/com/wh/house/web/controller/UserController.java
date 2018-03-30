package com.wh.house.web.controller;

import com.wh.house.common.entity.User;
import com.wh.house.common.service.UserService;
import com.wh.house.common.util.RegisterCache;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    private RegisterCache registerCache;

    @RequestMapping(value = "/user/{userId}",method = RequestMethod.GET)
    public String getUser(@PathVariable("userId") Integer userId, ModelMap modelMap) {

        User byId = userService.getById(userId);
        modelMap.addAttribute("user",byId);
        return "user";
    }

    /**
     * 跳转到注册页
     * @return
     */
    @RequestMapping(value = "/register",method = RequestMethod.GET)
    public String register() {

        return "register";
    }

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public String register(User user) {
        userService.save(user);
        return "registerSuccess";
    }

    @RequestMapping("/verfiyRegister")
    public String verifyEmail(String key) {
        return "";
    }

}
