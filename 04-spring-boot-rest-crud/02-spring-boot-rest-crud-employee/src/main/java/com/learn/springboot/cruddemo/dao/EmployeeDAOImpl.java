package com.learn.springboot.cruddemo.dao;

import com.learn.springboot.cruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO{

    private EntityManager entityManager;

    @Autowired
    public EmployeeDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }



    @Override
    public List<Employee> findAll() {

        TypedQuery<Employee> employeeTypedQuery = entityManager.createQuery("FROM Employee", Employee.class);

        List<Employee> theEmployees = employeeTypedQuery.getResultList();

        return theEmployees;
    }

    @Override
    public Employee findById(int id) {
        return entityManager.find(Employee.class, id);
    }

    @Override
    public Employee Save(Employee employee) {
        return entityManager.merge(employee);
    }

    @Override
    public void deleteById(int id) {
        Employee theEmployee = entityManager.find(Employee.class, id);
        entityManager.remove(theEmployee);
    }
}
