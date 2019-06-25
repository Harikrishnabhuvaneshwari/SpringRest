package com.websystique.springmvc.controller;
 
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
 
@RestController
@RequestMapping("/welcome")
public class WelcomeController {
 
    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public String listAllUsers() {
        return "Welcome Controller";
    }
}