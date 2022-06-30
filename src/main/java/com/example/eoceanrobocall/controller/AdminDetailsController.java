package com.example.eoceanrobocall.controller;


import com.example.eoceanrobocall.entity.AdminDetails;
import com.example.eoceanrobocall.service.AdminDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AdminDetailsController {
    @Autowired
    private AdminDetailsService service;
//    @Autowired
//    private BCryptPasswordEncoder passwordEncoder;

    @PostMapping(value = "/addAdmin", produces = MediaType.APPLICATION_JSON_VALUE)
    public AdminDetails addAdmin(@RequestBody AdminDetails adminDetails){
       // adminDetails.setPassword(passwordEncoder.encode(adminDetails.getPassword()));
        return service.saveAdminDetails(adminDetails);
    }

    @GetMapping(value = "/getAdminDetails", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<AdminDetails> getAdminDetails(){
        return service.getAdminDetails();
    }

}
