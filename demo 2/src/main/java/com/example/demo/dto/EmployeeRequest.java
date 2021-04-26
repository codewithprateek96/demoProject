package com.example.demo.dto;

import com.example.demo.entity.Dependants;
import com.example.demo.entity.EducationalQualification;
import com.example.demo.entity.Employee;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EmployeeRequest {


    private int id;
    private String firstName;
    private String lastName;
    private long employmentID;
    private String startDate;
    private String designation;
    private String endDate;
    private String status;
    private String dob;
    private String reportingManager;
    private String gender;
    private String bloodGroup;
    private String address;

    private List<Dependants> dependantsList;
    private List<EducationalQualification> educationalQualificationList;

}
