package com.example.demo.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class Controller {
   @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/home")
    public  String home(){
        return "hello";
    }
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/home2")
    public  String home2(){
        return "hello";
    }
  @PreAuthorize("hasRole('NORMAL')")
    @GetMapping("/home1")
    public  String home1(){
        return "hellows";
    }
}
