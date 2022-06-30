package com.example.eoceanrobocall.controller;

import com.example.eoceanrobocall.Exception.Exception;
import com.example.eoceanrobocall.entity.User;
import com.example.eoceanrobocall.service.UserDetailService;
import com.example.eoceanrobocall.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
public class UserDetailsController {
    @Autowired
    private UserDetailService service;
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;


    @GetMapping(value = "/")
    public String hello() throws AuthenticationException, IOException {
        try{
            return "Hello!";
        }catch(Exception e){
            throw new Exception("An Error Occurred",HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping(value = "/signup", produces = MediaType.APPLICATION_JSON_VALUE)
    public User addUser(@RequestBody User userDetails)throws Exception {
        try {

            if(!service.isUserRegistered(userDetails.getUsername())) {
                throw new Exception("Username already exists",HttpStatus.BAD_REQUEST);
            }
            userDetails.setPassword(passwordEncoder.encode(userDetails.getPassword()));
            return service.saveUserDetails(userDetails);
        }catch (Exception e){
            throw new Exception("Username already exists ",HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping(value = "/getUserDetails", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> getAllUsers(){
        System.out.println(jwtUtil.getCurrentUser());
        return service.getUserDetails();
    }

    @GetMapping(value = "/getUserDetails/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<User> getUserById(@PathVariable int id){
        return service.getUserDetail(id);
    }

    @GetMapping(value = "/getUserDetail/{username}", produces = MediaType.APPLICATION_JSON_VALUE)
    public User getUserByUsername(@PathVariable("username") String username){
        return null;
    }

}
