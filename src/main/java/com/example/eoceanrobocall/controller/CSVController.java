package com.example.eoceanrobocall.controller;

import com.example.eoceanrobocall.Exception.Exception;
import lombok.AllArgsConstructor;
import org.springframework.batch.core.*;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/campaigns")
@AllArgsConstructor
public class CSVController {
    private JobLauncher jobLauncher;
    private Job job;


    public void importCsvToTable(){
        JobParameters jobParameters = new JobParametersBuilder().addLong("startAt", System.currentTimeMillis()).toJobParameters();
        try{
            jobLauncher.run(job, jobParameters);

        } catch (JobInstanceAlreadyCompleteException | JobExecutionAlreadyRunningException | JobParametersInvalidException | JobRestartException e) {
            e.printStackTrace();
            throw new Exception(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
