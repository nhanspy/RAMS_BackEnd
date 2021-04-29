package com.rams.backend.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    @GetMapping("/login1")
    public String Helloword(){
        return "Hello word";
    }

    @GetMapping("loginmail")
    public String loginmail(){
        return "to see this text you need to be login";
    }
}
