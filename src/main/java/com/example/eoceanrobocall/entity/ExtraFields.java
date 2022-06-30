package com.example.eoceanrobocall.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Extras")
public class ExtraFields {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String order_id;
    private String shipment;
    private long amount;
    private String acc_num;
    private Date due_date;
    @OneToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "prompt_id", referencedColumnName = "id")
    private Prompt prompt;
}
