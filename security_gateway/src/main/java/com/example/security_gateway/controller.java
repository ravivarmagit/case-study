package com.example.security_gateway;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/gateway")
public class controller {

    @GetMapping("/ping")
    public String ping(){
        return "ping from Gateway";
    }
}
