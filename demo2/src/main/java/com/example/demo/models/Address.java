package com.example.demo.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Address {
    @Id
    private Long aid;
    private String city;
}
