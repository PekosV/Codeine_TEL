package com.example.telproject;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class home {
    @RequestMapping(value = "/", method = RequestMethod.GET, produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    public Map<String, String> home_controller(String name, Model model) {
        model.addAttribute("name", name);
        HashMap<String, String> map = new HashMap<>();
        map.put("sprint1", "y0olloo");
        map.put("billy", "pagwto");
        map.put("bill", "kwlogayros");
        return map;
    }
}
