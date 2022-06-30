package com.example.eoceanrobocall.service;


import com.example.eoceanrobocall.entity.AdminDetails;
import com.example.eoceanrobocall.repository.AdminDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminDetailsService {
    @Autowired
    private AdminDetailsRepository adminDetailsRepository;


    public List<AdminDetails> getAdminDetails(){
        return adminDetailsRepository.findAll();
    }

    public AdminDetails saveAdminDetails(AdminDetails adminDetails){
        adminDetailsRepository.save(adminDetails);
         return adminDetails;
    }

}
