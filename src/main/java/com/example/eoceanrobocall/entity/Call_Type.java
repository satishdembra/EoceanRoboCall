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
    @EmbeddedId
    private Call_TypeId call_typeId;
    private String title;
}
