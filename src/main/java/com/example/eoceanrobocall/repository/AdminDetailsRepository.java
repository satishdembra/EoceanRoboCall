package com.example.eoceanrobocall.repository;

import com.example.eoceanrobocall.entity.AdminDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  AdminDetailsRepository extends JpaRepository<AdminDetails, Integer> {
}
