package com.learn.springboot.cruddemo.service;

import com.learn.springboot.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();
}
