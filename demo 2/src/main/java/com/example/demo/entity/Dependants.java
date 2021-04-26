package com.example.demo.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Dependants {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int dId;
    @NotBlank(message = "First Name is mandatory")
    private String firstName;
    private String lastName;
    @NotBlank
    private String gender;
    @NotBlank
    private String dob;
    @NotBlank
    private String relationship;
}
