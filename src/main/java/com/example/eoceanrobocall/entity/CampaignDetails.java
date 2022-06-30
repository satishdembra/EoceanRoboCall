package com.example.eoceanrobocall.entity;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "campaign_details")
public class CampaignDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int campaign_id;
    private String campaign_name;
//    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
//    private Timestamp campaign_execution_date;
    private String campaign_execution_date;
    private String csv_file_path;
    private String prompt_file_path;
    private int total_accepted_numbers;
    private int total_uploaded_numbers;
    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "userId", referencedColumnName = "id")
    private User user;
    private int campaign_status;
    private int dtmf_type;
    private String clientt;
    private int retry_times;
    private int limits;
    private int retry_counter;
    private int retry_duration;
}
