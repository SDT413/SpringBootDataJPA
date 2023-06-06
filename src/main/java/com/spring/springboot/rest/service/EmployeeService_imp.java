package com.spring.springboot.rest.service;

import com.spring.springboot.rest.dao.EmployeeRepository;
import com.spring.springboot.rest.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService_imp implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Override
    public Employee getEmployee(int id) {
        //long version
        /*Optional<Employee> optional = employeeRepository.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        }
        return null;*/
        //short version
        return employeeRepository.findById(id).orElse(null);
    }
    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }
    @Override
    public void saveEmployee(Employee employee) {
        employeeRepository.save(employee);
    }
    @Override
    public void deleteEmployee(int id) {
        employeeRepository.deleteById(id);
    }
    @Override
    public List<Employee> findAllByName(String name) {
        return employeeRepository.findAllByName(name);
    }

}
