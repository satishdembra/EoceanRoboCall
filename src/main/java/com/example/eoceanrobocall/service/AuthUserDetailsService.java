package com.example.eoceanrobocall.service;

import com.example.eoceanrobocall.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class AuthUserDetailsService implements UserDetailsService {
    @Autowired
    UserDetailService userDetailsService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            User user = userDetailsService.getUserByUsername(username);
            if(user != null) {
                org.springframework.security.core.userdetails.User user2 = new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), new ArrayList<>());
                return user2;
            }else {
                throw new UsernameNotFoundException("Username not found");
            }
        }catch(UsernameNotFoundException e) {
            throw new UsernameNotFoundException("Incorrect Username or password");
        }catch (Exception e){
            throw new UsernameNotFoundException("User not found!");
        }
    }


}
