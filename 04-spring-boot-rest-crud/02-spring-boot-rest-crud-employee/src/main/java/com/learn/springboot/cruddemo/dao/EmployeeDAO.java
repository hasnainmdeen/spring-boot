package com.learn.springboot.cruddemo.dao;

import com.learn.springboot.cruddemo.entity.Employee;
import jakarta.persistence.criteria.CriteriaBuilder;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAll();

    Employee findById(int id);

    Employee Save(Employee employee);

    void deleteById(int id);
}
