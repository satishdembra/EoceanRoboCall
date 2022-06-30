package com.example.eoceanrobocall.controller;



import com.example.eoceanrobocall.RequestResponseModels.Response.ResponseStats;
import com.example.eoceanrobocall.entity.CampaignDetails;
import com.example.eoceanrobocall.service.CampaignDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/campaign")
public class CampaignDetailsController {
    @Autowired
    private CampaignDetailsService service;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public CampaignDetails saveCampaignDetails(@RequestBody CampaignDetails campaignDetails){
        return service.saveCampaignDetails(campaignDetails);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CampaignDetails> getCampaignDetails(){
        return service.getCampaignDetails();
    }

    @GetMapping(value = "/stats/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseStats> campaignStats(@PathVariable int id){
        HttpHeaders responseHeaders = new HttpHeaders();
        return new ResponseEntity<>(service.getResponseStats(id), responseHeaders, HttpStatus.OK);
    }
    @GetMapping(value = "/allstats/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseStats> getAllCampaignStats( @PathVariable int id){
        HttpHeaders responseHeaders = new HttpHeaders();
        return new ResponseEntity<>(service.getAllCampaignStats(id), responseHeaders, HttpStatus.OK);
    }
}
