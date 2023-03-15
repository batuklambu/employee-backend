package com.tek.employeebackend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Employees {
@Id
@GeneratedValue
    private int id;
    private String employeeName;

    private String employeeLastName;

    private String employeeDesignation;

    private int salary;






}
