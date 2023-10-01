package com.learn.springboot.cruddemo.dao;

import com.learn.springboot.cruddemo.entity.Instructor;

public interface AppDAO {

    void save(Instructor instructor);

    Instructor findInstructorById(int id);

    void deleteInstructorById(int id);
}
