package com.example.eoceanrobocall.service;


import com.example.eoceanrobocall.RequestResponseModels.Response.ResponseStats;
import com.example.eoceanrobocall.entity.CampaignDetails;
import com.example.eoceanrobocall.repository.CampaignDetailsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CampaignDetailsService {
    @Autowired
    private CampaignDetailsRepository campaignDetailsRepository;
    public List<CampaignDetails> getCampaignDetails(){
         return campaignDetailsRepository.findAll();
    }
    public CampaignDetails saveCampaignDetails(CampaignDetails campaignDetails){
        campaignDetailsRepository.save(campaignDetails);
         return campaignDetails;
    }
    public ResponseStats getResponseStats2(int campaign_id){
        //String cmd = "{ aggregate: 'th_table_prompt', pipeline: [ { $match: { campaign_id: { $eq: "+ Integer.toString(campaign_id) +" } } }," +
         //       "{ $group: {_id:\"$response\", count:{$sum:1}}} ], cursor: { } }";
        return null;
    }
    public ResponseStats getResponseStats(int campaign_id){
        String cmd = "{ aggregate: 'th_table_prompt', pipeline: [ { $match: { campaign_id: { $eq: "+ Integer.toString(campaign_id) +" } } }," +
                     "{ $group: {_id:\"$response\", count:{$sum:1}}} ], cursor: { } }";
        return null;
    }
    public ResponseStats getAllCampaignStats(int id){
        return null;
    }

}
