package com.example.eoceanrobocall.entity;

import lombok.*;

import javax.persistence.*;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Call_type")
public class Call_Type {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "userId", referencedColumnName = "id")
    private User user;
    private String title;
}
