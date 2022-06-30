package com.example.eoceanrobocall.repository;


import com.example.eoceanrobocall.RequestResponseModels.Response.ResponseStats;
import com.example.eoceanrobocall.entity.CampaignDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CampaignDetailsRepository extends JpaRepository<CampaignDetails, Integer> {


}
