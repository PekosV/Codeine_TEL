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
    public String mypage(@RequestParam Map<String , String> allParams,
                                                    @AuthenticationPrincipal final UserDetails userDetails,
                                                    Model model)
    {

        System.out.println(allParams);
        System.out.println(allParams.get("error"));

        if(userDetails!=null && allParams.get("logout")==null ){
            System.out.println(userDetails);
            return "redirect:/";
        }

        return "login";
    }


    @RequestMapping(value = "/", method = RequestMethod.GET )
    public String login(Model model ,
                        @AuthenticationPrincipal final UserDetails userDetails){

        if(userDetails.getAuthorities().toString().contains("USER")){

            return "redirect:/";


    }


}
