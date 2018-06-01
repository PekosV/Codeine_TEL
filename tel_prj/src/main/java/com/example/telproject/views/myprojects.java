package com.example.telproject.views;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class myprojects {
    @RequestMapping(value = "/myprojects", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public String myprojects_controller() {

        return "MyProjects";
    }
}
