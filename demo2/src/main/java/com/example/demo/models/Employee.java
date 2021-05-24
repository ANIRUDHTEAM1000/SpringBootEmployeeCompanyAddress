package com.example.demo.models;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
@Data
public class Employee {
    @Id
    private Long eid;
    private String name;
    @OneToOne(cascade = CascadeType.ALL)
    private Address address;

}
