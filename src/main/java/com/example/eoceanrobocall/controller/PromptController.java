package com.example.eoceanrobocall.controller;


import com.example.eoceanrobocall.RequestResponseModels.Response.ResponseStats;
import com.example.eoceanrobocall.entity.Prompt;
import com.example.eoceanrobocall.service.PromptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/prompt")
public class PromptController {
    @Autowired
    private PromptService service;
    @GetMapping(value = "/campaign/stats/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseStats> campaignStats(@PathVariable int id){
        HttpHeaders responseHeaders = new HttpHeaders();
        return new ResponseEntity<>(service.getStatsbyCampaign(id), responseHeaders, HttpStatus.OK);
    }
    @GetMapping(value = "/account/stats/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseStats> getAllCampaignStats( @PathVariable int id){
        HttpHeaders responseHeaders = new HttpHeaders();
        return new ResponseEntity<>(service.getStatsbyAccount(id), responseHeaders, HttpStatus.OK);
    }
    @PostMapping(value = "/addprompt", produces = MediaType.APPLICATION_JSON_VALUE)
    public Prompt savePrompt(@RequestBody Prompt prompt){
        return service.savePrompt(prompt);
    }

    @GetMapping(value = "/getprompt", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Prompt> getPrompts(){
        return service.getPromptList();
    }

}
//ResponseEntity
//Mapper
