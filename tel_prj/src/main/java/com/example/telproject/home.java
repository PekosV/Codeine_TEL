package com.example.telproject;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class home {

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public String home_controller() {

        return "base.html";
    }
}
