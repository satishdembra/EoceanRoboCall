package com.example.eoceanrobocall.controller;


import com.example.eoceanrobocall.Exception.Exception;
import com.example.eoceanrobocall.RequestResponseModels.Request.AuthenticationRequest;
import com.example.eoceanrobocall.RequestResponseModels.Response.AuthenticationResponse;
import com.example.eoceanrobocall.entity.User;
import com.example.eoceanrobocall.service.UserDetailService;
import com.example.eoceanrobocall.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;

@RestController
public class Authentication
{
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private UserDetailService userDetailService;
    @Autowired
    private JwtUtil jwtUtil;
    @CrossOrigin("http://localhost:4200")
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public ResponseEntity<?> creatAuthToken(@RequestBody AuthenticationRequest authenticationRequest)throws Exception {
        try {
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword());
            UserDetails user = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword()));
        } catch (BadCredentialsException badCredentialsException) {
            throw new Exception("Incorrect Username or password",HttpStatus.UNAUTHORIZED);
        }
        UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
        final User user = userDetailService.getUserByUsername(authenticationRequest.getUsername());
        final String jwt= jwtUtil.generateToken(userDetails);
        return ResponseEntity.ok(new AuthenticationResponse(jwt,user.getUsername(), Instant.now().plusMillis(jwtUtil.getJwtExpirationInMillis()),user.getAccount_code()));

    }

}
