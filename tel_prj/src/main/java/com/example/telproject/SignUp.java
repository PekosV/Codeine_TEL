package com.example.telproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
public class SignUp {

    @RequestMapping(value= "/signup" ,method = RequestMethod.GET)
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "signup.html";
    }


    @RequestMapping(value = "/signup", method = RequestMethod.POST, produces="application/json" )
      public Map<String, String> signup_post(@RequestParam("firstname") String firstname,@RequestParam("lastname") String lastname,@RequestParam("username") String username,@RequestParam("email") String email, @RequestParam("password") String password,@RequestParam("reenterpassword") String reenterpassword) {

        HashMap<String, String> map = new HashMap<>();
        map.put("firstname", firstname);
        map.put("lastname", lastname);
        map.put("username", username);
        map.put("email",email);
        map.put("reenterpassword",reenterpassword);


        map.put("pass", password);
        System.out.println("PAASSSWORDDDDDDDDDD : ");
        System.out.println(map);
        return map;
    }


}
