package com.example.telproject;


import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
public class LoginController {


    @RequestMapping(value="/login", method = RequestMethod.GET)
    public String getLogin(@RequestParam Map<String,String> allParams,
                           @AuthenticationPrincipal final UserDetails userDetails,
                           Model model) {
        if (userDetails!=null && allParams.get("logout")==null){
            return "redirect:/home";
        }
        //System.out.println(allParams);
        return "login";
    }



}
