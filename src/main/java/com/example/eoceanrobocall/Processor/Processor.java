package com.example.eoceanrobocall.Processor;

import com.example.eoceanrobocall.RequestResponseModels.Request.CSVFileRequest;
import com.example.eoceanrobocall.entity.CampaignDetails;
import org.springframework.batch.item.ItemProcessor;


public class Processor implements ItemProcessor<CSVFileRequest, CampaignDetails> {




    @Override
    public CampaignDetails process(CSVFileRequest csvFileRequest) throws Exception {
        return null;
    }
}
