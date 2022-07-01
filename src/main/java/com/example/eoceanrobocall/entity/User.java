package com.example.eoceanrobocall.entity;

import com.example.eoceanrobocall.utils.ListToStringConverter;
import com.sun.istack.NotNull;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GeneratorType;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;


@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user_details")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @NotNull
    private String username;
    private String password;
    @CreationTimestamp
    private Timestamp createdDate;
    private int account_code;
    private boolean status;
    private String extraFields;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", createdDate=" + createdDate +
                ", account_code=" + account_code +
                ", extraFields='" + extraFields + '\'' +
                '}';
    }
    boolean isEnabled(){
        return status;
    }
}
