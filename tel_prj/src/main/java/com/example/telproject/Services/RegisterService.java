package com.example.telproject.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.telproject.database.User;
import com.example.telproject.database.repositories.UserRepository;
import com.example.telproject.SignUp;

import java.util.Map;

@Service
public class RegisterService {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    UserRepository userRepository;
    @Autowired

    public Boolean isPasswordOK(String password){
        if(password.length() >= 4 && password.length() <= 10){
            return true;
        }
        return false;
    }

    public String hashPassword(String password){
        return  passwordEncoder.encode(password);
    }

}
