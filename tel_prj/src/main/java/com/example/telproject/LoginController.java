package com.example.telproject;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
public class LoginController {


    @RequestMapping(value="/login", method = RequestMethod.GET)
    public String getLogin() {
        //System.out.println(allParams);
        return "login";
    }



}
