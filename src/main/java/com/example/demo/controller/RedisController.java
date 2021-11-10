package com.example.demo.controller;

import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ResponseBody
public class RedisController {
//    @Autowired
//    private RedisTemplate<String,Object> redisTemplate;

    @Autowired
    private UserService userService;

    @RequestMapping("/lja")
    public String lja(){
        userService.service();
        return "lja";
    }
}
