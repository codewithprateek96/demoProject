package com.example.demo.controller;

import com.example.demo.dto.EmployeeRequest;
import com.example.demo.entity.Employee;

import com.example.demo.repository.EmployeeRepoElastic;
import com.example.demo.repository.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import com.example.demo.service.EmployeeService;

import java.io.IOException;
import java.security.SecureRandom;
import java.util.List;

@RestController
@RequestMapping("/rest")
public class EmployeeController {


    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/")
    public String user()
    {
        return "Welcome";
    }

    @PostMapping("/addEmp")
    public Employee addEmp(@RequestBody EmployeeRequest employeeRequest)
    {
      return  employeeService.saveEmployee(employeeRequest);
    }

    @GetMapping("/findAll")
    public List<Employee> findAllEmployees()
    {
        return employeeRepository.findAll();
    }

    //elastic search find all
    @GetMapping(value="/allEmps", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Employee> getAllEmp()  {
        return employeeService.getAllEmp();
    }

    @PutMapping("/updateEmp")
    public Employee updateEmp(@RequestBody EmployeeRequest employeeRequest)
    {
        return  employeeService.saveEmployee(employeeRequest);
    }
    @DeleteMapping("/deleteEmp/{id}")
    public String deleteEmp(@PathVariable int id)
    {
        employeeService.deleteEmp(id);
        return "Employee Deleted";
    }

}

