package com.example.eoceanrobocall.service;

import com.example.eoceanrobocall.RequestResponseModels.Response.ResponseStats;
import com.example.eoceanrobocall.entity.Prompt;
import com.example.eoceanrobocall.repository.PromptRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PromptService {
    private PromptRepository promptRepository;
    public List<Prompt> getPromptList(){
        return promptRepository.findAll();
    }
    public Prompt savePrompt(Prompt prompt){
        promptRepository.save(prompt);
        return prompt;
    }
    public ResponseStats getStatsbyCampaign(int campaign_id){
      return null;
    }
    public ResponseStats getStatsbyAccount(int id){
        return null;
    }

}
