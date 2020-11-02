package com.databases.employee.service;

import com.databases.employee.entity.Employee;
import com.databases.employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository repository;

    public Employee saveEmployee(Employee employee){
        return repository.save(employee);
    }
    public List<Employee> saveEmployees(List<Employee> employees){
        return repository.saveAll(employees);
    }
    public List<Employee> getEmployees(){
        return repository.findAll();
    }
    public Employee getEmployeeById(int id){
        return repository.findById(id).orElse(null);
    }
    public Employee getEmployeeByName(String name){
        return repository.findByName(name);
    }

    public String deleteEmployee(int id){
        repository.deleteById(id);
        return "Employee Removed !"+id;
    }
    public Employee updateEmployee(Employee employee){
        Employee currentEmployee=repository.findById(employee.getId()).orElse(null);
        currentEmployee.setName(employee.getName());
        currentEmployee.setEmail(employee.getEmail());
        return repository.save(currentEmployee);
    }



}
