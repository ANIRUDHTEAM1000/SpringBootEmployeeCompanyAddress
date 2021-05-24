package com.example.demo.models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Company {
    @Id
    private Long cid;
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    private Address address;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn
    private List<Employee> employees;
}
