package com.spring.springboot.rest.dao;

import com.spring.springboot.rest.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
   public List<Employee> findAllByName(String name);
}
