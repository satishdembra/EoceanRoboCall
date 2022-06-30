package com.example.eoceanrobocall.service;


import com.example.eoceanrobocall.entity.User;
import com.example.eoceanrobocall.repository.UserDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserDetailService {
    @Autowired
    private UserDetailsRepository userDetailsRepository;

    @Autowired
    public List<User> getUserDetails(){
        return userDetailsRepository.findAll();
    }

    public Optional<User> getUserDetail(int id){
        return userDetailsRepository.findById(id);
    }

    public User saveUserDetails(User userDetails){


        userDetailsRepository.save(userDetails);
        return userDetails;
    }
    public User getUserByUsername(String username)throws UsernameNotFoundException {


        Optional<User> user = userDetailsRepository.findByUsername(username);
        return user.isEmpty()?null:user.get();

    }
    public boolean isUserRegistered(String username)throws UsernameNotFoundException {
        Optional<User> user = userDetailsRepository.findByUsername(username);
        return user.isEmpty()?true:false;

    }



}
