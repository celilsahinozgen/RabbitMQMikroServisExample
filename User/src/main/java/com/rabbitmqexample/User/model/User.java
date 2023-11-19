package com.rabbitmqexample.User.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "USERDATA")
public class User {


    public static final String ZAMANPATTERIN = "yyyy-MM-dd HH:mm:ss";
    public static final String YILPATTERIN = "yyyy-MM-dd";


    @Id
//    @GeneratedValue(generator = "UUID")
//     @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
//     @Column(updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long  id;



    @Column(unique = true, nullable = true)
    private String ozelNumara;

    @PrePersist
    protected void onCreate() {
        ozelNumara = UUID.randomUUID().toString();
    }

    @Column(name = "first_name")
    String  firstName;

    @Column(name = "last_name")
    String lastName;

    @Column(name = "email")
    String  email;

    @Column(name = "gender")
    String  gender;

    @Column(name = "money")
    Integer userBalance;


    @DateTimeFormat(pattern = ZAMANPATTERIN)
    @Column(name = "birthday")
    LocalDateTime createDate= LocalDateTime.now();

    @DateTimeFormat(pattern = ZAMANPATTERIN)
    @Column(name = "updateTime")
    LocalDateTime upDatetime= LocalDateTime.now();
}
