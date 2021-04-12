package com.rams.backend.controllers;

import com.rams.backend.entities.Ben;
import com.rams.backend.entities.role_user.User;
import com.rams.backend.services.BenService;
import com.rams.backend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/user")
    public List<User> tatCaBen(){
        return userService.getAll();
    }

    @GetMapping("/user/{id}")
    public User layBenTheoId(@PathVariable(name = "id") long id){
        return userService.get(id);
    }

    @DeleteMapping("/user/{id}")
    public void xoaBenTheoId(@PathVariable(name = "id")long id){
        userService.delete(id);
    }
}
