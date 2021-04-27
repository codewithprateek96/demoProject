package com.example.demo.controller.test;

import com.example.demo.controller.EmployeeController;
import com.example.demo.entity.Dependants;
import com.example.demo.entity.EducationalQualification;
import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class EmployeeControllerTest {

    @Autowired
    EmployeeRepository employeeRepository;


    @Test
    public void testAddEmp()
    {
        Employee employee = getEntity();
        employeeRepository.save(employee);

        Employee emp = employeeRepository.getOne(1);
        assertEquals(1,emp.getId());
    }



    public Employee getEntity()
    {

        Employee employee = new Employee();
        List<Dependants> dependantsList = new ArrayList<>();
        Dependants dependants = new Dependants();
        List<EducationalQualification> educationalQualificationList = new ArrayList<>();
        EducationalQualification educationalQualification = new EducationalQualification();
        employee.setAddress("Delhi");
        employee.setGender("Male");
        employee.setDob("1 January 2010");
        employee.setStatus("Working");
        employee.setDesignation("Developer");
        employee.setEmploymentID(101);
        employee.setBloodGroup("O+");
        employee.setReportingManager("Prat");
        employee.setEndDate("10 March 2030");
        employee.setStartDate("30 March 2020");
        employee.setLastName("Kumar");
        employee.setId(1);
        employee.setFirstName("Prateek");

        dependants.setRelationship("Friend");
        dependants.setGender("Male");
        dependants.setDob("1 March 1996");
        dependants.setLastName("Singh");
        dependants.setFirstName("Harry");
        dependants.setDId(1);
        dependantsList.add(dependants);
        employee.setDependants(dependantsList);

        educationalQualification.setPercentage("90%");
        educationalQualification.setType("B.tech");
        educationalQualification.setInstitution("CVRCE");
        educationalQualification.setAddress("Delhi");
        educationalQualification.setStartDate("30 March 2021");
        educationalQualification.setEndDate("30 March 2030");
        educationalQualification.setId(1);
        educationalQualificationList.add(educationalQualification);
        employee.setEducationalQualifications(educationalQualificationList);

        return employee;

    }


}
