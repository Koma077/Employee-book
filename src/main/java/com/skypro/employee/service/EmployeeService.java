package com.skypro.employee.service;

import com.skypro.employee.model.Employee;
import com.skypro.employee.record.EmployeeReqest;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.OptionalInt;

@Service
public class EmployeeService {
    private final Map<Integer, Employee> employees = new HashMap<>();

    public Collection<Employee> getAllEmployees(){
        return this.employees.values();
    }

    public Employee addEmployee(EmployeeReqest employeeReqest){
        if(employeeReqest.getFirstName() == null || employeeReqest.getLastName() == null){
            throw new IllegalArgumentException("Error");
        }
        Employee employee = new Employee(employeeReqest.getLastName(),
                employeeReqest.getFirstName(),
                employeeReqest.getDepartment(),
                employeeReqest.getSalary());
        this.employees.put(employee.getId(), employee);
        return employee;
    }
    public int getSalarySum(){
        return employees.values().stream().mapToInt(e->e.getSalary()).sum();
    }
    public OptionalInt findMinSalary() {
        return employees.values().stream().mapToInt(e->e.getSalary()).min();
    }
    public OptionalInt findMaxSalary(){
        return employees.values().stream().mapToInt(e->e.getSalary()).max();
    }
    public java.util.OptionalDouble findAverageSalary(){
        return employees.values().stream().mapToInt(e->e.getSalary()).average();
    }
}

