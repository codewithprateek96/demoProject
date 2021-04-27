package com.example.demo.entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank(message = "First Name is mandatory")
    private String firstName;
    @NotBlank
    private String lastName;
    @NotNull
    private long employmentID;
    @NotNull
    private String startDate;
    @NotBlank
    private String designation;
    private String endDate;
    @NotBlank
    private String status;
    @NotBlank
    private String dob;
    @NotBlank
    private String reportingManager;
    @NotBlank
    private String gender;
    @NotBlank
    private String bloodGroup;
    @NotBlank
    private String address;

    @OneToMany(targetEntity = Dependants.class, cascade = CascadeType.ALL)
    @JoinColumn(name="emp_fk", referencedColumnName = "id")
    private List<Dependants> dependants;

    @OneToMany(targetEntity = EducationalQualification.class, cascade = CascadeType.ALL)
    @JoinColumn(name="edu_fk", referencedColumnName = "id")
    private List<EducationalQualification> educationalQualifications;

}
