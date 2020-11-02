package com.databases.employee.controller;

import com.databases.employee.entity.Employee;
import com.databases.employee.service.EmployeeService;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService service;

    @PostMapping("/addEmployee")
    public Employee addEmployee(@RequestBody Employee employee){
        return service.saveEmployee(employee);
    }

    @PostMapping("/addEmployees")
    public List<Employee> addEmployees(@RequestBody List<Employee> employees){
        return service.saveEmployees(employees);
    }

    @GetMapping("/employees")
    public List<Employee> findAllEmployees(){
        return service.getEmployees();
    }
    @GetMapping("/employee/{id}")
    public Employee findProductById(@PathVariable int id){
        return service.getEmployeeById(id);
    }

    @GetMapping("/employee/{name}")
    public Employee findProductByName(@PathVariable String name){
        return service.getEmployeeByName(name);
    }

    @PutMapping("/update")
    public Employee updateEmployee(@RequestBody Employee employee){
        return service.updateEmployee(employee);
    }

    @DeleteMapping("/delete")
    public String  deleteEmployee(@RequestBody int id){
        return service.deleteEmployee(id);
    }




}
