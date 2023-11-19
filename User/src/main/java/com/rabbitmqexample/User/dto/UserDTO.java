package com.rabbitmqexample.User.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

public class UserDTO {



    String  firstName;
    String lastName;
    String  email;
    String  gender;
    Integer userBalance;
    LocalDateTime createDate;
    LocalDateTime upDatetime;



    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;

    }


    public Integer getUserBalance() {
        return userBalance;
    }

    public void setUserBalance(Integer userBalance) {
        this.userBalance = userBalance;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public LocalDateTime getUpDatetime() {
        return upDatetime;
    }

    public void setUpDatetime(LocalDateTime upDatetime) {
        this.upDatetime = upDatetime;
    }
}
