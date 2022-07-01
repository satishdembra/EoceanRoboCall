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
    @Column(nullable = true)
    private String campaign_name;
//    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
//    private Timestamp campaign_execution_date;
    @Column(nullable = true)
    private String campaign_execution_date;
    @Column(nullable = true)
    private String csv_file_path;
    @Column(nullable = true)
    private String prompt_file_path;
    @Column(nullable = true)
    private int total_accepted_numbers;
    @Column(nullable = true)
    private int total_uploaded_numbers;
    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "userId", referencedColumnName = "id")
    private User user;
    @Column(nullable = true)
    private int campaign_status;
    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "dtmf_type", referencedColumnName = "call_typeId")
    private Call_Type call_type;
    @Column(nullable = true)
    private String clientt;
    private int retry_times;
    private int limits;
    private int retry_counter;
    private int retry_duration;
}
