package com.haixiang.pipeline.controller;

import com.haixiang.pipeline.model.User;
import com.haixiang.pipeline.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping(value = "/hello")
public class HellowWorld {
    @Resource
    UserService userService;

    @GetMapping(value = "/world")
    public String hellowWorld() {
        return "Hellow World";
    }

    @GetMapping(value = "/find")
    public List<User> find() {
        return userService.find();
    }
}
