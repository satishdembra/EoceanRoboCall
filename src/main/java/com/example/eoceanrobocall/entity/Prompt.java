package com.example.eoceanrobocall.entity;

import com.sun.istack.NotNull;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@ToString
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "th_table_prompt")
public class Prompt {

    @Id
    private int id;

    @NotNull
    private String caller_id;

     private int retry_times;
//    private int retry_times2;
//    private int retry_times3;
    private int DTMF;
//    private int DTMF1;
//    private int DTMF2;
    private String response;
    private String prompt;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "campaign_id", referencedColumnName = "campaign_id")
    private CampaignDetails campaign;
    private String number;
//    private String order_id;
//    private String shipment;
//    private long amount;
//    private String acc_num;
//    private Timestamp due_date;
    private int status;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private Timestamp start_datetime;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private Timestamp end_datetime;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private Timestamp execution_time;
    private int ST_time;
    private int Units;
    private int ring_time;
    private String recordingfile;
    private String account_code;//in campaign
    private String retry_limit;
    private String soundname;
}
