package com.example.demo.repository;

import com.example.demo.entity.Employee;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface EmployeeRepoElastic {
    List<Employee> getAllEmpFromElastic();
}
