package com.example.telproject.services;

import com.example.telproject.database.User;
import com.example.telproject.database.repositories.UserRepository;
import com.example.telproject.services.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller    // This means that this class is a Controller
//@RequestMapping(path="/demo") // This means URL's start with /demo (after Application path)
public class UserController {
	@Autowired // This means to get the bean called userRepository
	           // Which is auto-generated by Spring, we will use it to handle the data
	private UserRepository userRepository;
    @Autowired
    private RegisterService registerService;

	@PostMapping(path="/signup")
	public String register(@RequestParam Map<String, String> allParams,Model model){

        try {
            registerService.createUser(allParams);
        } catch (Exception e) {
            if(e.getMessage()=="User with same username exists"){
                model.addAttribute("oldFields", allParams);
                model.addAttribute("error", "exists");
                System.out.println("USERRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRR\n\n\ndv");
                return "<h1>User  with same username already exists </h1>";
            }else if(e.getMessage()=="Empty Field"){
                model.addAttribute("oldFields", allParams);
                model.addAttribute("error", "empty");
                System.out.println("Empty Fieldddddddddddddddddddddddddddddddddddddddddddddddddddddddddd\n\n\n\n");


                return "<h1>Error afises empty fields</h1>";

            }else if(e.getMessage()=="Empty Field"){
                model.addAttribute("oldFields", allParams);
                model.addAttribute("error", "empty");
                System.out.println("Empty Fieldddddddddddddddddddddddddddddddddddddddddddddddddddddddddd\n\n\n\n");


                return "<h1>Error afises empty fields</h1>";
            }else if(e.getMessage()=="Password not strong enough"){
                model.addAttribute("oldFields", allParams);
                model.addAttribute("error", "pwd_not_good");

                System.out.println("Password not strong enoughhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh\n\n\n\n");

                return "<h1>The password not stong</h1>";

            }
            else if(e.getMessage()== "Different passwords given" ){
                model.addAttribute("oldFields", allParams);
                model.addAttribute("error", "passwords different");

                System.out.println("Different passwords givennnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn\n\n\n\n");

                return "<h1>Different passwords given</h1>";

            }
            else{
                System.out.println("ERROR HAPPENED CAN'T HANDLEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEee\n\n\n\n");
                return "Errorrrrr";
            }
        }



		return "redirect:/";
	}



	@GetMapping(path="/all")
	public @ResponseBody Iterable<User> getAllUsers() {
		// This returns a JSON or XML with the users
		return userRepository.findAll();
	}
}
