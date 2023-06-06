package com.spring.springboot.rest.service;

import com.spring.springboot.rest.entities.Employee;

import java.util.List;

public interface EmployeeService {
    Employee getEmployee(int id);
    public List<Employee> getAllEmployees();
    public void saveEmployee(Employee employee);
    public void deleteEmployee(int id);
    public List<Employee> findAllByName(String name);

}
