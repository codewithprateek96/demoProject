package com.example.demo.service;
import com.example.demo.controller.EmployeeController;
import com.example.demo.dto.EmployeeRequest;
import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepoElastic;
import com.example.demo.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    EmployeeRepoElastic employeeRepoElastic;

    Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    public Employee saveEmployee(EmployeeRequest employeeRequest) {
        Employee employee = null;
        employee = getEntity(employeeRequest);
        logger.info("Employee data added.");
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
            logger.error("Payload is null.");
            return null;
        }

    }

    public void deleteEmp(int id) {
        Employee employee = employeeRepository.getOne(id);
        logger.info("Employee Deleted.");
        employeeRepository.delete(employee);
    }

    public List<Employee> getAllEmp()  {
        logger.info("All Employees returned.");
        return employeeRepoElastic.getAllEmpFromElastic();
    }
}