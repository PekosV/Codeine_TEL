package com.example.telproject;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;




@RestController
public class .hello{

    @RequestMapping("/hello")
    public String sayHello(@RequestParam(value = "name",required=false, defaultValue = "Marino") String name) {
        return "Hello " + name + "!";
    }

    /*@RequestMapping("/login")
    public String login(Model model ) {

        return "login";
    }*/



}
