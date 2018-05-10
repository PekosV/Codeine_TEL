package com.example.telproject;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
public class login {

    @RequestMapping("/sapisa")
    @ResponseStatus(HttpStatus.OK)
    public String greeting2(String name, Model model) {
        model.addAttribute("name", name);
        return "login";
    }

}
