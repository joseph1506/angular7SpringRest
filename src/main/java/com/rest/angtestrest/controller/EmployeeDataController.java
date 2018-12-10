package com.rest.angtestrest.controller;

import com.rest.angtestrest.dto.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
public class EmployeeDataController {

    @GetMapping("/employees")
    public List<Employee> getEmployees(){
        List<Employee> employees = new ArrayList<>();
        employees.add(getEmployee("Joseph", "1"));
        employees.add(getEmployee("James", "2"));
        employees.add(getEmployee("Jeane", "3"));
        employees.add(getEmployee("Jack", "4"));
        return employees;
    }

    private Employee getEmployee(String name, String id) {
        return new Employee(name,id);
    }


}
