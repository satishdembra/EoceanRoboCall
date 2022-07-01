package com.example.eoceanrobocall.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Call_TypeId implements Serializable {
    private int id;
    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "userId", referencedColumnName = "id")
    private User user;


}
