package com.example.eoceanrobocall.controller;


import com.example.eoceanrobocall.Exception.Exception;
import com.example.eoceanrobocall.RequestResponseModels.Request.AuthenticationRequest;
import com.example.eoceanrobocall.RequestResponseModels.Response.AuthenticationResponse;
import com.example.eoceanrobocall.service.AuthUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class Authentication
{



    @Autowired
    private AuthUserDetailsService authUserDetailsService;
//    @CrossOrigin("http://localhost:4200")
//    @RequestMapping(value = "/login",method = RequestMethod.POST)
//    public ResponseEntity<?> creatAuthToken(@RequestBody AuthenticationRequest authenticationRequest)throws Exception {
//        try {
//            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword());
//            UserDetails user = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
//            authenticationManager.authenticate(
//                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword()));
//        } catch (BadCredentialsException badCredentialsException) {
//            throw new Exception("Incorrect Username or password",HttpStatus.UNAUTHORIZED);
//        }
//        UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
//        final User user = userDetailService.getUserByUsername(authenticationRequest.getUsername());
//        final String jwt= jwtUtil.generateToken(userDetails);
//        return ResponseEntity.ok(new AuthenticationResponse(jwt,user.getUsername(), Instant.now().plusMillis(jwtUtil.getJwtExpirationInMillis()),user.getAccount_code()));
//
//    }
        @PostMapping("/login")
        public AuthenticationResponse login(@RequestBody AuthenticationRequest authenticationRequest)
        {
            try{
                return authUserDetailsService.login(authenticationRequest);
            }catch (UsernameNotFoundException | Exception e){
                throw new Exception("User not Found",HttpStatus.NOT_FOUND);
            }

        }
}
