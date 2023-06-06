package com.spring.springboot.rest.controllers;

import com.spring.springboot.rest.entities.Employee;
import com.spring.springboot.rest.exeption_handle.NoSuchEmployeeException;
import com.spring.springboot.rest.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class FirstRestController {
    @Autowired
    private EmployeeService employeeService;
    @GetMapping("/")
    public String show() {
        return "it works";
    }
    @GetMapping("/employees")
    public List<Employee> showEmployees() {
        return employeeService.getAllEmployees();
    }
    @GetMapping("/employees/{id}")
    public Employee showEmployee(@PathVariable int id) throws NoSuchEmployeeException {
        Employee employee = employeeService.getEmployee(id);
        if (employee == null) {
            throw new NoSuchEmployeeException("There is no employee with ID = " + id + " in Database");
        }
        return employee;
    }
    @GetMapping("/employees/name/{name}")
    public List<Employee> showEmployeesByName(@PathVariable String name) throws NoSuchEmployeeException {
        List<Employee> employees = employeeService.findAllByName(name);
        if (employees == null) {
            throw new NoSuchEmployeeException("There is no employee with name = " + name + " in Database");
        }
        return employees;
    }
    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee) {
        employeeService.saveEmployee(employee);
        return employee;
    }
    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee) {
        employeeService.saveEmployee(employee);
        return employee;
    }
    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable int id) throws NoSuchEmployeeException {
        Employee employee = employeeService.getEmployee(id);
        if (employee == null) {
            throw new NoSuchEmployeeException("There is no employee with ID = " + id + " in Database");
        }
        employeeService.deleteEmployee(id);
        return "Employee with ID = " + id + " was deleted";
    }
}
