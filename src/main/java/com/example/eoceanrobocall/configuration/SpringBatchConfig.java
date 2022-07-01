package com.example.eoceanrobocall.configuration;

import com.example.eoceanrobocall.Processor.Processor;
import com.example.eoceanrobocall.RequestResponseModels.Request.CSVFileRequest;
import com.example.eoceanrobocall.entity.CampaignDetails;
import com.example.eoceanrobocall.repository.CampaignDetailsRepository;
import com.example.eoceanrobocall.service.AuthUserDetailsService;
import lombok.AllArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.data.RepositoryItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Component;

@Configuration
@EnableBatchProcessing
@AllArgsConstructor
public class SpringBatchConfig {

//    private JobBuilderFactory jobBuilderFactory;
//    private StepBuilderFactory stepBuilderFactory;
//    private CampaignDetailsRepository campaignDetailsRepository;
//    private AuthUserDetailsService authUserDetailsService;
//    @Bean
//    public FlatFileItemReader<CSVFileRequest> reader(){
//        FlatFileItemReader<CSVFileRequest> itemReader = new FlatFileItemReader();
//        itemReader.setResource(new FileSystemResource("src/main/resources/file.csv"));
//        itemReader.setName("csvFile");
//        itemReader.setLinesToSkip(1);
//        itemReader.setLineMapper(lineMapper());
//        return itemReader;
//    }
//
//    String getFields(){
//        return authUserDetailsService.getCurrentUser().getExtraFields();
//    }
//    private LineMapper<CSVFileRequest> lineMapper() {
//
//        DefaultLineMapper<CSVFileRequest> lineMapper = new DefaultLineMapper<>();
//        DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
//        lineTokenizer.setDelimiter(",");
//        lineTokenizer.setNames(getFields());
//        lineTokenizer.setStrict(false);
//
//
//
//        BeanWrapperFieldSetMapper<CSVFileRequest> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
//        fieldSetMapper.setTargetType(CSVFileRequest.class);
//        fieldSetMapper.setStrict(false);
//
//        lineMapper.setLineTokenizer(lineTokenizer);
//        lineMapper.setFieldSetMapper(fieldSetMapper);
//        return lineMapper;
//
//    }
////    CSVFileRequest mapFieldSet(FieldSet fieldSet){
////        CSVFileRequest csvFileRequest = new CSVFileRequest();
////        csvFileRequest.setCaller_id(fieldSet.readString("caller_id"));
////        csvFileRequest.setOrder_id(fieldSet.readString("order_id"));
////        csvFileRequest.setShipment(fieldSet.readString("shipment"));
////        csvFileRequest.setAmount(fieldSet.readLong("amount",0));
////        csvFileRequest.setAcc_num(fieldSet.readString("acc_num"));
////        csvFileRequest.setAcc_num(fieldSet.readString("due_date"));
////        return csvFileRequest;
////
////    }
//    @Bean
//    public Processor processor(){
//        return new Processor();
//
//    }
//    @Bean
//    public RepositoryItemWriter<CampaignDetails> writer(){
//        RepositoryItemWriter<CampaignDetails> writer = new RepositoryItemWriter<>();
//        writer.setRepository(campaignDetailsRepository);
//        writer.setMethodName("save");
//        return writer;
//    }
//    @Bean
//    public Step Step1 (){
//        return stepBuilderFactory.get("csv-step").<CSVFileRequest, CampaignDetails>chunk(500)
//                .reader(reader()).writer(writer()).processor(processor()).build();
//    }
//    @Bean
//    public Job runJob(){
//        return jobBuilderFactory.get("importCustomerInfo").flow(Step1()).end().build();
//    }

}
