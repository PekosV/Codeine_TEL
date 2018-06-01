package com.example.telproject.views;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class CreateProject {
    @RequestMapping(value = "/createproject", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public String createproject_controller() {

        return "CreateProject";
    }
}
