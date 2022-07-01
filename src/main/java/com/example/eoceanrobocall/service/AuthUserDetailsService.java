package com.example.eoceanrobocall.service;

import com.example.eoceanrobocall.RequestResponseModels.Request.AuthenticationRequest;
import com.example.eoceanrobocall.RequestResponseModels.Response.AuthenticationResponse;
import com.example.eoceanrobocall.entity.User;
import com.example.eoceanrobocall.repository.UserDetailsRepository;
import com.example.eoceanrobocall.utils.JwtProvider;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.Instant;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AuthUserDetailsService  {
    private final PasswordEncoder passwordEncoder;
    private final UserDetailsRepository userDetailsService;
    private final JwtProvider jwtProvider;
    private final AuthenticationManager authenticationManager;
    private final UserDetailsRepository userDetailsRepository;
    @Transactional
    public User getCurrentUser() {
        Jwt principal = (Jwt) SecurityContextHolder.
                getContext().getAuthentication().getPrincipal();

        return userDetailsRepository.findByUsername(principal.getSubject())
                .orElseThrow(() -> new UsernameNotFoundException("User name not found - " + principal.getSubject()));
    }
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        try {
//            User user = userDetailsService.getUserByUsername(username);
//            if(user != null) {
//                org.springframework.security.core.userdetails.User user2 = new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), new ArrayList<>());
//                return user2;
//            }else {
//                throw new UsernameNotFoundException("Username not found");
//            }
//        }catch(UsernameNotFoundException e) {
//            throw new UsernameNotFoundException("Incorrect Username or password");
//        }catch (Exception e){
//            throw new UsernameNotFoundException("User not found!");
//        }
//    }
    public AuthenticationResponse login(AuthenticationRequest loginDto) {
        Optional<User> userDetails = userDetailsService.findByUsername(loginDto.getUsername());

        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDto.getUsername(), loginDto.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authenticate);
        String token = jwtProvider.generateToken(authenticate);
        return AuthenticationResponse.builder()
                .jwt( token)
                .username( loginDto.getUsername())
                .expiry(Instant.now().plusMillis(jwtProvider.getJwtExpirationInMillis()))
                .account_code(userDetails.get().getAccount_code())
                .build();

    }


}
