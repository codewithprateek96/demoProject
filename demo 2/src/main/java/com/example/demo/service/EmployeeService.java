package com.example.demo.service;


import com.example.demo.dto.EmployeeRequest;
import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepoElastic;
import com.example.demo.repository.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    EmployeeRepoElastic employeeRepoElastic;



    public Employee saveEmployee(EmployeeRequest employeeRequest) {
        Employee employee = null;
        employee = getEntity(employeeRequest);

        return employeeRepository.save(employee);
    }

    private Employee getEntity(EmployeeRequest employeeRequest) {
        if (employeeRequest != null) {
            Employee employee = new Employee();
            employee.setId(employeeRequest.getId());
            employee.setEmploymentID(employeeRequest.getEmploymentID());
            employee.setFirstName(employeeRequest.getFirstName());
            employee.setLastName(employeeRequest.getLastName());
            employee.setStartDate(employeeRequest.getStartDate());
            employee.setDesignation(employeeRequest.getDesignation());
            employee.setEndDate(employeeRequest.getEndDate());
            employee.setStatus(employeeRequest.getStatus());
            employee.setDob(employeeRequest.getDob());
            employee.setReportingManager(employeeRequest.getReportingManager());
            employee.setGender(employeeRequest.getGender());
            employee.setBloodGroup(employeeRequest.getBloodGroup());
            employee.setAddress(employeeRequest.getAddress());
            employee.setDependants(employeeRequest.getDependantsList());
            employee.setEducationalQualifications(employeeRequest.getEducationalQualificationList());
            return employee;
        } else {
            return null;
        }

    }

    public void deleteEmp(int id) {
        Employee employee = employeeRepository.getOne(id);
        employeeRepository.delete(employee);
    }

    public List<Employee> getAllEmp()  {
        return employeeRepoElastic.getAllEmpFromElastic();
    }
}



   //    public Employee saveEmployee(EmployeeRequest employeeRequest)

//    {
//        Employee employee = new Employee();
//        //DependentRequest dependentRequest = new DependentRequest();
//        Dependants dependants = new Dependants();
//        List<DependentRequest> dependentRequestList = employeeRequest.getDependantRequest();
//        List<Dependants> dependantList = new ArrayList<>();
//        for(int i=0;i<dependentRequestList.size();i++)
//        {
//            dependants.setDId(dependentRequestList.get(i).getdId());
//            dependants.setFirstName(dependentRequestList.get(i).getFirstName());
//            dependants.setLastName(dependentRequestList.get(i).getLastName());
//            dependants.setGender(dependentRequestList.get(i).getGender());
//            dependants.setDob(dependentRequestList.get(i).getDob());
//            dependants.setRelationship(dependentRequestList.get(i).getRelationship());
//            dependantList.add(dependants);
//            //dependantRepository.save(dependants);
//
//
//        }
//        System.out.println("dependentRequestList.size(): "+dependentRequestList.size()+ " dependantList:"+dependantList.size());
//        employee.setId(employeeRequest.getId());
//        employee.setEmploymentID(employeeRequest.getEmploymentID());
//        employee.setFirstName(employeeRequest.getFirstName());
//        employee.setLastName(employeeRequest.getLastName());
//        employee.setStartDate(employeeRequest.getStartDate());
//        employee.setDesignation(employeeRequest.getDesignation());
//        employee.setEndDate(employeeRequest.getEndDate());
//        employee.setStatus(employeeRequest.getStatus());
//        employee.setDob(employeeRequest.getDob());
//        employee.setReportingManager(employeeRequest.getReportingManager());
//        employee.setGender(employeeRequest.getGender());
//        employee.setBloodGroup(employeeRequest.getBloodGroup());
//        employee.setAddress(employeeRequest.getAddress());
//        employee.setDependants(dependantList);
//
//        //Employee emp = new Employee();
//        EducationalQualification educationalQualification = new EducationalQualification();
//        List<EducationalQualificationRequest> educationalQualificationRequestList = employeeRequest.getEducationalQualificationRequest();
//        List<EducationalQualification> educationalQualificationList = new ArrayList<>();
//        for(int i=0;i<educationalQualificationRequestList.size();i++)
//        {
//            educationalQualification.setId(educationalQualificationRequestList.get(i).getId());
//            educationalQualification.setAddress(educationalQualificationRequestList.get(i).getAddress());
//            educationalQualification.setEndDate(educationalQualificationRequestList.get(i).getEndDate());
//            educationalQualification.setStartDate(educationalQualificationRequestList.get(i).getStartDate());
//            educationalQualification.setInstitution(educationalQualificationRequestList.get(i).getInstitution());
//            educationalQualification.setType(educationalQualificationRequestList.get(i).getType());
//            educationalQualification.setPercentage(educationalQualificationRequestList.get(i).getPercentage());
//            educationalQualificationList.add(educationalQualification);
//
//        }
//        employee.setEducationalQualifications(educationalQualificationList);
//
//
//        return employeeRepository.save(employee);
//    }



