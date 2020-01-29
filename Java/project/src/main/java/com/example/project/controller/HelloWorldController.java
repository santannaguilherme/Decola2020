package com.example.project.controller;

import com.example.project.utils.SiteRoles;

import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @Secured({SiteRoles.APP_USER})
    @GetMapping("/")
    public String helloWorld() {
        return "Hello World!";
    }

    @Secured({SiteRoles.APP_USER})
    @GetMapping("/simplelist")
    public String[] helloWorldList() {
        return new String[] { "Hello", "World" };
    }
    
}